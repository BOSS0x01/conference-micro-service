package boss.team.conferenceservice ;
import boss.team.conferenceservice.entities.Conference;
import boss.team.conferenceservice.enums.ConferenceType;
import boss.team.conferenceservice.mappers.ConferenceMapper;
import boss.team.conferenceservice.services.ConferenceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class ConferenceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConferenceServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(ConferenceService conferenceService, ConferenceMapper conferenceMapper) {
        return args -> {
            List<String> titles = List.of("AI Summit", "Cloud Expo", "Tech Innovators", "Big Data Forum", "CyberSec Week", "DevOps Days", "IoT Connect");
            List<ConferenceType> types = List.of(ConferenceType.ACADEMIC, ConferenceType.COMMERCIAL);

            Random random = new Random();

            titles.forEach(title -> {
                Conference conference = Conference.builder()
                        .title(title)
                        .type(types.get(random.nextInt(types.size())))
                        .date(LocalDate.now().plusDays(random.nextInt(30))) // random date in next 30 days
                        .duration(Duration.ofHours(2 + random.nextInt(4))) // duration 2–5 hours
                        .build();

                conferenceService.saveConference(conferenceMapper.toConferenceDTO(conference));
            });
        };
    }

}
