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

  public List<Team> teamsTimeSorted(List<Team> teams){

    double time = 0;

    for(Team team : teams){
      List<Cyclist> cyclists = team.getCyclists();
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
        .sorted(Comparator.comparing(Team::getTimeTotal))
        .collect(Collectors.toList());

    return sortedTeams;
  }

  public List<Team> teamsMPointSorted(List<Team> teams){

    int mPoints = 0;

    for(Team team : teams){
      List<Cyclist> cyclists = team.getCyclists();
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

  public List<Team> teamsSPointSorted(List<Team> teams){

    int sPoints = 0;

    for(Team team : teams){
      List<Cyclist> cyclists = team.getCyclists();
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

  public List<Cyclist> cyclistsSortedByTeam(){
    List<Team> teams = teamRepository.findAll();

    List<Team> sortedTeams = teams.stream()
        .sorted(Comparator.comparing(Team::getName).reversed())
        .collect(Collectors.toList());

    List<Cyclist> sortedCyclists = new LinkedList<>();

    for(Team team : sortedTeams){
     List<Cyclist> cyclists = team.getCyclists();
      sortedCyclists.addAll(cyclists);
    }

    System.out.println(sortedCyclists);

    return sortedCyclists;
  }

  public List<Cyclist> cyclistsSortedByTime(){
    List<Cyclist> cyclists = cyclistRepository.findAll();

    List<Cyclist> sortedCyclists = cyclists.stream()
        .sorted(Comparator.comparing(Cyclist::getTimeTotalHours))
        .collect(Collectors.toList());

    return sortedCyclists;
  }

}
