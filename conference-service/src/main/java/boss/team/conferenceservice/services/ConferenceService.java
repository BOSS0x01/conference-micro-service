package boss.team.conferenceservice.services;


import boss.team.conferenceservice.dtos.ConferenceDTO;
import boss.team.conferenceservice.entities.Conference;
import boss.team.conferenceservice.exceptions.ConferenceNotFoundException;
import boss.team.conferenceservice.mappers.ConferenceMapper;
import boss.team.conferenceservice.repositories.ConferenceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConferenceService {

    private ConferenceRepository ConferenceRepository;
    private ConferenceMapper ConferenceMapper;

    public List<ConferenceDTO> conferenceList() {
        return ConferenceRepository.findAll().stream().map(ConferenceMapper::toConferenceDTO).toList();
    }

    public ConferenceDTO getConferenceById(Long id) throws ConferenceNotFoundException {
        Conference Conference =findConference(id);
        return ConferenceMapper.toConferenceDTO(Conference);
    }

    public ConferenceDTO saveConference(ConferenceDTO ConferenceDTO)  {
        Conference savedConference = ConferenceRepository.save(ConferenceMapper.toConference(ConferenceDTO));
        return ConferenceMapper.toConferenceDTO(savedConference);
    }

    public ConferenceDTO updateConference(ConferenceDTO ConferenceDTO) throws ConferenceNotFoundException {
        return ConferenceMapper.toConferenceDTO(ConferenceRepository.save(findConference(ConferenceDTO.getId())));
    }

    public ConferenceDTO deleteConferenceById(Long id) throws ConferenceNotFoundException {
        Conference Conference =findConference(id);
        ConferenceRepository.delete(Conference);
       return ConferenceMapper.toConferenceDTO(Conference) ;
    }

    private Conference findConference(Long id) throws ConferenceNotFoundException {
        return  ConferenceRepository.findById(id).orElseThrow(() -> new ConferenceNotFoundException("Conference with id: " + id + " not found"));
    }
}
