USE test;
DROP TABLE IF EXISTS Game;

CREATE TABLE Game
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    releaseDate INT
);

INSERT INTO Game (name, Game.releaseDate)
VALUES ('God of War', 20180420),
       ('Shogun 2', 20110315),
       ('Counter-Strike', 19991108),
       ('Dota 2', 20130709),
       ('Rust', 20180208);