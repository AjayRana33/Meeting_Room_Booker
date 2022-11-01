package com.example.demo.Entity;

//import com.example.demo.Enum.AvailabiliityStatus;
import com.example.demo.Status.AvailabiliityStatus;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MeetingRoom {

    @Id
    private int meetingId;
    private int organizerEmployeeId;
    private String meetingDescription;
    private String location;
    @OneToOne(cascade=CascadeType.PERSIST)//Earlier it was all
    @JoinColumn(name="meetingId",referencedColumnName = "meetingId")
    DateAndTimeDetails dateAndTimeDetails;
    @ElementCollection
    List<Integer> participantsEmployeeId;

    @Enumerated(EnumType.STRING)
    private AvailabiliityStatus status;

}
