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

CREATE TABLE IF NOT EXISTS app.votes
(
    id bigint NOT NULL DEFAULT nextval('app.votes_id_seq'::regclass),
    artist_id bigint NOT NULL DEFAULT nextval('app.votes_artist_id_seq'::regclass),
    about text NOT NULL,
    dt_create timestamp without time zone NOT NULL,
    CONSTRAINT votes_id PRIMARY KEY (id),
    CONSTRAINT fk_artist_id FOREIGN KEY (artist_id)
        REFERENCES app.artists (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)

CREATE TABLE IF NOT EXISTS app.votes_genres
(
    vote_id bigint NOT NULL DEFAULT nextval('app.votes_genres_vote_id_seq'::regclass),
    genre_id bigint NOT NULL DEFAULT nextval('app.votes_genres_genre_id_seq'::regclass),
    CONSTRAINT fk_genre_id FOREIGN KEY (genre_id)
        REFERENCES app.genres (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)

