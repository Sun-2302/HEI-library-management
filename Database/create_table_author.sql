CREATE TABLE author(
    id uuid primary key,
    name varchar(50) not null,
    sex char
);

insert into author (id, name, sex) values ('8af32d1a-5c6d-40f1-9b84-83cdc471e1f5', 'Shakespeare', 'M');
insert into author (id, name, sex) values ('aa13ec63-ce74-4de3-bc32-636c4bce1cb1', 'Stephen Hawking', 'M');
insert into author (id, name, sex) values ('51b87b57-5a86-46a6-ab26-4844dec1bfbe', 'Alice Oseman', 'F');