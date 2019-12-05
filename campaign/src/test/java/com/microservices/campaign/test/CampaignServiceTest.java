package com.microservices.campaign.test;

import com.microservices.campaign.repository.ICampaignRepository;
import com.microservices.campaign.service.ICampaignService;
import com.microservices.campaign.service.consumer.FootballTeamConsumer;
import com.microservices.commons.param.CampaignParam;
import com.microservices.commons.presenter.CampaignPresenter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CampaignServiceTest {

    @Mock
    private ICampaignRepository campaignRepository;

    @Mock
    private FootballTeamConsumer footballTeamConsumer;

    @DisplayName("Test to save a campaign in database")
    @Test
    void testSaveCampaign() {
        // CampaignParam parameter = new CampaignParam();
        // parameter.setName("Campanha 1");

    }
}