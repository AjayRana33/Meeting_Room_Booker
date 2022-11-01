package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Admin {

    @Id
    private int adminId;
//    private String adminName;
//    private String adminPassword;
//    private String adminOrganisation;
    @OneToOne
    @JoinColumn(name="adminId",referencedColumnName = "employeeId")
    EmployeeDetails organizerDetails;

}
