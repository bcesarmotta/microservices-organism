package com.microservices.campaign.service;

import com.microservices.commons.param.CampaignParam;
import com.microservices.commons.presenter.CampaignPresenter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICampaignService {
    CampaignPresenter save(CampaignParam campaignParam);
    List<CampaignPresenter> findAll();
    void deleteById(String id);
}
