package boss.team.conferenceservice.dtos;

import boss.team.conferenceservice.entities.Conference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private Long id;

    private String text;
    private LocalDate date;
    private int stars;
    private Long conferenceId;
}
