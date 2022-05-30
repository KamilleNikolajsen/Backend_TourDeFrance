package com.example.backend_tourdefrance.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Stage {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String number;

}
