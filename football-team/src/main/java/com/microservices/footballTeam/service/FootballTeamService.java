package com.microservices.footballTeam.service;

import com.microservices.commons.model.FootballTeamModel;
import com.microservices.commons.param.FootballTeamParam;
import com.microservices.commons.presenter.FootballTeamPresenter;
import com.microservices.footballTeam.repository.IFootballTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FootballTeamService implements  IFootballTeamService {

    @Autowired
    private IFootballTeamRepository footballTeamRepository;

    @Override
    public FootballTeamPresenter save(FootballTeamParam param) {
        return convertModelToPresenter(footballTeamRepository.save(convertParamToModel(param)));
    }

    @Override
    public List<FootballTeamPresenter> findAll() {
        List<FootballTeamPresenter> presenter = new ArrayList<FootballTeamPresenter>();

        footballTeamRepository.findAll()
                .forEach(footballTeam -> presenter.add(convertModelToPresenter(footballTeam)));

        return presenter;
    }

    @Override
    public FootballTeamPresenter findById(String id) {
        return Optional.ofNullable(id)
                .map(footballTeamId -> convertModelToPresenter(
                        footballTeamRepository.findFootballTeamById(footballTeamId)
                )).orElse(new FootballTeamPresenter());
    }

    private FootballTeamPresenter convertModelToPresenter(FootballTeamModel footballTeamModel) {
        return Optional.ofNullable(footballTeamModel)
                .map(model -> {
                    FootballTeamPresenter presenter = new FootballTeamPresenter();

                    Optional.ofNullable(model.getId()).ifPresent(id -> presenter.setId(id));
                    Optional.ofNullable(model.getName()).ifPresent(name -> presenter.setName(name));
                    Optional.ofNullable(model.getFoundationDate()).ifPresent(foundationDate -> presenter.setFoundationDate(foundationDate));

                    return presenter;
                }).orElse(new FootballTeamPresenter());
    }

    private FootballTeamModel convertParamToModel(FootballTeamParam footballTeamParam) {

        return Optional.ofNullable(footballTeamParam)
                .map(param -> {
                    FootballTeamModel model = new FootballTeamModel();

                    Optional.ofNullable(param.getId()).ifPresent(id -> model.setId(id));
                    Optional.ofNullable(param.getName()).ifPresent(name -> model.setName(name));
                    Optional.ofNullable(param.getFoundationDate()).ifPresent(foundationDate -> model.setFoundationDate(foundationDate));

                    return model;
                }).orElse(new FootballTeamModel());
    }
}
