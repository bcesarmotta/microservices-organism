package com.microservices.campaign.service.consumer;

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
public class FootballTeamConsumer {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    private static final String FOOTBALL_TEAM_SERVICE_NAME = "FOOTBALL_TEAM_SERVICE";

    private static final String FOOTBALL_TEAM_SERVICE_PATH = "/football-team/";

    public FootballTeamPresenter findById(String id) {
        return discoveryClient.getInstances(FOOTBALL_TEAM_SERVICE_NAME)
                .stream()
                .findFirst()
                .map(
                        service ->
                            restTemplate.exchange(
                                service.getUri() + FOOTBALL_TEAM_SERVICE_PATH + id,
                                HttpMethod.GET,
                                getDefaultHeaders(),
                                FootballTeamPresenter.class).getBody()
                ).orElse(null);
    }

    private HttpEntity getDefaultHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);
        return entity;
    }
}
