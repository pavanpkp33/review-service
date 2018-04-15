package com.sdsu.edu.cms.reviewservice.controllers;


import com.sdsu.edu.cms.common.models.response.ServiceResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1", produces = {APPLICATION_JSON_VALUE})
public class ReviewsController {

    @GetMapping("/reviews/reviewers")
    public ServiceResponse getAllReviewers(){
        return null;
    }


}
