package com.example.backend_tourdefrance.controller;

import com.example.backend_tourdefrance.model.Cyclist;
import com.example.backend_tourdefrance.model.Team;
import com.example.backend_tourdefrance.service.TourService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class TourRESTController {

  @Autowired
  TourService tourService;

  @PostMapping("/addCyclist")
  public Cyclist addCyclist(@RequestBody Cyclist cyclist){
    return tourService.saveCyclist(cyclist);
  }

  @GetMapping("/showAllCyclists")
  public List<Cyclist> showAllCyclists(){
    return tourService.showAllCyclists();
  }

  @GetMapping("/getCyclist/{id}")
  public Cyclist getCyclist(@PathVariable int id){
    return tourService.getCyclist(id);
  }

  @GetMapping("/showAllTeams")
  public List<Team> showAllTeams(){
    return tourService.showAllTeams();
  }

  @GetMapping("/showCyclistsByTeam/{teamId}")
  public List<Cyclist> showCyclistsByTeam(@PathVariable int teamId){
    return tourService.showCyclistsByTeam(teamId);
  }

  @DeleteMapping("/deleteCyclist/{cyclistId}")
  public void deleteCyclist(@PathVariable int cyclistId){
    tourService.deleteCyclist(cyclistId);
  }

  @PutMapping("/editCyclist")
  public ResponseEntity<Cyclist> editCyclist(@RequestBody Cyclist cyclist){

    Cyclist dbCyclist = tourService.getCyclist(cyclist.getId());

    if(dbCyclist != null){
      tourService.saveCyclist(cyclist);
      return  new ResponseEntity<>(cyclist, HttpStatus.OK);
    }
    return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
  }

  @GetMapping("/bestCountryByTime")
  public List<Team> teamsRangedByTime(){
    List<Team> teams = tourService.showAllTeams();
    return tourService.teamsTimeSorted(teams);
  }

  @GetMapping("/bestCountryBySPoints")
  public List<Team> teamsRangedBySPoint(){
    List<Team> teams = tourService.showAllTeams();
    return tourService.teamsSPointSorted(teams);
  }

  @GetMapping("/bestCountryByMPoints")
  public List<Team> teamsRangedByMPoints(){
    List<Team> teams = tourService.showAllTeams();
    return tourService.teamsMPointSorted(teams);
  }

}
