create table IF NOT EXISTS movie
(
    id       bigserial not null,
    director varchar(255),
    year     integer,
    title    varchar(255),
    primary key (id)
);

create table IF NOT EXISTS movie_cast
(
    movie_id   bigint not null,
    movie_cast varchar(255),
    foreign key (movie_id) references movie (id)
);