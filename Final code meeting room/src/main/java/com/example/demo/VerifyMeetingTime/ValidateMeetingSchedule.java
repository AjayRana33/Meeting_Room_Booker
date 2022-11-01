package com.example.demo.VerifyMeetingTime;

import com.example.demo.Entity.DateAndTimeDetails;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class ValidateMeetingSchedule {
    public boolean validate(DateAndTimeDetails committedMeetingDetails , DateAndTimeDetails requestDateAndTimeDetails)
    {
        LocalDate meetingStartDate=committedMeetingDetails.getStartDate();//20 Feb 2022
        LocalDate meetingEndDate=committedMeetingDetails.getEndDate();//20 Feb 2022
        LocalTime meetingStartTime=committedMeetingDetails.getStartTime();//HH-MM-SS-->24 HRS -->10 AM
        LocalTime meetingEndTime=committedMeetingDetails.getEndTime();//12 PM
        LocalDate newRequestStartDate=requestDateAndTimeDetails.getStartDate();//20 Feb 2022
        LocalDate newRequestEndDate=requestDateAndTimeDetails.getEndDate();//20 Feb 2022
        LocalTime newRequestStartTime=requestDateAndTimeDetails.getStartTime();//10:30 AM
        LocalTime newRequestEndTime=requestDateAndTimeDetails.getEndTime();//11:30 AM
        Boolean availability = true;
        if(newRequestStartDate.equals(meetingStartDate) && newRequestEndDate.equals(meetingEndDate))
        {
            if(newRequestStartTime.equals(meetingStartTime) && newRequestEndTime.equals(meetingEndTime))
            {
                availability=false;
            }
            else if(newRequestStartTime.isAfter(meetingStartTime) && newRequestEndTime.isBefore(meetingEndTime))
            {
                availability=false;
            }
            else if(newRequestStartTime.isAfter(meetingStartTime) && newRequestStartTime.isBefore(meetingEndTime))
            {
                availability=false;
            }

            else if(newRequestEndTime.isBefore(meetingEndTime) && newRequestEndTime.isAfter(meetingStartTime))
            {
                availability=false;
            }

            else if(newRequestStartTime.isBefore(meetingStartTime) && newRequestEndTime.isAfter(meetingEndTime))
            {
                availability=false;
            }
            else
            {
                availability=true;
            }

        }
        else if(newRequestStartDate.isAfter(meetingStartDate) && newRequestEndDate.isBefore(meetingEndDate))
        {
            availability=false;
        }
        else if(newRequestStartDate.isAfter(meetingStartDate) && newRequestStartDate.isBefore(meetingEndDate))
        {
            availability=false;
        }

        else if(newRequestEndDate.isBefore(meetingEndDate) && newRequestEndDate.isAfter(meetingStartDate))
        {
            availability=false;
        }

        else if(newRequestStartDate.isBefore(meetingStartDate) && newRequestEndDate.isAfter(meetingEndDate))
        {
            availability=false;
        }
        else
        {
            availability=true;
        }
        return availability;
    }
}
