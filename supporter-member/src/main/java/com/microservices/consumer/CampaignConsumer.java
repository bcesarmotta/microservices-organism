package com.microservices.consumer;

import com.microservices.commons.presenter.CampaignPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class CampaignConsumer {

    @Autowired
    private RestTemplate restTemplate;

    private final String CAMPAIGN_URL = "http://localhost:8083/campaign/";

    public CampaignPresenter findById(String id) {
        restTemplate = new RestTemplate();

        return restTemplate.getForObject(
                CAMPAIGN_URL + id,
                CampaignPresenter.class
        );

        /*
        return restTemplate.exchange(
                CAMPAIGN_URL + id,
                HttpMethod.GET, null,
                new ParameterizedTypeReference<List<CampaignPresenter>>(){}).getBody();
         */
    }

    public List<CampaignPresenter> findByFootballTeamId(String id) {

        restTemplate = new RestTemplate();

        return restTemplate.exchange(
                CAMPAIGN_URL + "footballTeam/" + id,
                HttpMethod.GET, null,
                new ParameterizedTypeReference<List<CampaignPresenter>>(){}).getBody();
    }
}
