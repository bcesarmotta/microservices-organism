package com.microservices.commons.param;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class SupporterMemberParam {

    private String id;

    private String name;

    private String email;

    private String footballTeamId;

    private List<String> campaignIds;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthDate;

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

    public String getFootballTeamId() {
        return footballTeamId;
    }

    public void setFootballTeamId(String footballTeamId) {
        this.footballTeamId = footballTeamId;
    }

    public List<String> getCampaignIds() {
        return campaignIds;
    }

    public void setCampaignIds(List<String> campaignIds) {
        this.campaignIds = campaignIds;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
