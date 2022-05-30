package com.example.backend_tourdefrance.service;

import com.example.backend_tourdefrance.model.Cyclist;
import com.example.backend_tourdefrance.model.Team;
import com.example.backend_tourdefrance.repository.CyclistRepository;
import com.example.backend_tourdefrance.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

  public List<Cyclist> showCyclistsByTeam(int teamId) {
    return cyclistRepository.findCyclistByTeam(teamId);
  }

  public void deleteCyclist(int cyclistId) {
    cyclistRepository.deleteById(cyclistId);
  }

  public void deleteTeam(int teamId) {
    teamRepository.deleteById(teamId);
  }
}
