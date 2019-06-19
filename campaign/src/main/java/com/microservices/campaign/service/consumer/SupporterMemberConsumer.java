package com.microservices.campaign.service.consumer;

import com.microservices.commons.param.SupporterMemberParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SupporterMemberConsumer {

    private final String SUPPORTER_MEMBER_URL = "http://localhost:8085/supporter-member/";

    @Autowired
    private RestTemplate restTemplate;

    public void associateCampaignsToUser(SupporterMemberParam param) {
        HttpEntity<SupporterMemberParam> request = new HttpEntity<>(param);

        restTemplate.exchange(
                SUPPORTER_MEMBER_URL + param.getId(),
                HttpMethod.PUT,
                request,
                SupporterMemberParam.class);
    }
}
