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

    @GetMapping("/reviews/{conferenceId}/review")
    public ServiceResponse getReviewsByConference(@PathVariable String conferenceId){
        return reviewsService.getReviewsByConference(conferenceId);
    }

    @GetMapping("/reviews/{conferenceId}/user/{uid}")
    public ServiceResponse getReviewByUserId(@PathVariable String conferenceId, @PathVariable String uid){
        return reviewsService.getReviewsByUserId(conferenceId, uid);
    }
    @GetMapping("/reviews/{reviewId}")
    public ServiceResponse getReviewById(@PathVariable String reviewId){

        return reviewsService.getReviewByReviewId(reviewId);
    }

    @PutMapping("/reviews/{reviewId}")
    public ServiceResponse updateReview(@RequestBody Review payLoad, @PathVariable String reviewId){
        payLoad.setReviewId(reviewId);
        return reviewsService.updateReview(payLoad);
    }

    @PatchMapping("/reviews/{conferenceId}/{submissionId}/publish")
    public ServiceResponse publishReviews(@PathVariable String conferenceId,
                                          @PathVariable String submissionId){

        return reviewsService.publishReview(submissionId);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ServiceResponse deleteReview(@PathVariable String reviewId){
        return reviewsService.deleteReview(reviewId);
    }




}
