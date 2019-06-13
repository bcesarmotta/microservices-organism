package com.microservices.commons.param;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CampaignParam {

    private String id;

    private String name;

    private String footballTeamId;

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

    public String getFootballTeamId() {
        return footballTeamId;
    }

    public void setFootballTeamId(String footballTeamId) {
        this.footballTeamId = footballTeamId;
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
