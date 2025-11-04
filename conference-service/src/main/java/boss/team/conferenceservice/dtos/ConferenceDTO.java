package boss.team.conferenceservice.dtos;

import boss.team.conferenceservice.entities.Review;
import boss.team.conferenceservice.enums.ConferenceType;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@Data
public class ConferenceDTO {
    private Long id;
    private String title;
    private ConferenceType type;
    private LocalDate date;
    private Duration duration;
    private List<Review> reviews;
}
