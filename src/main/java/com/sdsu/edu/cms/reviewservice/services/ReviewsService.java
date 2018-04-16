package com.sdsu.edu.cms.reviewservice.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sdsu.edu.cms.common.models.response.ServiceResponse;
import com.sdsu.edu.cms.common.models.review.Review;
import com.sdsu.edu.cms.common.models.review.Reviewers;
import com.sdsu.edu.cms.reviewservice.proxy.DataServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.*;

@Service
public class ReviewsService {

    @Autowired
    DataServiceProxy dataServiceProxy;
    Gson gson = new Gson();
    public ServiceResponse getAllReviewers(String confId){
        Map<String, String> mp = new HashMap<>();
        mp.put("cid", confId);
        ServiceResponse response =  dataServiceProxy.getAllReviewers(mp);
        String result = response.getData().get(0).toString();

        Type type = new TypeToken<List<Reviewers>>() {}.getType();
        List<Reviewers> reviewers = gson.fromJson(result, type);
        List<Object> castResult = new ArrayList<>();
        for(Reviewers r : reviewers){
            castResult.add(r);
        }
        response.setData(castResult);
        return response;
    }

    public ServiceResponse addReview(Review review){
        return dataServiceProxy.addReview(review);
    }

    public ServiceResponse getReviewsBySubmissionId(String sid){
        Map<String, String> params = new HashMap<>();
        params.put("sid", sid);
        ServiceResponse response =  dataServiceProxy.getReviewsBySid(params);
        String res = response.getData().get(0).toString();
        Type type = new TypeToken<List<Review>>() {}.getType();
        List<Review> reviews = gson.fromJson(res, type);
        List<Object> reviewsList = new ArrayList<>();
        for(Review r : reviews){
            reviewsList.add(r);
        }

        response.setData(reviewsList);
        return response;

    }

    public ServiceResponse getReviewByReviewId(String rid){
        Map<String, String> params = new HashMap<>();
        params.put("rid", rid);
        ServiceResponse response = dataServiceProxy.getReviewsByRid(params);
        String res = response.getData().get(0).toString();
        Type type = new TypeToken<List<Review>>() {}.getType();
        List<Review> reviews = gson.fromJson(res, type);
        List<Object> reviewsList = new ArrayList<>();
        for(Review r : reviews){
            reviewsList.add(r);
        }

        response.setData(reviewsList);
        return response;
    }

    public ServiceResponse updateReview(Review review){
        return dataServiceProxy.updateReviews(review);
    }

    public ServiceResponse publishReview(String sid){
        Map<String, String> params = new HashMap<>();
        params.put("sid", sid);
        return dataServiceProxy.publishReviews(params);
    }

    public ServiceResponse deleteReview(String reviewId) {
        Map<String, String> params = new HashMap<>();
        params.put("rid", reviewId);
        return dataServiceProxy.deleteReviews(params);
    }
}
