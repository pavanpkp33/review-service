package com.sdsu.edu.cms.reviewservice.controllers;


import com.sdsu.edu.cms.common.models.response.ServiceResponse;
import com.sdsu.edu.cms.common.models.review.Review;
import com.sdsu.edu.cms.reviewservice.services.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1", produces = {APPLICATION_JSON_VALUE})
public class ReviewsController {

    @Autowired
    ReviewsService reviewsService;
    // Get all reviewers for conference
    @GetMapping("/reviews/{conferenceId}/reviewers")
    public ServiceResponse getAllReviewers(@PathVariable String conferenceId){
        return  reviewsService.getAllReviewers(conferenceId);
    }

    @PostMapping("/reviews/{conferenceId}/review/{submissionId}")
    public  ServiceResponse postReviews(@RequestBody Review review,
                                        @PathVariable String conferenceId,
                                        @PathVariable String submissionId){

        review.setConferenceId(conferenceId);
        review.setSubmissionId(submissionId);
        return  reviewsService.addReview(review);
    }

    @GetMapping("/reviews/{conferenceId}/review/{submissionId}")
    public ServiceResponse getReviewBySubmission(@PathVariable String conferenceId,
                                                 @PathVariable String submissionId ){
        return reviewsService.getReviewsBySubmissionId(submissionId);

    }

    @GetMapping("/reviews/{reviewId}")
    public ServiceResponse getReviewById(@PathVariable String reviewId){

        return reviewsService.getReviewByReviewId(reviewId);
    }

    @PutMapping("/reviews/{reviewId}")
    public ServiceResponse updateReview(@RequestBody Review payLoad, @PathVariable String reviewId){
        return null;
    }

    @PostMapping("/reviews/{conferenceId}/{submissionId}/publish")
    public ServiceResponse publishReviews(@RequestBody Map<String, Object> body, @PathVariable String conferenceId,
                                          @PathVariable String submissionId){

        return null;
    }





}
