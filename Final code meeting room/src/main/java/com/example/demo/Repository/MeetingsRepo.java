package com.example.demo.Repository;

import com.example.demo.Entity.Meetings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MeetingsRepo extends JpaRepository<Meetings,Integer> {
Optional <Meetings> findByMeetingId(int meetingId);
void deleteByMeetingId(int meetingId);
}
