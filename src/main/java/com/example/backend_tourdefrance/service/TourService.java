package com.example.backend_tourdefrance.service;

import com.example.backend_tourdefrance.model.Cyclist;
import com.example.backend_tourdefrance.model.Team;
import com.example.backend_tourdefrance.repository.CyclistRepository;
import com.example.backend_tourdefrance.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

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
}
