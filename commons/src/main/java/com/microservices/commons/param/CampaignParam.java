package com.microservices.commons.param;

import java.util.Date;

public class CampaignParam {

    private String name;
    private String footballTealId;
    private Date initialEffectiveDate;
    private Date finalEffectiveDate;

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
