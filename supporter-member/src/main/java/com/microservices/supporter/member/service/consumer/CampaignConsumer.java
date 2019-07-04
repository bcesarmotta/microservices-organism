package com.microservices.supporter.member.service.consumer;

import com.microservices.commons.presenter.CampaignPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CampaignConsumer {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    private static final String CAMPAIGN_SERVICE_NAME = "CAMPAIGN_SERVICE";

    private static final String CAMPAIGN_SERVICE_PATH = "/campaign/";

    private static final String FOOTBALL_TEAM_SERVICE_PATH = "footballTeam/";

    public CampaignPresenter findById(String id) {
        return discoveryClient.getInstances(CAMPAIGN_SERVICE_NAME)
                .stream()
                .findFirst()
                .map(service ->
                    restTemplate.getForObject(service.getUri() + CAMPAIGN_SERVICE_PATH + id,
                            CampaignPresenter.class
                    )).orElse(null);
    }

    public List<CampaignPresenter> findByFootballTeamId(String id) {

        return discoveryClient.getInstances(CAMPAIGN_SERVICE_NAME)
                .stream()
                .findFirst()
                .map(service ->

                                restTemplate.exchange(
                                        service.getUri() + CAMPAIGN_SERVICE_PATH + FOOTBALL_TEAM_SERVICE_PATH + id,
                                        HttpMethod.GET, null,
                                        new ParameterizedTypeReference<List<CampaignPresenter>>(){}).getBody()

                        ).orElse(null);
    }
}
