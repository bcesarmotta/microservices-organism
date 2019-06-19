package com.microservices.campaign.service.consumer;

import com.microservices.commons.presenter.FootballTeamPresenter;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final String FOOTBALL_TEAM_URL = "http://localhost:8084/football-team/";

    public FootballTeamPresenter findById(String id) {

        restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange(FOOTBALL_TEAM_URL + id, HttpMethod.GET, entity, FootballTeamPresenter.class).getBody();

    }
}
