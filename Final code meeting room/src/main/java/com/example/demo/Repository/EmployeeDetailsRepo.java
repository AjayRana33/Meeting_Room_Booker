package com.example.demo.Repository;

import com.example.demo.Entity.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDetailsRepo extends JpaRepository<EmployeeDetails,Integer> {


}
