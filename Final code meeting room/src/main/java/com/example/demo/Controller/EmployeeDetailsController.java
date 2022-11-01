package com.example.demo.Controller;


import com.example.demo.Entity.EmployeeDetails;
import com.example.demo.Service.EmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employeeInfo")
public class EmployeeDetailsController {
    @Autowired
    EmployeeDetailsService employeeDetailsService;


    @GetMapping(value = "/getAllEmployeeDetails")
    public List<EmployeeDetails> getAllEmployeeDetails()
    {
        return employeeDetailsService.fetchAllEmployeeDetails();
    }

    @PostMapping(value = "/addEmployeeDetails")
    public String addEmployeeDetails(@RequestBody EmployeeDetails employeeDetails)
    {
        return employeeDetailsService.addNewEmployeeDetails(employeeDetails);
    }

    @PatchMapping(value = "/updateEmployeeDetails/{employeeId}")
    public String updateEmployeeDetails(@CookieValue(name = "cookieEmployeeDetails",defaultValue = "EmployeeDetails")String cookieEmployeeDetail,@PathVariable(name="employeeId")int employeeId, @RequestBody EmployeeDetails employeeDetails)
    {
        return employeeDetailsService.updateEmployeeDetails(cookieEmployeeDetail,employeeId,employeeDetails);
    }

    @DeleteMapping(value = "/deleteEmployeeDetails/{employeeId}")
    public String deleteEmployeeDetails(@CookieValue(name = "cookieEmployeeDetails",defaultValue = "EmployeeDetails")String cookieEmployeeDetails,
                                        @PathVariable(name="employeeId")int employeeId)
    {
        return employeeDetailsService.deleteEmployeeDetails(cookieEmployeeDetails,employeeId);
    }
//    @GetMapping(value = "/getLoggedInEmployeeDetails")
//    public EmployeeDetails getEmployeeDetails(@CookieValue(name = "cookieEmployeeDetails",defaultValue = "EmployeeDetails")String cookieEmployeeDetails)
//    {
//        return employeeDetailsService.fetchLoggedInEmployeeDetails(cookieEmployeeDetails);
//    }

}
