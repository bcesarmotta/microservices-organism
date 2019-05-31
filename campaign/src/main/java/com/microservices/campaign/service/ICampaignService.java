package com.microservices.campaign.service;

import com.microservices.commons.param.CampaignParam;
import com.microservices.commons.presenter.CampaignPresenter;

import java.util.List;

public interface ICampaignService {
    CampaignPresenter save(CampaignParam campaignParam);
    List<CampaignPresenter> findAll();
}
