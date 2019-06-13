package com.microservices.campaign.controller;

import com.microservices.campaign.service.ICampaignService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.microservices.commons.param.CampaignParam;

import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity getCampaignById(@PathVariable String id) {
        return new ResponseEntity(
                campaignService.findById(id),
                HttpStatus.OK
        );
    }

    @GetMapping("/footballTeam/{footballTeamId}")
    public ResponseEntity getCampaignsByFootballTeamId(@PathVariable String footballTeamId) {
        return new ResponseEntity(
                campaignService.findAllByFootballTeamId(footballTeamId),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCampaign(@PathVariable String id, @RequestBody CampaignParam param) {
        validateBeforeUpdate(param);

        return new ResponseEntity(
                campaignService.save(param),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCampaign(@PathVariable String id) {
        campaignService.deleteById(id)
;        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    public void validateBeforeSave(CampaignParam param) {

    }

    public void validateBeforeUpdate(CampaignParam param) {

    }
}
