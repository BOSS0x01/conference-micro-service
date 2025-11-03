package boss.team.keynoteservice;
import boss.team.keynoteservice.entities.Keynote;
import boss.team.keynoteservice.mappers.KeynoteMapper;
import boss.team.keynoteservice.services.KeynoteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;

@SpringBootApplication
public class KeynoteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeynoteServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(KeynoteService keynoteService, KeynoteMapper keynoteMapper) {
        return args -> List.of("key1", "key2", "key3", "key4", "key5", "key6", "key7").forEach(key -> {
            List<String> functions = List.of("function1", "function2", "function3", "function4", "function5", "function6", "function7");

            Keynote keynote = Keynote.builder()
                    .email(key+"@gmail.com")
                    .firstName(key)
                    .lastName(key+"lastname")
                    .function(functions.get(new Random().nextInt(functions.size())))
                    .build();

            keynoteService.saveKeynote(keynoteMapper.toKeynoteDTO(keynote));
        });
    }

}
