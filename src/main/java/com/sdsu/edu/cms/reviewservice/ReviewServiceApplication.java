package com.sdsu.edu.cms.reviewservice;

import com.sdsu.edu.cms.common.utils.Constants;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.sdsu.edu.cms.reviewservice")
@EnableFeignClients("com.sdsu.edu.cms.reviewservice")
public class ReviewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewServiceApplication.class, args);
	}

	@Component
	static class ReqInterceptor implements RequestInterceptor {

		@Override
		public void apply(RequestTemplate template) {
			template.header(Constants.INTERNAL_TOKEN, Constants.INTERNAL_TOKEN_VALUE);
		}
	}
}
