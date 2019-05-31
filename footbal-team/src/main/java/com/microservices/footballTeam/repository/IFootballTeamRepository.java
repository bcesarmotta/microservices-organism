package com.microservices.footballTeam.repository;

import com.microservices.commons.model.FootballTeamModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IFootballTeamRepository extends MongoRepository<FootballTeamModel, String> {

    @Query("{ _id : ?0 }")
    FootballTeamModel findFootballTeamById(String id);
}
