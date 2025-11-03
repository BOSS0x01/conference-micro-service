package boss.team.keynoteservice.services;

import boss.team.keynoteservice.dtos.KeynoteDTO;
import boss.team.keynoteservice.entities.Keynote;
import boss.team.keynoteservice.exceptions.KeynoteNotFoundException;
import boss.team.keynoteservice.mappers.KeynoteMapper;
import boss.team.keynoteservice.repositories.KeynoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class KeynoteService {

    private KeynoteRepository keynoteRepository;
    private KeynoteMapper keynoteMapper;

    public List<KeynoteDTO> keynoteList() {
        return keynoteRepository.findAll().stream().map(keynoteMapper::toKeynoteDTO).toList();
    }

    public KeynoteDTO getKeynoteById(Long id) throws KeynoteNotFoundException {
        Keynote keynote =findKeynote(id);
        return keynoteMapper.toKeynoteDTO(keynote);
    }

    public KeynoteDTO saveKeynote(KeynoteDTO keynoteDTO)  {
        Keynote savedKeynote = keynoteRepository.save(keynoteMapper.toKeynote(keynoteDTO));
        return keynoteMapper.toKeynoteDTO(savedKeynote);
    }

    public KeynoteDTO updateKeynote(KeynoteDTO keynoteDTO) throws KeynoteNotFoundException {
        return keynoteMapper.toKeynoteDTO(keynoteRepository.save(findKeynote(keynoteDTO.getId())));
    }

    public KeynoteDTO deleteKeynoteById(Long id) throws KeynoteNotFoundException {
        Keynote keynote =findKeynote(id);
        keynoteRepository.delete(keynote);
       return keynoteMapper.toKeynoteDTO(keynote) ;
    }

    private Keynote findKeynote(Long id) throws KeynoteNotFoundException {
        return  keynoteRepository.findById(id).orElseThrow(() -> new KeynoteNotFoundException("Keynote with id: " + id + " not found"));
    }
}
