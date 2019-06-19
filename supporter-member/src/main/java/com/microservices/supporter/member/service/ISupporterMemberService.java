package com.microservices.supporter.member.service;

import com.microservices.commons.param.SupporterMemberParam;
import com.microservices.commons.presenter.SupporterMemberPresenter;

public interface ISupporterMemberService {
    SupporterMemberPresenter save(SupporterMemberParam param);
    SupporterMemberPresenter findByEmail(String email);
    void associateUserToCampaigns(String userId, String footballTeamId);
}
