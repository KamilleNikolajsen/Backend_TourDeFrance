CREATE SCHEMA if NOT EXISTS tourDeFrance;
use tourDeFrance;

DROP TABLE if EXISTS cyclist;
DROP TABLE if EXISTS team;

CREATE TABLE cyclist(
                          id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
                          age int NOT NULL,
                          name varchar(255) NOT NULL,
                          time_total_hours DOUBLE NOT NULL,
                          mountain_points int,
                          sprint_points int,
                          team_id int NUT NULL,
                          CONSTRAINT team_id FOREIGN KEY (team_id) REFERENCES team (id)
);

CREATE TABLE team(
                         id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
                         name varchar(255) NOT NULL,
                         mountain_point_total int,
                         sprint_point_total int,
                         time_total DOUBLE,
);
