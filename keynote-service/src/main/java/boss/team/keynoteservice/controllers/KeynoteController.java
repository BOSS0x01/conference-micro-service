package boss.team.keynoteservice.controllers;

import boss.team.keynoteservice.dtos.KeynoteDTO;
import boss.team.keynoteservice.exceptions.KeynoteNotFoundException;
import boss.team.keynoteservice.services.KeynoteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/keynotes")
@AllArgsConstructor
public class KeynoteController {

    KeynoteService keynoteService;

    @GetMapping
    public ResponseEntity<KeynoteDTO> getKeynoteById(Long id) throws KeynoteNotFoundException {
        return ResponseEntity.ok(keynoteService.getKeynoteById(id));
    }

    @GetMapping
    public ResponseEntity<List<KeynoteDTO>> keynoteList() throws KeynoteNotFoundException {
        return ResponseEntity.ok(keynoteService.keynoteList());
    }

    @DeleteMapping
    public ResponseEntity<KeynoteDTO> deleteKeynoteById(Long id) throws KeynoteNotFoundException {
        return ResponseEntity.ok(keynoteService.deleteKeynoteById(id));
    }
}
