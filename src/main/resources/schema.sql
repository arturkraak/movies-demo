DROP TABLE IF EXISTS Movie;

CREATE TABLE Movie (
    id int NOT NULL,
    title varchar(255) NOT NULL,
    release_year int NOT NULL,
    runtime int NOT NULL,
    actors varchar(255) NOT NULL,
    plot varchar(1024) NOT NULL,
    poster_url varchar(1024) NOT NULL,
    genres varchar(255) NOT NULL,
    version INT,
    PRIMARY KEY (id)
);

--         int id,
--         String title,
--         String year,
--         String runtime,
--         String actors,
--         String plot,
--         String posterUrl,
--         String genres,