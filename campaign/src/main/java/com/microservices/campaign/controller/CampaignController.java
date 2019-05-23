package com.microservices.campaign.controller;

import com.microservices.campaign.service.ICampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microservices.commons.param.CampaignParam;

@RestController("campaign")
public class CampaignController {

    @Autowired
    private ICampaignService campaignService;

    @RequestMapping
    public ResponseEntity postCampaign(@RequestBody CampaignParam param) {

        validateBeforeSave(param);

        return new ResponseEntity(
                campaignService.save(param),
                HttpStatus.CREATED

        );
    }

    public void validateBeforeSave(CampaignParam param) {

    }
}
