package com.example.demo.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Meetings {

    @Id
    @SequenceGenerator(name = "employeeMeetingId",
            sequenceName = "employeeMeetingId",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "employeeMeetingId")
    private int serialNo;
    private int meetingId;
    private int employeeId;
    @OneToOne
    @JoinColumn(name="meetingId",referencedColumnName = "meetingId",insertable = false,updatable = false)
    DateAndTimeDetails dateandtimedetails;

//    @ManyToOne
//    @JoinColumn(name="employeeId",referencedColumnName="employeeId")
//    EmployeeDetails parent;
//    void abc(){
//        EmployeeDetails obj= new EmployeeDetails();
//        obj.setStatus(AvailabiliityStatus.AVAILABLE);
    }