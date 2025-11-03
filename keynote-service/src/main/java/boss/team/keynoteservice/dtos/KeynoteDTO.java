package boss.team.keynoteservice.dtos;

import lombok.Data;

@Data
public class KeynoteDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String function;
}
