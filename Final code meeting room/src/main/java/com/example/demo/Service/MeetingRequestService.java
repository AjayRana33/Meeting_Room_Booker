package com.example.demo.Service;

import com.example.demo.Entity.*;
import com.example.demo.Status.AvailabiliityStatus;
import com.example.demo.Repository.*;
import com.example.demo.VerifyMeetingTime.ValidateMeetingSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class MeetingRequestService {

    @Autowired
    public AdminRepo adminRepo;
    @Autowired
    public DateAndTimeDetailsRepo dateAndTimeDetailsRepo;
    @Autowired
    EmployeeDetailsRepo employeeDetailsRepo;
    @Autowired
    MeetingRoomRepo meetingRoomRepo;
    @Autowired
    MeetingsRepo meetingsRepo;
    @Autowired
    ValidateMeetingSchedule validateMeetingSchedule;

    public String createMeetingRequest(String cookie, MeetingRequest meetingRequest) {
        int availableEmployeeCount = 0;
        List<Integer> employeeId = meetingRequest.getParticipantsEmployeeId();
        List<EmployeeDetails> employeeDetailsList = new ArrayList<>();
        for (int i = 0; i < employeeId.size(); i++) {
            EmployeeDetails tempEmployeeDetails = employeeDetailsRepo.findById(employeeId.get(i)).orElse(null);
            employeeDetailsList.add(tempEmployeeDetails);
            if (tempEmployeeDetails.getMeetingAlreadyCommitted() == null) {
                availableEmployeeCount++;
            }
        }
        if (availableEmployeeCount == employeeId.size()) {
            return createMeetingRoom(meetingRequest);
        }
        DateAndTimeDetails requestDateAndTimeDetails = new DateAndTimeDetails();
        requestDateAndTimeDetails.setStartTime(meetingRequest.getStartTime());
        requestDateAndTimeDetails.setEndTime(meetingRequest.getEndTime());
        requestDateAndTimeDetails.setStartDate(meetingRequest.getStartDate());
        requestDateAndTimeDetails.setEndDate(meetingRequest.getEndDate());
        //Map<Integer,Boolean> statusByEmployeeId=new TreeMap<Integer,Boolean>();
        HashSet<Boolean> availabilityStatus = new HashSet<>();
        for (int i = 0; i < employeeDetailsList.size(); i++) {
            employeeDetailsList.get(i).getMeetingAlreadyCommitted().forEach(meetingsObj ->
                    {
                        Boolean status = validateMeetingSchedule.validate(meetingsObj.getDateandtimedetails(), requestDateAndTimeDetails);
                        availabilityStatus.add(status);
                    }
            );
        }
        if (availabilityStatus.contains(false)) {
            return "Cannot create a meeting room";
        } else
            return createMeetingRoom(meetingRequest);
    }

    public String createMeetingRoom(MeetingRequest meetingRequest) {

        Admin admin = new Admin();
        admin.setAdminId(meetingRequest.getOrganizerEmployeeId());
        DateAndTimeDetails dateAndTimeDetails = new DateAndTimeDetails();
        dateAndTimeDetails.setStartTime(meetingRequest.getStartTime());
        dateAndTimeDetails.setEndTime(meetingRequest.getEndTime());
        dateAndTimeDetails.setStartDate(meetingRequest.getStartDate());
        dateAndTimeDetails.setEndDate(meetingRequest.getEndDate());
        dateAndTimeDetails.setMeetingId(meetingRequest.getRequestId());
        MeetingRoom meetingRoom = new MeetingRoom();
        meetingRoom.setMeetingId(meetingRequest.getRequestId());
        meetingRoom.setMeetingDescription(meetingRequest.getMeetingDescription());
        meetingRoom.setDateAndTimeDetails(dateAndTimeDetails);
        meetingRoom.setLocation(meetingRequest.getLocation());
        meetingRoom.setParticipantsEmployeeId(meetingRequest.getParticipantsEmployeeId());
        meetingRoom.setStatus(AvailabiliityStatus.OCCUPIED);
        meetingRoom.setOrganizerEmployeeId(meetingRequest.getOrganizerEmployeeId());
        adminRepo.save(admin);
        meetingRoomRepo.save(meetingRoom);
        for (int i = 0; i < meetingRequest.getParticipantsEmployeeId().size(); i++) {
            Meetings meetings = new Meetings();
            meetings.setMeetingId(meetingRequest.getRequestId());
            meetings.setEmployeeId(meetingRequest.getParticipantsEmployeeId().get(i));
            //meetings.setMeetingId();
            meetingsRepo.save(meetings);
        }
        return "Meeting room created";
    }

    public String deleteMeetingRoom(String cookieAdminDetails,int meetingId,int organizerEmployeeId) {
        MeetingRoom meetingRoom = meetingRoomRepo.findById(meetingId).orElse(null);
        Meetings meetings = meetingsRepo.findByMeetingId(meetingId).orElse(null);
        if (meetingRoom.getOrganizerEmployeeId() == organizerEmployeeId) {
            if (meetings != null) {
                meetingsRepo.deleteByMeetingId(meetingId);
            }
            if (meetingRoom != null) {
                meetingRoomRepo.deleteById(meetingId);
            }
            return "Meeting room deleted.";
        } else {
                return"Cannot delete meeting room.";
        }
    }

    public String updateMeetingRoom(String cookieAdminDetails,MeetingRoom meetingRoom)
    {
        MeetingRoom updateMeetingRoomObj = meetingRoomRepo.findById(meetingRoom.getMeetingId()).orElse(null);
        if(updateMeetingRoomObj!=null) {
            updateMeetingRoomObj.setMeetingDescription(meetingRoom.getMeetingDescription());
            meetingRoomRepo.save(updateMeetingRoomObj);
            return "Meeting room updated.";
        }
        else
        {
            return "Meeting room not found.";
        }
    }
}
