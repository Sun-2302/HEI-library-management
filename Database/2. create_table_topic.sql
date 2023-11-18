CREATE TABLE topic(
    id int primary key,
    name varchar(250) not null
);

insert into topic (id, name) values (1,'COMEDY');
insert into topic (id, name) values (2,'ROMANCE');
insert into topic (id, name) values (3,'OTHER');