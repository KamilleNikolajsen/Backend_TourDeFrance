package com.example.backend_tourdefrance.repository;

import com.example.backend_tourdefrance.model.Cyclist;
import com.example.backend_tourdefrance.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CyclistRepository extends JpaRepository<Cyclist, Integer> {


  List<Cyclist> findCyclistsByTeamId(int team);

  Cyclist findCyclistById(int cyclistId);
}
