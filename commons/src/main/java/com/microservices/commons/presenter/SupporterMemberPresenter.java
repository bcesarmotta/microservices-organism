package com.microservices.commons.presenter;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class SupporterMemberPresenter {

    private String id;

    private String name;

    private String email;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date birthDate;

    private List<CampaignPresenter> campaigns;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<CampaignPresenter> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<CampaignPresenter> campaigns) {
        this.campaigns = campaigns;
    }
}
