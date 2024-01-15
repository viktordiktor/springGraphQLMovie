create table IF NOT EXISTS  movie (
                       id bigint not null auto_increment,
                       director varchar(255),
                       year integer,
                       title varchar(255),
                       primary key (id)
) engine=InnoDB;

create table IF NOT EXISTS  movie_cast (
                            movie_id bigint not null,
                            movie_cast varchar(255),
                            foreign key (movie_id) references movie(id)
) engine=InnoDB;