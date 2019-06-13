package com.microservices.campaign.repository;

import com.microservices.commons.model.CampaignModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICampaignRepository extends MongoRepository<CampaignModel, String> {

    @Query("{ 'footballTeamId' : ?0 }")
    List<CampaignModel> findAllByFootballTeamId(String id);

    @Override
    void deleteById(String id);
}
