package boss.team.conferenceservice.entities;

import boss.team.conferenceservice.enums.ConferenceType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

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

    @OneToMany(mappedBy = "conference")
    private List<Review> reviews;
}
