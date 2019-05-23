package com.microservices.campaign.repository;

import com.microservices.commons.model.CampaignModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICampaignRepository extends MongoRepository<CampaignModel, String> {
}
