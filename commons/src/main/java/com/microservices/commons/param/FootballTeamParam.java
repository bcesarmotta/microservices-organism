package com.microservices.commons.param;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class FootballTeamParam {

    private String id;

    private String name;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date foundationDate;

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

    public Date getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(Date foundationDate) {
        this.foundationDate = foundationDate;
    }
}
