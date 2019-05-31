package com.microservices.campaign.controller;

import com.microservices.campaign.service.ICampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.microservices.commons.param.CampaignParam;

@RestController
@RequestMapping("campaign")
public class CampaignController {

    @Autowired
    private ICampaignService campaignService;

    @PostMapping
    public ResponseEntity postCampaign(@RequestBody CampaignParam param) {

        validateBeforeSave(param);

        return new ResponseEntity(
                campaignService.save(param),
                HttpStatus.CREATED

        );
    }

    @GetMapping
    public ResponseEntity getCampaigns() {
        return new ResponseEntity(
                campaignService.findAll(),
                HttpStatus.OK
        );
    }


    public void validateBeforeSave(CampaignParam param) {

    }
}
