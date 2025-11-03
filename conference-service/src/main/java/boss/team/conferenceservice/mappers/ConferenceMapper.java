package boss.team.conferenceservice.mappers;

import boss.team.conferenceservice.dtos.ConferenceDTO;
import boss.team.conferenceservice.entities.Conference;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@Service

public class ConferenceMapper {

    public ConferenceDTO toConferenceDTO(Conference conference) {
        ConferenceDTO conferenceDTO = new ConferenceDTO();
        BeanUtils.copyProperties(conference, conferenceDTO);
        return conferenceDTO;
    }

    public Conference toConference(ConferenceDTO conferenceDTO) {
        Conference conference = new Conference();
        BeanUtils.copyProperties(conferenceDTO, conference);
        return conference;
    }
}
