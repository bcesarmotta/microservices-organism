package com.microservices.repository;

import com.microservices.commons.model.SupporterMemberModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISupporterMemberRepository extends MongoRepository<SupporterMemberModel, String> {
}
