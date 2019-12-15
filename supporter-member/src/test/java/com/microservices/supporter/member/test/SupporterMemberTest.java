package com.microservices.supporter.member.test;

import com.microservices.commons.model.SupporterMemberModel;
import com.microservices.supporter.member.repository.ISupporterMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SupporterMemberTest {

    @Mock
    private ISupporterMemberRepository supporterMemberRepository;

    @DisplayName("Test to save a new football teal called Palmeiras")
    @Test
    void testA_saveSupporterMember() throws ParseException {
        SupporterMemberModel model = new SupporterMemberModel();
        model.setName("Bruno César Motta");
        model.setEmail("bcesarmotta@yahoo.com.br");
        model.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse("26/04/1992"));

        when(supporterMemberRepository.save(any(SupporterMemberModel.class))).thenReturn(model);
    }

    @DisplayName("Test to return a list of supporter members from the service")
    @Test
    void testB_listFootballTeams() throws ParseException {

        assertEquals(supporterMemberRepository.findAll(), Arrays.asList());
    }

    @DisplayName("Test to return a supporter member from the service based on id")
    @Test
    void testC_listFootballTeamById() throws ParseException {
        SupporterMemberModel model = supporterMemberRepository.findAll().stream().findFirst().orElse(new SupporterMemberModel());
        when(supporterMemberRepository.findById(model.getId())).thenReturn(java.util.Optional.of(model));
    }
}
