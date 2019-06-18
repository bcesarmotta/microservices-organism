package com.microservices.supporter.member.repository;

import com.microservices.commons.model.SupporterMemberModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ISupporterMemberRepository extends MongoRepository<SupporterMemberModel, String> {
    @Query("{ 'email' : ?0 }")
    SupporterMemberModel findByEmail(String email);
}
