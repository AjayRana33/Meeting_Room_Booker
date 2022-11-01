package com.example.demo.Service;

import com.example.demo.Entity.Admin;
import com.example.demo.Entity.MeetingRoom;
import com.example.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
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

//        public String addNewAdmin(Admin admin)
//        {
//            if(adminRepo.existsById(admin.getAdminId()))
//            {
//                return "Admin already exists!";
//            }
//            adminRepo.save(admin);
//
//            return "New Admin Added -> " +admin.getAdminName();
//        }


    public List<Admin> getAdminDetails()
    {
        return adminRepo.findAll();
    }

    public String createMeetingRoom(String cookie, MeetingRoom meetingRoom)
    {
        if(meetingRoomRepo.existsById(meetingRoom.getMeetingId()))
        {
            return "Meeting already exists!";
        }
        meetingRoomRepo.save(meetingRoom);
        return "New Meeting Added -> " +meetingRoom.getMeetingId();
    }

    public String deleteMeetingRoom(String cookie,int meetingId) {

            if(meetingRoomRepo.existsById(meetingId)) {
                meetingRoomRepo.deleteById(meetingId);
                return "Meeting room deleted successfully";
            }
            return "Meeting room doesnot exist";
        }

//        public String deleteAdmin(String cookieAdmin, int adminId)
//        {
////            GetCookieValue getCookieValue = authentication.extractValue(cookieOwner);
////            Owner owner = ownerRepo.findByaadharNo(getCookieValue.getAadharNo());
////
////            if(owner.getPassword().equals(getCookieValue.getPassword()))
////            {
//                if (adminRepo.existsById(adminId))
//                {
//                adminRepo.deleteById(adminId);
//                return "Admin deleted successfully";
//            }
//                else
//                    return "Invalid admin credentials!";
//        }
//
//    public String updateAdmin(String cookieAdmin,int adminId,Admin admin)
//    {
////        GetCookieValue getCookieValue = authentication.extractValue(cookieAdmin);
//           Admin admin1 = adminRepo.findById(adminId).orElse(null);
//            if(admin1==null)
//                return "Admin not found with id"+ adminId;
//////        if(admin1.getAdminPassword().equals(getCookieValue.getAdminPassword()))
////        {
//            if(Objects.nonNull(admin.getAdminName()) && !"".equalsIgnoreCase(admin.getAdminName()))
//            {
//                admin1.setAdminName(admin.getAdminName());
//            }
//            if(Objects.nonNull(admin.getAdminOrganisation()) && !"".equalsIgnoreCase(admin.getAdminOrganisation()))
//            {
//                admin1.setAdminOrganisation(admin.getAdminOrganisation());
//            }
//            if(Objects.nonNull(admin.getAdminPassword()) && !"".equalsIgnoreCase(admin.getAdminPassword()))
//            {
//                admin1.setAdminPassword(admin.getAdminPassword());
//            }
//            adminRepo.save(admin1);
//            return "Admin -> " +admin1.getAdminName() +" details updated successfully";
//        }
//        //return "Invalid Admin credentials!";
//    }
}
