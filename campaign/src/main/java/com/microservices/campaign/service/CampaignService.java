package com.microservices.campaign.service;

import com.microservices.campaign.consumer.FootballTeamConsumer;
import com.microservices.campaign.repository.ICampaignRepository;
import com.microservices.commons.model.CampaignModel;
import com.microservices.commons.param.CampaignParam;
import com.microservices.commons.presenter.CampaignPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignService implements ICampaignService {

    @Autowired
    private ICampaignRepository campaignRepository;

    public CampaignPresenter save(CampaignParam campaignParam) {
        return convertModelToPresenter(campaignRepository.save(convertParamToModel(campaignParam)));
    }

    @Override
    public List<CampaignPresenter> findAll() {
        List<CampaignPresenter> presenter = new ArrayList<CampaignPresenter>();

        campaignRepository.findAll()
                .forEach(campaignModel -> presenter.add(convertModelToPresenter(campaignModel)));

        return presenter;

    }

    @Override
    public void deleteById(String id) {
        campaignRepository.deleteById(id);
    }

    private CampaignModel convertParamToModel(CampaignParam campaignParam) {

        return Optional.ofNullable(campaignParam)
                .map(param -> {

                    CampaignModel model = new CampaignModel();

                    Optional.ofNullable(param.getId()).ifPresent(id -> model.setId(id));
                    Optional.ofNullable(param.getName()).ifPresent(name -> model.setName(name));
                    Optional.ofNullable(param.getFootballTeamId()).ifPresent(footballTeamId -> model.setFootballTeamId(footballTeamId));
                    Optional.ofNullable(param.getInitialEffectiveDate()).ifPresent(initialEffectiveDate -> model.setInitialEffectiveDate(initialEffectiveDate));
                    Optional.ofNullable(param.getFinalEffectiveDate()).ifPresent(finalEffectiveDate -> model.setFinalEffectiveDate(finalEffectiveDate));

                    return model;
                }).orElse(new CampaignModel());
    }

    private CampaignPresenter convertModelToPresenter(CampaignModel campaignModel) {
            return Optional.ofNullable(campaignModel)
                    .map(model -> {
                        CampaignPresenter presenter = new CampaignPresenter();

                        Optional.ofNullable(model.getName()).ifPresent(name -> presenter.setName(name));
                        Optional.ofNullable(model.getId()).ifPresent(id -> presenter.setId(id));

                        Optional.ofNullable(model.getFootballTeamId()).ifPresent(footballTeamId -> {
                            FootballTeamConsumer footballTeamConsumer = new FootballTeamConsumer();

                            presenter.setFootballTeam(footballTeamConsumer.findById(footballTeamId));
                        });

                        Optional.ofNullable(model.getInitialEffectiveDate()).ifPresent(initialEffectiveDate -> presenter.setInitialEffectiveDate(initialEffectiveDate));
                        Optional.ofNullable(model.getFinalEffectiveDate()).ifPresent(finalEffectiveDate -> presenter.setFinalEffectiveDate(finalEffectiveDate));

                        return presenter;
                    }).orElse(new CampaignPresenter());
    }
}
