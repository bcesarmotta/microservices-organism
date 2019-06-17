package com.microservices.repository;

import com.microservices.commons.model.SupporterMemberModel;
import com.microservices.commons.presenter.SupporterMemberPresenter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ISupporterMemberRepository extends MongoRepository<SupporterMemberModel, String> {
    @Query("{ 'email' : ?0 }")
    SupporterMemberModel findByEmail(String email);
}
