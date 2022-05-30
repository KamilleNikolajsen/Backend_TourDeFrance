package com.example.backend_tourdefrance.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Cyclist {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private int age;
  private double timeTotalHours;
  private int sprintPoints;
  private int mountainPoints;

  @ManyToOne
  @JoinColumn(name = "team_id")
  private Team team;
}
