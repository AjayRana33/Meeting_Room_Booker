package com.example.demo.Service;

import com.example.demo.Entity.EmployeeDetails;
import com.example.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeDetailsService {

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

    public List<EmployeeDetails> fetchAllEmployeeDetails() {
        return employeeDetailsRepo.findAll();
    }

    public String addNewEmployeeDetails(EmployeeDetails employeeDetails) {
        if (employeeDetailsRepo.existsById(employeeDetails.getEmployeeId())) {
            return "Employee already exists!";
        }
        employeeDetailsRepo.save(employeeDetails);

        return "New Employee Added -> " + employeeDetails.getEmployeeName();
    }

    public String updateEmployeeDetails(String cookieEmployeeDetails, int employeeId, EmployeeDetails employeeDetails) {
//        GetCookieValue getCookieValue = authentication.extractValue(cookieAdmin);
        EmployeeDetails employeeDetails1 = employeeDetailsRepo.findById(employeeId).orElse(null);
        if (employeeDetails1 == null)
            return "Employee not found with id" + employeeId;
//      if(admin1.getAdminPassword().equals(getCookieValue.getAdminPassword()))
//        {
        if (Objects.nonNull(employeeDetails.getEmployeeName()) && !"".equalsIgnoreCase(employeeDetails.getEmployeeName())) {
            employeeDetails1.setEmployeeName(employeeDetails.getEmployeeName());
        }
        if (Objects.nonNull(employeeDetails.getEmployeeOrganisation()) && !"".equalsIgnoreCase(employeeDetails.getEmployeeOrganisation())) {
            employeeDetails1.setEmployeeOrganisation(employeeDetails.getEmployeeOrganisation());
        }
        if (Objects.nonNull(employeeDetails.getEmployeePassword()) && !"".equalsIgnoreCase(employeeDetails.getEmployeePassword())) {
            employeeDetails1.setEmployeePassword(employeeDetails.getEmployeePassword());
        }
        if (Objects.nonNull(employeeDetails.getEmployeeDesignation()) && !"".equalsIgnoreCase(employeeDetails.getEmployeeDesignation())) {
            employeeDetails1.setEmployeeDesignation(employeeDetails.getEmployeeDesignation());
        }
        if (Objects.nonNull(employeeDetails.getEmployeeEmail()) && !"".equalsIgnoreCase(employeeDetails.getEmployeeEmail())) {
            employeeDetails1.setEmployeeEmail(employeeDetails.getEmployeeEmail());
        }
        employeeDetailsRepo.save(employeeDetails1);
        return "Employee -> " + employeeDetails1.getEmployeeName() + " details updated successfully";
    }

    public String deleteEmployeeDetails(String cookie, int employeeId) {

        if (employeeDetailsRepo.existsById(employeeId)) {
            employeeDetailsRepo.deleteById(employeeId);
            return "Deleted successfully";
        }
        return "Employee doesnot exist"+ cookie;
    }
}
