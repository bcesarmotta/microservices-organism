package com.microservices.campaign.service.listener;

import com.google.gson.Gson;
import com.microservices.campaign.service.consumer.SupporterMemberConsumer;
import com.microservices.commons.param.SupporterMemberParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CampaignListener {

    @Autowired
    private Gson gson;

    @Autowired
    private SupporterMemberConsumer suporterMemberConsumer;

    @JmsListener(destination = "campaign.associateCampaignsToUser.queue")
    public void associateCampaignsToUserListener(String message) {
        Optional.ofNullable(message)
                .ifPresent(payload -> {
                    SupporterMemberParam param = gson.fromJson(payload, SupporterMemberParam.class);
                    Optional.ofNullable(param).ifPresent(suporterMemberConsumer::associateCampaignsToUser);
                });
    }
}
