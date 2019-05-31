package com.microservices.footballTeam.service;

import com.microservices.commons.param.FootballTeamParam;
import com.microservices.commons.presenter.FootballTeamPresenter;

import java.util.List;

public interface IFootballTeamService {

    FootballTeamPresenter save(FootballTeamParam param);
    List<FootballTeamPresenter> findAll();
    FootballTeamPresenter findById(String id);
}
