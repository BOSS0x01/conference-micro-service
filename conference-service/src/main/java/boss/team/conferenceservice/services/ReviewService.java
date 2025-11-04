package boss.team.conferenceservice.services;


import boss.team.conferenceservice.dtos.ReviewDTO;
import boss.team.conferenceservice.entities.Review;
import boss.team.conferenceservice.exceptions.ReviewNotFoundException;
import boss.team.conferenceservice.mappers.ReviewMapper;
import boss.team.conferenceservice.repositories.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {

    private ReviewRepository ReviewRepository;
    private ReviewMapper ReviewMapper;

    public List<ReviewDTO> reviewList() {
        return ReviewRepository.findAll().stream().map(ReviewMapper::toReviewDTO).toList();
    }

    public ReviewDTO getReviewById(Long id) throws ReviewNotFoundException {
        Review Review =findReview(id);
        return ReviewMapper.toReviewDTO(Review);
    }

    public ReviewDTO saveReview(ReviewDTO ReviewDTO)  {
        Review savedReview = ReviewRepository.save(ReviewMapper.toReview(ReviewDTO));
        return ReviewMapper.toReviewDTO(savedReview);
    }

    public ReviewDTO updateReview(ReviewDTO ReviewDTO) throws ReviewNotFoundException {
        return ReviewMapper.toReviewDTO(ReviewRepository.save(findReview(ReviewDTO.getId())));
    }

    public ReviewDTO deleteReviewById(Long id) throws ReviewNotFoundException {
        Review Review =findReview(id);
        ReviewRepository.delete(Review);
       return ReviewMapper.toReviewDTO(Review) ;
    }

    private Review findReview(Long id) throws ReviewNotFoundException {
        return  ReviewRepository.findById(id).orElseThrow(() -> new ReviewNotFoundException("Review with id: " + id + " not found"));
    }
}
