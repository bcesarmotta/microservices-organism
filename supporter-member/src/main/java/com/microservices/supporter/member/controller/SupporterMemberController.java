package com.microservices.supporter.member.controller;

import com.microservices.commons.param.SupporterMemberParam;
import com.microservices.supporter.member.service.ISupporterMemberService;
import com.microservices.supporter.member.service.consumer.CampaignConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("supporter-member")
public class SupporterMemberController {

    @Autowired
    private ISupporterMemberService supporterMemberService;

    @Autowired
    private CampaignConsumer campaignConsumer;

    @PostMapping
    public ResponseEntity saveSupporterMember(@RequestBody SupporterMemberParam param) {

        validateBeforeSave(param);
        return Optional.ofNullable(supporterMemberService.findByEmail(param.getEmail()))
                .map(supporter ->
                        Optional.ofNullable(supporter.getCampaigns())
                            .map(
                                supporterAlreadyExisting -> {
                                    supporterMemberService.associateUserToCampaigns(supporter.getId(), param.getFootballTeamId());
                                    return new ResponseEntity("Usuário já cadastrado!", HttpStatus.OK);
                                }
                            ).orElse(new ResponseEntity(campaignConsumer.findByFootballTeamId(param.getFootballTeamId()),HttpStatus.OK)))
                .orElseGet(() -> new ResponseEntity(supporterMemberService.save(param),HttpStatus.CREATED));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateSupporterMember(@PathVariable String id, @RequestBody SupporterMemberParam param) {
        param.setId(id);
        validateBeforeUpdate(param);
        return new ResponseEntity(supporterMemberService.save(param),HttpStatus.OK);
    }

    private void validateBeforeSave(SupporterMemberParam param) {
        Assert.isTrue(param.getName() != null,"Parameter name must be informed");
        Assert.isTrue(param.getEmail() != null, "E-mail must be informed");
        Assert.isTrue(param.getBirthDate() != null, "Birth date must be informed");
        Assert.isTrue(param.getFootballTeamId() != null, "Football team ID must be informed");
    }

    private void validateBeforeUpdate(SupporterMemberParam param) {
        Assert.isTrue(param.getName() != null,"Parameter name must be informed");
        Assert.isTrue(param.getEmail() != null, "E-mail must be informed");
        Assert.isTrue(param.getBirthDate() != null, "Birth date must be informed");
        Assert.isTrue(param.getFootballTeamId() != null, "Football team ID must be informed");
        Assert.isTrue(param.getCampaignIds().size() > 0, "Campaign ids must be informed");
    }
}
