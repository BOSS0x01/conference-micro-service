package boss.team.conferenceservice.controllers;

import boss.team.conferenceservice.dtos.ConferenceDTO;
import boss.team.conferenceservice.exceptions.ConferenceNotFoundException;
import boss.team.conferenceservice.services.ConferenceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/conferences")
@AllArgsConstructor
public class ConferenceController {

    ConferenceService conferenceService;

    @GetMapping("/{id}")
    public ResponseEntity<ConferenceDTO> getConferenceById(@PathVariable Long id) throws ConferenceNotFoundException {
        return ResponseEntity.ok(conferenceService.getConferenceById(id));
    }

    @GetMapping
    public ResponseEntity<List<ConferenceDTO>> conferenceList() {
        return ResponseEntity.ok(conferenceService.conferenceList());
    }

    @PostMapping
    public ResponseEntity<ConferenceDTO> saveConference(@RequestBody ConferenceDTO conferenceDTO) {
        return ResponseEntity.ok(conferenceService.saveConference(conferenceDTO));
    }

    @PatchMapping
    public ResponseEntity<ConferenceDTO> patchConference(@RequestBody ConferenceDTO conferenceDTO) throws ConferenceNotFoundException {
        return ResponseEntity.ok(conferenceService.updateConference(conferenceDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ConferenceDTO> deleteConferenceById(@PathVariable Long id) throws ConferenceNotFoundException {
        return ResponseEntity.ok(conferenceService.deleteConferenceById(id));
    }
}
