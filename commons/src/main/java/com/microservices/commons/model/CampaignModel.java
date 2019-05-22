package com.microservices.commons.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class CampaignModel {

    @Id
    private String id;
    private String name;
    private String footballTealId;
    private Date initialEffectiveDate;
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

    public String getFootballTealId() {
        return footballTealId;
    }

    public void setFootballTealId(String footballTealId) {
        this.footballTealId = footballTealId;
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
