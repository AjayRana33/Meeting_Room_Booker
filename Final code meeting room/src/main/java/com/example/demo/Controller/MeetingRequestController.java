package com.example.demo.Controller;

import com.example.demo.Entity.MeetingRequest;
import com.example.demo.Entity.MeetingRoom;
import com.example.demo.Service.MeetingRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MeetingRequestController {

    @Autowired
    MeetingRequestService meetingRequestService;

    @PostMapping(value = "/createMeetingRoom")
    public String createMeetingRequest(@CookieValue(name = "cookieEmployeeDetails",defaultValue = "EmployeeDetails")String cookieEmployeeDetails,@RequestBody MeetingRequest meetingRequest)
    {
        return meetingRequestService.createMeetingRequest(cookieEmployeeDetails,meetingRequest);
    }
    @DeleteMapping(value="/deleteMeetingRoom")
    public String deleteMeetingRoom(@CookieValue(name="cookieAdminDetails",defaultValue ="cookieAdminDetails")String cookieAdminDetails,@RequestParam int meetingId, @RequestParam int organizerEmployeeId)
    {
     return  meetingRequestService.deleteMeetingRoom(cookieAdminDetails,meetingId,organizerEmployeeId);
    }
    @PatchMapping(value = "/updateMeetingRoom")
    public String updateMeetingRoom(@CookieValue(name="cookieAdminDetails",defaultValue ="cookieAdminDetails")String cookieAdminDetails, @RequestBody
    MeetingRoom meetingRoom)
    {
        return meetingRequestService.updateMeetingRoom(cookieAdminDetails, meetingRoom);
    }
}
