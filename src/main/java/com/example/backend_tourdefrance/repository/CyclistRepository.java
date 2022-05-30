package com.example.backend_tourdefrance.repository;

import com.example.backend_tourdefrance.model.Cyclist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CyclistRepository extends JpaRepository<Cyclist, Integer> {


  List<Cyclist> findCyclistByTeam(int teamId);

  Cyclist findCyclistById(int cyclistId);
}
