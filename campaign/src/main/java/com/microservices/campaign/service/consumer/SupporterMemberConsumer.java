package com.microservices.campaign.service.consumer;

import com.google.gson.Gson;
import com.microservices.commons.param.SupporterMemberParam;
import com.microservices.commons.presenter.FootballTeamPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class SupporterMemberConsumer {

    private static final String SUPPORTER_MEMBER_SERVICE_NAME = "SUPPORTER_MEMBER_SERVICE";

    private static final String SUPPORTER_MEMBER_SERVICE_PATH = "/supporter-member/";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private Gson gson;

    public void associateCampaignsToUser(SupporterMemberParam param) {
        discoveryClient.getInstances(SUPPORTER_MEMBER_SERVICE_NAME)
                .stream()
                .findFirst()
                .map(
                        service ->
                        {
                            HttpHeaders headers = new HttpHeaders();
                            headers.setContentType(MediaType.APPLICATION_JSON);
                            HttpEntity<String> entity = new HttpEntity<String>(gson.toJson(param), headers);

                            return restTemplate.exchange(service.getUri() + SUPPORTER_MEMBER_SERVICE_PATH + param.getId(), HttpMethod.PUT, entity, FootballTeamPresenter.class);
                        }
                );
    }
}
