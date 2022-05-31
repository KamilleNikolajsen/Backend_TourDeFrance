package com.example.backend_tourdefrance.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CyclistTest {

  Cyclist cyclist = new Cyclist();

 @BeforeEach
  public void setup(){
   //Act

   cyclist.setName("JUnit Test");
   cyclist.setAge(22);
   cyclist.setTimeTotalHours(2.2);
   cyclist.setSprintPoints(2);
   cyclist.setMountainPoints(2);
 }

 @Test
  public void getCorrectName(){

   //Arrange
   String name = "JUnit Test";

   //Assert
   assertEquals(name, cyclist.getName());
 }

 @Test
  public void getCorretAge(){

   int age = 22;

   assertEquals(age, cyclist.getAge());
 }

  @Test
  public void getCorretTime(){

    double time = 2.2;

    assertEquals(time, cyclist.getTimeTotalHours());
  }

  @Test
  public void getCorretSPoints(){

    int sprintPoints = 2;

    assertEquals(sprintPoints, cyclist.getSprintPoints());
  }

  @Test
  public void getCorretMPoints(){

    int mountainPoints = 2;

    assertEquals(mountainPoints, cyclist.getMountainPoints());
  }

  //------------------- Test With Wrong Inputs ----------------------------

  @Test
  public void wrongInputName(){

    int name = 22;

    assertNotEquals(name, cyclist.getName());
  }

  @Test
  public void wrongInputAge(){

    String age = "String Not Valid";

    assertNotEquals(age, cyclist.getAge());
  }

  @Test
  public void wrongInputTime(){

    String time = "2.2";

    assertNotEquals(time, cyclist.getTimeTotalHours());
  }

  @Test
  public void wrongInputSPoints(){

    String sprintPoints = "22";

    assertNotEquals(sprintPoints, cyclist.getSprintPoints());
  }

  @Test
  public void wrongInputMPoints(){

    String mountainPoints = "22";

    assertNotEquals(mountainPoints, cyclist.getMountainPoints());
  }

}