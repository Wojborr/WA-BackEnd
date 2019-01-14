create table client
(
	id bigint not null
		constraint client_pkey
			primary key,
	login varchar(255),
	password varchar(255),
	username varchar(255),
	usersurname varchar(255),
	wallet double precision
);

create table movie
(
	id bigint not null
		constraint movie_pkey
			primary key,
	director varchar(255),
	moviename varchar(255),
	payment double precision,
	production_year date,
	quantity integer not null,
	type integer
);


create table client_movies
(
	client_id bigint not null
		constraint fk1pfamvhj9px3km1ehv5rbhw6n
			references client,
	movies_id bigint not null
			unique
		constraint fke7an5xsnbwpebcyx641jobjfc
			references movie
);

INSERT INTO "public"."client" ("id", "login", "password", "username", "usersurname", "wallet") VALUES (1, 'login', 'login', 'Arkadiusz', 'Maciąg', 2000);


INSERT INTO "public"."movie" ("id", "director", "moviename", "payment", "production_year", "quantity", "type") VALUES (1, 'Janek Muzykant', 'Gra o Szron', 100, '2019-01-07', 1000, 0);

INSERT INTO "public"."movie" ("id", "director", "moviename", "payment", "production_year", "quantity", "type") VALUES (2, 'Gosia Samosia', 'Mleko', 100, '2019-01-17', 1000, 1);

INSERT INTO "public"."movie" ("id", "director", "moviename", "payment", "production_year", "quantity", "type") VALUES (3, 'Jaker Zegarek', 'Zegarmistrz', 100, '2019-01-04', 1000, 2);

