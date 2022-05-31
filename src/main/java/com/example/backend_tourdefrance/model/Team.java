package com.example.backend_tourdefrance.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@Setter
public class Team {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private double timeTotal;
  private int MountainPointTotal;
  private int SprintPointTotal;

  @OneToMany
  @JoinColumn(name = "team_id")
  @JsonBackReference
  private List<Cyclist> cyclists = new LinkedList<>();
}
