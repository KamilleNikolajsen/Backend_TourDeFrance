use tourDeFrance;

INSERT INTO team(id, name, mountain_point_total, sprint_point_total, time_total) VALUES (1, "Danmark", 0, 0, 0);
INSERT INTO team(id, name, mountain_point_total, sprint_point_total, time_total) VALUES (2, "Norge", 0, 0, 0);
INSERT INTO team(id, name, mountain_point_total, sprint_point_total, time_total) VALUES (3, "Sverige", 0, 0, 0);


INSERT INTO cyclist(id, age, name, time_total_hours, mountain_points, sprint_points, team_id) VALUES (1, 23, "Hella", 5.3, 4, 1, 1);
INSERT INTO cyclist(id, age, name, time_total_hours, mountain_points, sprint_points, team_id) VALUES (2, 28, "Tine", 8.9, 1, 0, 1);
INSERT INTO cyclist(id, age, name, time_total_hours, mountain_points, sprint_points, team_id) VALUES (3, 25, "Simone", 3.7, 7, 3, 1);

INSERT INTO cyclist(id, age, name, time_total_hours, mountain_points, sprint_points, team_id) VALUES (4, 32, "Nina", 6.4, 3, 1, 2);
INSERT INTO cyclist(id, age, name, time_total_hours, mountain_points, sprint_points, team_id) VALUES (5, 27, "Sine", 4.6, 5, 4, 2);
INSERT INTO cyclist(id, age, name, time_total_hours, mountain_points, sprint_points, team_id) VALUES (2, 28, "Time", 8.9, 1, 0, 1);

VALUES
(<{id: }>,
    <{age: }>,
    <{name: }>,
    <{time_total_hours: }>,
    <{mountain_points: }>,
    <{sprint_points: }>,
    <{team_id: }>);


INSERT INTO `tourDeFrance`.`team`
(`id`,
 `name`,
 `mountain_point_total`,
 `sprint_point_total`,
 `time_total`)
VALUES
(<{id: }>,
    <{name: }>,
    <{mountain_point_total: }>,
    <{sprint_point_total: }>,
    <{time_total: }>);