package boss.team.conferenceservice.mappers;

import boss.team.conferenceservice.dtos.ReviewDTO;
import boss.team.conferenceservice.entities.Conference;
import boss.team.conferenceservice.entities.Review;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@Service

public class ReviewMapper {

    public ReviewDTO toReviewDTO(Review review) {
        ReviewDTO reviewDTO = new ReviewDTO();
        BeanUtils.copyProperties(review, reviewDTO);
        reviewDTO.setConferenceId(review.getConference().getId());
        return reviewDTO;
    }

    public Review toReview(ReviewDTO reviewDTO) {
        Review review = new Review();
        BeanUtils.copyProperties(reviewDTO, review);

        if(reviewDTO.getConferenceId()!=null) {
            Conference conference = new Conference();
            conference.setId(reviewDTO.getConferenceId());
            review.setConference(conference);
        }
        return review;
    }
}
