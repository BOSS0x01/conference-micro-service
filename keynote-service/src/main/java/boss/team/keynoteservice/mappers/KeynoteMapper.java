package boss.team.keynoteservice.mappers;

import boss.team.keynoteservice.dtos.KeynoteDTO;
import boss.team.keynoteservice.entities.Keynote;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;


@Service

public class KeynoteMapper {

    public KeynoteDTO toKeynoteDTO(Keynote keynote) {
        KeynoteDTO keynoteDTO = new KeynoteDTO();
        BeanUtils.copyProperties(keynote, keynoteDTO);
        return keynoteDTO;
    }

    public Keynote toKeynote(KeynoteDTO keynoteDTO) {
        Keynote keynote = new Keynote();
        BeanUtils.copyProperties(keynoteDTO, keynote);
        return keynote;
    }
}
