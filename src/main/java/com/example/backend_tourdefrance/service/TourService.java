package com.example.backend_tourdefrance.service;

import com.example.backend_tourdefrance.model.Cyclist;
import com.example.backend_tourdefrance.model.Team;
import com.example.backend_tourdefrance.repository.CyclistRepository;
import com.example.backend_tourdefrance.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class TourService {

  @Autowired
  TeamRepository teamRepository;

  @Autowired
  CyclistRepository cyclistRepository;

  public Cyclist saveCyclist(Cyclist cyclist) {
    return cyclistRepository.save(cyclist);
  }

  public Team saveTeam(Team team) {
    return teamRepository.save(team);
  }

  public List<Cyclist> showAllCyclists(){
    return cyclistRepository.findAll();
  }

  public Cyclist getCyclist(int cyclistId){
    return cyclistRepository.findCyclistById(cyclistId);
  }

  public List<Team> showAllTeams() {
    return teamRepository.findAll();
  }

  public List<Cyclist> showCyclistsByTeam(int team) {
    return cyclistRepository.findCyclistsByTeamId(team);
  }

  public void deleteCyclist(int cyclistId) {
    cyclistRepository.deleteById(cyclistId);
  }

  public List<Team> teamsTimeSorted(){

    List<Team> teams = teamRepository.findAll();
    double time = 0;

    for(Team team : teams){
      Set<Cyclist> cyclists = team.getCyclists();
      for (Cyclist cyclist : cyclists){
        time += cyclist.getTimeTotalHours();
        System.out.println(time);
        team.setTimeTotal(time);
      }
      teamRepository.save(team);
      time = 0;
      System.out.println(time);
    }

    // Kilde: https://www.codebyamir.com/blog/sort-list-of-objects-by-field-java
    List<Team> sortedTeams = teams.stream()
        .sorted(Comparator.comparing(Team::getTimeTotal).reversed())
        .collect(Collectors.toList());

    return sortedTeams;
  }

  public List<Team> teamsMPointSorted(){

    List<Team> teams = teamRepository.findAll();
    int mPoints = 0;

    for(Team team : teams){
      Set<Cyclist> cyclists = team.getCyclists();
      for (Cyclist cyclist : cyclists){
        mPoints += cyclist.getMountainPoints();
        System.out.println(mPoints);
        team.setMountainPointTotal(mPoints);
      }
      teamRepository.save(team);
      mPoints = 0;
      System.out.println(mPoints);
    }

    // Kilde: https://www.codebyamir.com/blog/sort-list-of-objects-by-field-java
    List<Team> sortedTeams = teams.stream()
        .sorted(Comparator.comparing(Team::getMountainPointTotal).reversed())
        .collect(Collectors.toList());

    return sortedTeams;
  }

  public List<Team> teamsSPointSorted(){

    List<Team> teams = teamRepository.findAll();

    int sPoints = 0;

    for(Team team : teams){
      Set<Cyclist> cyclists = team.getCyclists();
      for (Cyclist cyclist : cyclists){
        sPoints += cyclist.getSprintPoints();
        System.out.println(sPoints);
        team.setSprintPointTotal(sPoints);
      }
      teamRepository.save(team);
      sPoints = 0;
      System.out.println(sPoints);
    }

    // Kilde: https://www.codebyamir.com/blog/sort-list-of-objects-by-field-java
    List<Team> sortedTeams = teams.stream()
        .sorted(Comparator.comparing(Team::getSprintPointTotal).reversed())
        .collect(Collectors.toList());

    return sortedTeams;
  }



/*
  public List<Cyclist> getCyclistsByTeam(int id){

    System.out.println(id);
    List<Cyclist> allCyclists = cyclistRepository.findAll();
    List<Cyclist> cyclistsByTeam = new LinkedList<>();
    for(Cyclist cyclist : allCyclists){
      if(cyclist.getTeam().getId() == id){
        cyclistsByTeam.add(cyclist);
      }
    }
    System.out.println(cyclistsByTeam);
    return cyclistsByTeam;
  }
 */
}
