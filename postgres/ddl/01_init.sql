CREATE SCHEMA IF NOT EXISTS app
    AUTHORIZATION postgres;

CREATE TABLE IF NOT EXISTS app.artists
(
    id bigserial,
    name text NOT NULL,
    CONSTRAINT artists_pkey PRIMARY KEY (id)
)

CREATE TABLE IF NOT EXISTS app.genres
(
    id bigserial,
    name text NOT NULL,
    CONSTRAINT genres_pkey PRIMARY KEY (id)
)

CREATE TABLE IF NOT EXISTS app.votes
(
    id bigserial NOT NULL DEFAULT,
    dt_create timestamp without time zone NOT NULL,
    artists bigint NOT NULL,
    genre_1 bigint NOT NULL,
    genre_2 bigint NOT NULL,
    genre_3 bigint NOT NULL,
    genre_4 bigint,
    genre_5 bigint,
    about text NOT NULL,
    CONSTRAINT votes_pkey PRIMARY KEY (id),
    CONSTRAINT votes_artists_fkey FOREIGN KEY (artists)
        REFERENCES app.artists (id) MATCH SIMPLE
    CONSTRAINT votes_genre_1_fkey FOREIGN KEY (genre_1)
        REFERENCES app.genres (id) MATCH SIMPLE
    CONSTRAINT votes_genre_2_fkey FOREIGN KEY (genre_2)
        REFERENCES app.genres (id) MATCH SIMPLE
    CONSTRAINT votes_genre_3_fkey FOREIGN KEY (genre_3)
        REFERENCES app.genres (id) MATCH SIMPLE
    CONSTRAINT votes_genre_4_fkey FOREIGN KEY (genre_4)
        REFERENCES app.genres (id) MATCH SIMPLE
    CONSTRAINT votes_genre_5_fkey FOREIGN KEY (genre_5)
        REFERENCES app.genres (id) MATCH SIMPLE
)