package com.example.springapp.controllers;

import com.example.springapp.model.Team;
import com.example.springapp.repository.StudentRepository;
import com.example.springapp.repository.TeamRepository;
import jdk.javadoc.doclet.Reporter;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teams")

public class TeamController {
    private TeamRepository teamRepository;
    private StudentRepository studentRepository;

    @Autowired
    public TeamController(TeamRepository teamRepository, StudentRepository studentRepository){
        this.teamRepository = teamRepository;
        this.studentRepository = studentRepository;
    }

    @RequestMapping(method=RequestMethod.GET)
    public List<Team> findAllTeams() {
        return teamRepository.findAll();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Team> getTeam(@PathVariable("id") long id){
        Team team = teamRepository.findById(id);
        return new ResponseEntity<Team>(team, HttpStatus.FOUND);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Team> addTeam(@RequestBody Team team){
        teamRepository.save(team);
        return new ResponseEntity<Team>(team, HttpStatus.CREATED);
    }

    @RequestMapping(method=RequestMethod.DELETE)
    public ResponseEntity<TeamRepository> deleteCollection(){
        teamRepository.deleteAll();
        return new ResponseEntity<TeamRepository>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseEntity<Team> deleteTeam(@PathVariable("id") long id){
        Team team = teamRepository.findById(id);
        if(team == null){
            System.out.println("Team not found");
            return new ResponseEntity<Team>(HttpStatus.NOT_FOUND);
        }
        teamRepository.deleteById(id);
        return new ResponseEntity<Team>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method=RequestMethod.PUT)
    public ResponseEntity<TeamRepository> updateCollection(@RequestBody List<Team> newListOfTeams){
        this.teamRepository.deleteAll();
        for(Team newTeam : newListOfTeams){
            teamRepository.save(newTeam);
        }
        return new ResponseEntity<TeamRepository>(HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Team> updateTeam(@RequestBody Team team, @PathVariable("id") long id){
        team.setId(id);
        teamRepository.save(team);
        return new ResponseEntity<Team>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PATCH)
    public ResponseEntity<Team> updatePartOfTeam(@RequestBody Map<String, Object> updates, @PathVariable("id") long id){
        Team team = teamRepository.findById(id);
        if(team == null){
            System.out.println("Team not found!");
            return new ResponseEntity<Team>(HttpStatus.NOT_FOUND);
        }
        if(updates.containsKey("teamName")){
            team.setTeamName((String) updates.get("teamName"));
        }
        teamRepository.save(team);
        return new ResponseEntity<Team>(HttpStatus.NO_CONTENT);
    }
}
