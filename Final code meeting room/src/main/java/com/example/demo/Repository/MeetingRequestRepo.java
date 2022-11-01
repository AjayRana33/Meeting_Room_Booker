package com.example.demo.Repository;

import com.example.demo.Entity.MeetingRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRequestRepo extends JpaRepository<MeetingRequest,Integer> {



}
