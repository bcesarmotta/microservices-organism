package com.microservices.supporter.member.service;


import com.microservices.commons.model.SupporterMemberModel;
import com.microservices.commons.param.SupporterMemberParam;
import com.microservices.commons.presenter.CampaignPresenter;
import com.microservices.commons.presenter.SupporterMemberPresenter;
import com.microservices.supporter.member.repository.ISupporterMemberRepository;
import com.microservices.supporter.member.service.consumer.CampaignConsumer;
import com.microservices.supporter.member.service.producer.CampaignProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SupporterMemberService implements ISupporterMemberService{

    @Autowired
    public ISupporterMemberRepository supporterMemberRepository;

    @Autowired
    private CampaignConsumer consumer;

    @Autowired
    private CampaignProducer producer;

    @Override
    public SupporterMemberPresenter save(SupporterMemberParam supporterParam) {

        return Optional.ofNullable(supporterParam.getId())
                .map(id -> Optional.ofNullable(supporterMemberRepository.findById(id))
                        .map(existingSupporter -> {
                            Optional.ofNullable(supporterParam.getEmail())
                                    .ifPresent(email -> existingSupporter.get().setEmail(email));

                            Optional.ofNullable(supporterParam.getName())
                                    .ifPresent(name -> existingSupporter.get().setName(name));

                            Optional.ofNullable(supporterParam.getBirthDate())
                                    .ifPresent(birthDate -> existingSupporter.get().setBirthDate(birthDate));

                            Optional.ofNullable(supporterParam.getFootballTeamId())
                                    .ifPresent(footballTeamId -> existingSupporter.get().setFootballTeamId(footballTeamId));

                            Optional.ofNullable(supporterParam.getCampaignIds())
                                    .ifPresent(ids -> existingSupporter.get().setCampaignIds(ids));

                            return convertModelToPresenter(supporterMemberRepository.save(existingSupporter.get()));
                        }).orElseThrow(null)).orElseGet( () -> {

                            SupporterMemberPresenter presenter = convertModelToPresenter(supporterMemberRepository.save(convertParamToModel(supporterParam)));

                            associateUserToCampaigns(presenter.getId(), supporterParam.getFootballTeamId());

                            return presenter;
                        }
                );
    }

    @Override
    public SupporterMemberPresenter findByEmail(String email) {
        return Optional.ofNullable(convertModelToPresenter(supporterMemberRepository.findByEmail(email))).orElse(null);
    }

    private SupporterMemberPresenter convertModelToPresenter(SupporterMemberModel supporterMemberModel) {
        return Optional.ofNullable(supporterMemberModel)
                .map(model -> {
                    SupporterMemberPresenter presenter = new SupporterMemberPresenter();

                    Optional.ofNullable(model.getId()).ifPresent(id -> presenter.setId(id));
                    Optional.ofNullable(model.getName()).ifPresent(name -> presenter.setName(name));
                    Optional.ofNullable(model.getEmail()).ifPresent(email -> presenter.setEmail(email));
                    Optional.ofNullable(model.getBirthDate()).ifPresent(birthDate -> presenter.setBirthDate(birthDate));

                    // iterate over the ids
                    Optional.ofNullable(model.getCampaignIds()).ifPresent(
                            ids -> {

                                List<CampaignPresenter> campaigns = new ArrayList<CampaignPresenter>();

                                ids.forEach(id -> campaigns.add(consumer.findById(id)));

                                presenter.setCampaigns(campaigns);
                            }
                    );

                    return presenter;
                }).orElse(null);
    }

    private SupporterMemberModel convertParamToModel(SupporterMemberParam supporterMemberParam) {
       return Optional.ofNullable(supporterMemberParam)
               .map(param -> {
                   SupporterMemberModel model = new SupporterMemberModel();

                   Optional.ofNullable(param.getId()).ifPresent(id -> model.setId(id));
                   Optional.ofNullable(param.getName()).ifPresent(name -> model.setName(name));
                   Optional.ofNullable(param.getEmail()).ifPresent(email -> model.setEmail(email));
                   Optional.ofNullable(param.getBirthDate()).ifPresent(birthDate -> model.setBirthDate(birthDate));
                   Optional.ofNullable(param.getFootballTeamId()).ifPresent(footballTeamId -> model.setFootballTeamId(footballTeamId    ));

                   Optional.ofNullable(param.getCampaignIds()).ifPresent(ids -> model.setCampaignIds(ids));
                   return model;

               }).orElse(new SupporterMemberModel());
    }

    @Override
    public void associateUserToCampaigns(String userId, String footballTeamId) {

        SupporterMemberParam param = new SupporterMemberParam();

        List<CampaignPresenter> campaigns = consumer.findByFootballTeamId(footballTeamId);

        param.setId(userId);
        param.setCampaignIds(d
                campaigns.stream()
                        .map(CampaignPresenter::getId)
                        .collect(Collectors.toList())
        );

        producer.sendUserAndCampaignIdsToBeAssociated(param);

    }
}
