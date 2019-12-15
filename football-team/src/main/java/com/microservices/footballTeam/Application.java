package com.microservices.footballTeam;

import com.microservices.commons.model.FootballTeamModel;
import com.microservices.footballTeam.repository.IFootballTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
public class Application{

    @Autowired
    private IFootballTeamRepository footballTeamRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

