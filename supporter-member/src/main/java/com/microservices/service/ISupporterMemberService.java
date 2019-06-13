package com.microservices.service;

import com.microservices.commons.param.SupporterMemberParam;
import com.microservices.commons.presenter.SupporterMemberPresenter;

public interface ISupporterMemberService {
    SupporterMemberPresenter save(SupporterMemberParam param);
}
