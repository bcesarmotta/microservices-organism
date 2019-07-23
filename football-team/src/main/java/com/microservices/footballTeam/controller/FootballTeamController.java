package com.microservices.footballTeam.controller;

import com.microservices.commons.param.FootballTeamParam;
import com.microservices.footballTeam.service.IFootballTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("football-team")
public class FootballTeamController extends ExceptionHandlerController {

    @Autowired
    private IFootballTeamService footballTeamService;

    @PostMapping
    public ResponseEntity postFootballTeam(@RequestBody FootballTeamParam param) {
        validateBeforeSave(param);

        return new ResponseEntity(
                footballTeamService.save(param),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity getFootballTeams() {
        return new ResponseEntity(
                footballTeamService.findAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity getFootballTeamById(@PathVariable String id) {
        return new ResponseEntity(
                footballTeamService.findById(id),
                HttpStatus.OK
        );
    }

    private void validateBeforeSave(FootballTeamParam param) {
        Assert.isTrue(param.getName() != null,"Parameter name must be informed");
        Assert.isTrue(param.getFoundationDate() != null,"Parameter foundation date must be informed");
    }
}
