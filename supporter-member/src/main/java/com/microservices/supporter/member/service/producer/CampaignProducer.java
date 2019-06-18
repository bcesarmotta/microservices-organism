package com.microservices.supporter.member.service.producer;

import com.google.gson.Gson;
import com.microservices.commons.param.SupporterMemberParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class CampaignProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Gson gson;

    private final static String ASSOCIATE_CAMPAIGNS_TO_USER_QUEUE = "campaign.associateCampaignsToUser.queue";

    public void sendUserAndCampaignIdsToBeAssociated(SupporterMemberParam param) {
        jmsTemplate.convertAndSend(ASSOCIATE_CAMPAIGNS_TO_USER_QUEUE, gson.toJson(param));
    }
}
