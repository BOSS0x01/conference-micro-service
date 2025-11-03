package boss.team.conferenceservice.entities;

import boss.team.conferenceservice.enums.ConferenceType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Data @Builder
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private ConferenceType type;
    private LocalDate date;
    private Duration duration;
}
