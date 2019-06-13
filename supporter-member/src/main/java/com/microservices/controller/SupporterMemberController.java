package com.microservices.controller;

import com.microservices.commons.param.SupporterMemberParam;
import com.microservices.service.ISupporterMemberService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("supporter-member")
public class SupporterMemberController {

    @Autowired
    private ISupporterMemberService supporterMemberService;

    @PostMapping
    public ResponseEntity saveSupporterMember(@RequestBody SupporterMemberParam param) {
        return new ResponseEntity(
                supporterMemberService.save(param),
                HttpStatus.CREATED
        );
    }

    private void validateBeforeSave(SupporterMemberParam param) {

    }
}
