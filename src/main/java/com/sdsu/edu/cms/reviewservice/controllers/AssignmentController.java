package com.sdsu.edu.cms.reviewservice.controllers;


import com.sdsu.edu.cms.common.models.response.ServiceResponse;
import com.sdsu.edu.cms.reviewservice.services.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1")
public class AssignmentController {

    @Autowired
    AssignmentService assignmentService;

    @PostMapping(value = "/conferences/{confId}/assignment/{submissionId}", consumes = {APPLICATION_JSON_VALUE}, produces = {APPLICATION_JSON_VALUE})
    public ServiceResponse createAssignment(@RequestBody Map<String, Object> params, @PathVariable String submissionId,
                                            @PathVariable String confId){

        return assignmentService.addAssignment(confId, submissionId, params);
    }

    @GetMapping(value = "/conferences/{confId}/assignment/{submissionId}")
    public ServiceResponse getAssignmentForSubmission(@PathVariable String submissionId, @PathVariable String confId){
        return null;
    }

    @DeleteMapping(value = "/conferences/assignment/{submissionId}")
    public ServiceResponse deleteAssingment(@PathVariable String submissionId){
        return null;
    }

}
