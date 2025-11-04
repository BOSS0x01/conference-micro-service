package boss.team.conferenceservice.controllers;

import boss.team.conferenceservice.dtos.ReviewDTO;
import boss.team.conferenceservice.exceptions.ReviewNotFoundException;
import boss.team.conferenceservice.services.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/reviews")
@AllArgsConstructor
public class ReviewController {

    ReviewService reviewService;

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDTO> getReviewById(@PathVariable Long id) throws ReviewNotFoundException {
        return ResponseEntity.ok(reviewService.getReviewById(id));
    }

    @GetMapping
    public ResponseEntity<List<ReviewDTO>> reviewList() {
        return ResponseEntity.ok(reviewService.reviewList());
    }

    @PostMapping
    public ResponseEntity<ReviewDTO> saveReview(@RequestBody ReviewDTO reviewDTO) {
        return ResponseEntity.ok(reviewService.saveReview(reviewDTO));
    }

    @PatchMapping
    public ResponseEntity<ReviewDTO> patchReview(@RequestBody ReviewDTO reviewDTO) throws ReviewNotFoundException {
        return ResponseEntity.ok(reviewService.updateReview(reviewDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReviewDTO> deleteReviewById(@PathVariable Long id) throws ReviewNotFoundException {
        return ResponseEntity.ok(reviewService.deleteReviewById(id));
    }
}
