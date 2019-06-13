package com.microservices.service;

import com.microservices.commons.model.SupporterMemberModel;
import com.microservices.commons.param.SupporterMemberParam;
import com.microservices.commons.presenter.CampaignPresenter;
import com.microservices.commons.presenter.SupporterMemberPresenter;
import com.microservices.consumer.CampaignConsumer;
import com.microservices.repository.ISupporterMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SupporterMemberService implements ISupporterMemberService{

    @Autowired
    private ISupporterMemberRepository supporterMemberRepository;

    @Override
    public SupporterMemberPresenter save(SupporterMemberParam supporterParam) {

        return convertModelToPresenter(supporterMemberRepository.save(convertParamToModel(supporterParam)));

    }

    private SupporterMemberPresenter convertModelToPresenter(SupporterMemberModel supporterMemberModel) {
        return Optional.ofNullable(supporterMemberModel)
                .map(model -> {
                    SupporterMemberPresenter presenter = new SupporterMemberPresenter();

                    Optional.ofNullable(model.getId()).ifPresent(id -> presenter.setId(id));
                    Optional.ofNullable(model.getName()).ifPresent(name -> presenter.setName(name));
                    Optional.ofNullable(model.getEmail()).ifPresent(email -> presenter.setEmail(email));
                    Optional.ofNullable(model.getBirthDate()).ifPresent(birthDate -> presenter.setBirthDate(birthDate));

                    // iterate over que ids
                    Optional.ofNullable(model.getCampaignIds()).ifPresent(
                            ids -> {
                                CampaignConsumer consumer = new CampaignConsumer();

                                List<CampaignPresenter> campaigns = new ArrayList<CampaignPresenter>();

                                ids.forEach(id -> campaigns.add(consumer.findById(id)));

                                presenter.setCampaigns(campaigns);
                            }
                    );

                    return presenter;
                }).orElse(new SupporterMemberPresenter());
    }

    private SupporterMemberModel convertParamToModel(SupporterMemberParam supporterMemberParam) {
       return Optional.ofNullable(supporterMemberParam)
               .map(param -> {
                   SupporterMemberModel model = new SupporterMemberModel();

                   Optional.ofNullable(param.getId()).ifPresent(id -> model.setId(id));
                   Optional.ofNullable(param.getName()).ifPresent(name -> model.setName(name));
                   Optional.ofNullable(param.getEmail()).ifPresent(email -> model.setEmail(email));
                   Optional.ofNullable(param.getBirthDate()).ifPresent(birthDate -> model.setBirthDate(birthDate));

                   CampaignConsumer consumer = new CampaignConsumer();

                   Optional.ofNullable(param.getCampaignIds())
                           .ifPresentOrElse(
                                   ids -> model.setCampaignIds(ids), () -> model.setCampaignIds(
                                           consumer.findByFootballTeamId(param.getFootballTeamId())
                                                   .stream()
                                                   .map(CampaignPresenter::getId)
                                                   .collect(Collectors.toList())
                                   ));
                   return model;

               }).orElse(new SupporterMemberModel());
    }
}
