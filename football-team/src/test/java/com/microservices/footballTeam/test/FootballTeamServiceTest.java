package com.microservices.footballTeam.test;

import com.microservices.commons.model.FootballTeamModel;
import com.microservices.footballTeam.repository.IFootballTeamRepository;
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
public class FootballTeamServiceTest {

    @Mock
    private IFootballTeamRepository footballTeamRepository;

    @DisplayName("Test to save a new football teal called Palmeiras")
    @Test
    void testA_saveFootballTeam() throws ParseException {
        FootballTeamModel model = new FootballTeamModel();
        model.setName("Sociedade Esportiva Palmeiras");

        model.setFoundationDate(new SimpleDateFormat("dd/MM/yyyy").parse("26/08/1914"));

        when(footballTeamRepository.save(any(FootballTeamModel.class))).thenReturn(model);
    }

    @DisplayName("Test to return a list of football teams from the service")
    @Test
    void testB_listFootballTeams() throws ParseException {

        assertEquals(footballTeamRepository.findAll(), Arrays.asList());
    }

    @DisplayName("Test to return a football team from the service based on id")
    @Test
    void testC_listFootballTeamById() throws ParseException {
        FootballTeamModel model = footballTeamRepository.findAll().stream().findFirst().orElse(new FootballTeamModel());
        when(footballTeamRepository.findById(model.getId())).thenReturn(java.util.Optional.of(model));
    }
}
