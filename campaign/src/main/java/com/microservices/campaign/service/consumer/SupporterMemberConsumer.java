package com.microservices.campaign.service.consumer;

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

    public void associateCampaignsToUser(SupporterMemberParam param) {

        discoveryClient.getInstances(SUPPORTER_MEMBER_SERVICE_NAME)
                .stream()
                .findFirst()
                .map(
                        service ->
                                restTemplate.exchange(
                                        service.getUri() + SUPPORTER_MEMBER_SERVICE_PATH + param.getId(),
                                        HttpMethod.PUT,
                                        getDefaultHeaders(),
                                        FootballTeamPresenter.class)
                );
    }

    private HttpEntity getDefaultHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);
        return entity;
    }
}
