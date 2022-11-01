package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class DateAndTimeDetails {

    @Id
    private int meetingId;
    LocalDate startDate,endDate;
    LocalTime startTime,endTime;
}
