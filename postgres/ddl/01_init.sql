CREATE SCHEMA IF NOT EXISTS app
    AUTHORIZATION postgres;

CREATE TABLE IF NOT EXISTS app.artists
(
    id bigint NOT NULL,
    name text COLLATE NOT NULL,
    CONSTRAINT artists_pkey PRIMARY KEY (id)
)

ALTER TABLE IF EXISTS app.artists
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS app.genres
(
    id bigint NOT NULL,
    name text NOT NULL,
    CONSTRAINT genres_pkey PRIMARY KEY (id)
)

ALTER TABLE IF EXISTS app.genres
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS app.votes
(
    id bigint NOT NULL,
    artist bigint NOT NULL,
    genre_1 bigint NOT NULL,
    genre_2 bigint NOT NULL,
    genre_3 bigint NOT NULL,
    genre_4 bigint NOT NULL,
    genre_5 bigint NOT NULL,
    about text NOT NULL,
    CONSTRAINT votes_pkey PRIMARY KEY (id),
    CONSTRAINT artist FOREIGN KEY (artist)
        REFERENCES app.artists (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT genre_1 FOREIGN KEY (genre_1)
        REFERENCES app.genres (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT genre_2 FOREIGN KEY (genre_2)
        REFERENCES app.genres (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT genre_3 FOREIGN KEY (genre_3)
        REFERENCES app.genres (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT genre_4 FOREIGN KEY (genre_4)
        REFERENCES app.genres (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT genre_5 FOREIGN KEY (genre_5)
        REFERENCES app.genres (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

ALTER TABLE IF EXISTS app.votes
    OWNER to postgres;