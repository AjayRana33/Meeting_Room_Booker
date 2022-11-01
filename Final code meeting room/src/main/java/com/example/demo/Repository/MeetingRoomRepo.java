package com.example.demo.Repository;

import com.example.demo.Entity.MeetingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetingRoomRepo extends JpaRepository<MeetingRoom,Integer> {
    List<MeetingRoom> findByLocation(String location);
    List<MeetingRoom> findByOrganizerEmployeeId(int organizerEmployeeId);
}
