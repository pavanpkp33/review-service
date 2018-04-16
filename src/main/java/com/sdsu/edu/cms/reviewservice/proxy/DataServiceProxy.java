package com.sdsu.edu.cms.reviewservice.proxy;


import com.sdsu.edu.cms.common.models.response.ServiceResponse;
import com.sdsu.edu.cms.common.models.review.Review;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "data-service")
@RibbonClient(name = "data-service")
public interface DataServiceProxy {
    @PostMapping("/api/v1/assignment/create")
    ServiceResponse addAssignment(@RequestParam Map<String, Object> params);

    @PostMapping("/api/v1/assignment/get")
    ServiceResponse getAssignment(@RequestParam Map<String, String> params);

    @PostMapping("/api/v1/assignment/delete")
    ServiceResponse deleteAssignment(@RequestParam Map<String, Object> params);

    @PostMapping("/api/v1/assignment/delete/id")
    ServiceResponse deleteAssignmentById(@RequestParam Map<String, String> params);

    @PostMapping("/api/v1/reviewers/get")
    ServiceResponse getAllReviewers(@RequestParam Map<String, String> confId);

    @PostMapping("/api/v1/reviews/create")
    ServiceResponse addReview(@RequestBody Review review);

    @PostMapping("/api/v1/reviews/get/sid")
    ServiceResponse getReviewsBySid(@RequestParam Map<String, String> mp);

    @PostMapping("/api/v1/reviews/get/rid")
    ServiceResponse getReviewsByRid(@RequestParam Map<String, String> params);

    @PostMapping("/api/v1/reviews/update")
    ServiceResponse updateReviews(@RequestBody Review review);

    @PostMapping("/api/v1/reviews/publish")
    ServiceResponse publishReviews(@RequestParam Map<String, String> params);

    @PostMapping("/api/v1/reviews/delete")
    ServiceResponse deleteReviews(@RequestParam Map<String, String> params);

}
