package com.sdsu.edu.cms.reviewservice.proxy;


import com.sdsu.edu.cms.common.models.response.ServiceResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "data-service")
@RibbonClient(name = "data-service")
public interface DataServiceProxy {
    @PostMapping("/api/v1/assignment/create")
    ServiceResponse addAssignment(@RequestParam Map<String, Object> params);

}
