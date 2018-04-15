package com.sdsu.edu.cms.reviewservice.services;

import com.sdsu.edu.cms.common.models.response.ServiceResponse;
import com.sdsu.edu.cms.reviewservice.proxy.DataServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
