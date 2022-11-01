package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeDetails {

    @Id
    private int employeeId;
    private String employeeName;
    private String employeePassword;
    private String employeeDesignation;
    private String employeeOrganisation;
    //private int phone_number;
    private String employeeEmail;

//    @OneToMany
//    @JoinColumn(name="employeeId”, referenceColumnName="employeeId")

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="employeeId",referencedColumnName="employeeId")
    List<Meetings> meetingAlreadyCommitted;
}