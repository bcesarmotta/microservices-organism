package com.microservices.commons.presenter;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CampaignPresenter {

    private String id;

    private String name;

    private FootballTeamPresenter footballTeam;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date initialEffectiveDate;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date finalEffectiveDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FootballTeamPresenter getFootballTeam() {
        return footballTeam;
    }

    public void setFootballTeam(FootballTeamPresenter footballTeam) {
        this.footballTeam = footballTeam;
    }

    public Date getInitialEffectiveDate() {
        return initialEffectiveDate;
    }

    public void setInitialEffectiveDate(Date initialEffectiveDate) {
        this.initialEffectiveDate = initialEffectiveDate;
    }

    public Date getFinalEffectiveDate() {
        return finalEffectiveDate;
    }

    public void setFinalEffectiveDate(Date finalEffectiveDate) {
        this.finalEffectiveDate = finalEffectiveDate;
    }
}
