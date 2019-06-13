package com.microservices.campaign.service;

import com.microservices.commons.param.CampaignParam;
import com.microservices.commons.presenter.CampaignPresenter;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICampaignService {
    CampaignPresenter save(CampaignParam campaignParam);
    List<CampaignPresenter> findAll();
    CampaignPresenter findById(String id);
    List<CampaignPresenter> findAllByFootballTeamId(String id);
    void deleteById(String id);
}
