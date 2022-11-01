package com.example.demo.Controller;

import com.example.demo.Entity.Admin;
import com.example.demo.Entity.MeetingRoom;
import com.example.demo.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

//    @PostMapping(value = "/addNewAdmin")
//    public String addNewAdmin(@RequestBody Admin admin)
//    {
//        if(isValidAdmin(admin))
//        {
//            return adminService.addNewAdmin(admin);
//        }
//        else
//            return "Invalid Data Entered";
//    }
//    public boolean isValidAdmin(Admin admin) {
//        if (!admin.getAdminName().isEmpty() && !admin.getAdminPassword().isEmpty()) {
//            return true;
//        }
//        return false;
//    }

//    @PatchMapping(value = "/updateAdmin/{adminId}")
//    public String updateAdmin(@CookieValue(name = "cookieAdmin",defaultValue = "Admin")String cookieAdmin,@PathVariable(name="adminId")int adminId, @RequestBody Admin admin)
//    {
//        return adminService.updateAdmin(cookieAdmin,adminId,admin);
//    }
//
//    @DeleteMapping(value = "/deleteAdmin/{adminId}")
//    public String deleteAdmin(@CookieValue(name = "cookieAdmin",defaultValue = "Admin") String cookieAdmin,@PathVariable(name="adminId")int adminId )
//    {
//        return adminService.deleteAdmin(cookieAdmin,adminId);
//    }
//
    @PostMapping(value="/createMeetingRoom")
    public String createMeetingRoom(@CookieValue(name = "cookieAdmin",defaultValue = "Admin") String cookieAdmin, @RequestBody MeetingRoom meetingRoom) {
        return adminService.createMeetingRoom(cookieAdmin,meetingRoom);
    }


    @GetMapping(value="/adminAllDetails")
    public List<Admin> getAdminDetails()
    {
        return adminService.getAdminDetails();
    }
//    @PatchMapping (value="/updateMeetingRoom/{meetingId}")
//    public String updateMeetingRoom(@CookieValue(name = "cookieAdmin",defaultValue = "Admin") String cookieAdmin,@PathVariable(name="meetingId")int meetingId, @RequestBody MeetingRoom meetingRoom) {
//        return adminService.updateMeetingRoom(cookieAdmin,meetingId,meetingRoom);
//    }

    @DeleteMapping(value = "/deleteMeetingRoom/{meetingId}")
    public String deleteMeetingRoom(@CookieValue(name = "cookieAdmin",defaultValue = "Admin")String cookieAdmin, @PathVariable(name="meetingId")int meetingId)
    {
        return adminService.deleteMeetingRoom(cookieAdmin,meetingId);
    }


}
