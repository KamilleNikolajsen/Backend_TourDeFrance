package com.example.backend_tourdefrance.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Team {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;

  @OneToMany
  @JoinColumn(name = "team_id")
  private Set<Cyclist> cyclists = new HashSet<>();
}
