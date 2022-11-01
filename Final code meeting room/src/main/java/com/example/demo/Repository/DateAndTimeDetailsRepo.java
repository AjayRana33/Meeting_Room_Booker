package com.example.demo.Repository;


import com.example.demo.Entity.DateAndTimeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateAndTimeDetailsRepo extends JpaRepository<DateAndTimeDetails,Integer> {

}
