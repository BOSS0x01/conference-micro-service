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

    @GetMapping("/{id}")
    public ResponseEntity<KeynoteDTO> getKeynoteById(@PathVariable Long id) throws KeynoteNotFoundException {
        return ResponseEntity.ok(keynoteService.getKeynoteById(id));
    }

    @GetMapping
    public ResponseEntity<List<KeynoteDTO>> keynoteList() {
        return ResponseEntity.ok(keynoteService.keynoteList());
    }

    @PostMapping
    public ResponseEntity<KeynoteDTO> saveKeynote(@RequestBody KeynoteDTO keynoteDTO) {
        return ResponseEntity.ok(keynoteService.saveKeynote(keynoteDTO));
    }

    @PatchMapping
    public ResponseEntity<KeynoteDTO> patchKeynote(@RequestBody KeynoteDTO keynoteDTO) throws KeynoteNotFoundException {
        return ResponseEntity.ok(keynoteService.updateKeynote(keynoteDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<KeynoteDTO> deleteKeynoteById(@PathVariable Long id) throws KeynoteNotFoundException {
        return ResponseEntity.ok(keynoteService.deleteKeynoteById(id));
    }
}
