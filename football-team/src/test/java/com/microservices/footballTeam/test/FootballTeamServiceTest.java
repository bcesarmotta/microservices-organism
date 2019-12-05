package com.microservices.footballTeam.test;

import com.microservices.commons.model.FootballTeamModel;
import com.microservices.commons.param.FootballTeamParam;
import com.microservices.footballTeam.repository.IFootballTeamRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FootballTeamServiceTest {

    /**/
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

    @DisplayName("Test to save a new football teal called Santos")
    @Test
    void testB_saveFootballTeam() throws ParseException {
        FootballTeamModel model = new FootballTeamModel();
        model.setName("Santos Futebol clube");

        model.setFoundationDate(new SimpleDateFormat("dd/MM/yyyy").parse("14/04/1912"));

        when(footballTeamRepository.save(any(FootballTeamModel.class))).thenReturn(model);
    }

    @DisplayName("Test to save a new football teal called São Paulo")
    @Test
    void testC_saveFootballTeam() throws ParseException {
        FootballTeamModel model = new FootballTeamModel();
        model.setName("São Paulo Futebol Clube");

        model.setFoundationDate(new SimpleDateFormat("dd/MM/yyyy").parse("25/01/1930"));

        when(footballTeamRepository.save(any(FootballTeamModel.class))).thenReturn(model);
    }

    @DisplayName("Test to save a new football teal called Corinthians")
    @Test
    void testD_saveFootballTeam() throws ParseException {
        FootballTeamModel model = new FootballTeamModel();
        model.setName("Sport Club Corinthians Paulista");

        model.setFoundationDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/09/1910"));

        when(footballTeamRepository.save(any(FootballTeamModel.class))).thenReturn(model);
    }

}
