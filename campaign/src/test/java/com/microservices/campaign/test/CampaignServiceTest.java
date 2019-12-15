package com.microservices.campaign.test;

import com.microservices.campaign.repository.ICampaignRepository;
import com.microservices.campaign.service.consumer.FootballTeamConsumer;
import com.microservices.commons.model.CampaignModel;
import com.microservices.commons.presenter.FootballTeamPresenter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CampaignServiceTest {

    @Mock
    private ICampaignRepository campaignRepository;

    @Mock
    private FootballTeamConsumer footballTeamConsumer;

    @DisplayName("Test to save a campaign in database")
    @Test
    public void testA_SaveCampaign() throws ParseException {
        CampaignModel model = new CampaignModel();
        model.setName("Campanha 1");
        model.setInitialEffectiveDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2020"));
        model.setFinalEffectiveDate(new SimpleDateFormat("dd/MM/yyyy").parse("03/01/2020"));

        when(campaignRepository.save(any(CampaignModel.class))).thenReturn(model);
    }

    @DisplayName("Test to return a campaign list from the service")
    @Test
    public void testB_ListCampaigns() {
        assertEquals(campaignRepository.findAll(), Arrays.asList());
    }

    @DisplayName("Test to return a campaign team from the service based on id")
    @Test
    void testC_listFootballTeamById() throws ParseException {
        CampaignModel model = campaignRepository.findAll().stream().findFirst().orElse(new CampaignModel());
        when(campaignRepository.findById(model.getId())).thenReturn(java.util.Optional.of(model));
    }
}