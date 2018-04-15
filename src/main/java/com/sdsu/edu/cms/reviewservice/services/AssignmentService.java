package com.sdsu.edu.cms.reviewservice.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sdsu.edu.cms.common.models.response.ServiceResponse;
import com.sdsu.edu.cms.common.models.review.Assignment;
import com.sdsu.edu.cms.reviewservice.proxy.DataServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AssignmentService {

    @Autowired
    DataServiceProxy dataServiceProxy;

    public ServiceResponse addAssignment(String cid, String sid, Map<String, Object> mp){

        mp.put("sid",sid);

        mp.put("cid", cid);
        List<String> userId = (List<String>) mp.get("userids");
        String res = "";
        for(String id : userId){
            res += id+"~";
        }
        mp.remove("userids");
        mp.put("userids", res);

        return dataServiceProxy.addAssignment(mp);
    }

    public ServiceResponse getAssignments(String sid){
        Map<String, String> mp = new HashMap<>();
        mp.put("sid", sid);
        ServiceResponse response =  dataServiceProxy.getAssignment(mp);
        Gson gson = new Gson();
        Type type = new TypeToken<List<Assignment>>() {}.getType();
        List<Assignment> assignments = gson.fromJson(response.getData().get(0).toString(), type);
        List<Object> clientResponse = new ArrayList<>();
        for(Assignment a : assignments){
            clientResponse.add(a);
        }
        response.setData(clientResponse);
        return response;
    }

}
