CREATE SCHEMA dimple_db;

INSERT INTO dimple_db.role (role_id, `description`, `name`)
VALUES (1, `Member`, `Member`), (2, `Donator`, `Donator`), (3, `Volunteer`, `Volunteer`), (4, `Partner`, `Partner`);

SELECT * FROM dimple_db.role;