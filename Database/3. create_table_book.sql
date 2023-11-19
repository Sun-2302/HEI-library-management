CREATE TABLE if not exists book(
    id uuid primary key,
    name varchar(250) not null,
    page_number int not null,
    id_topic int REFERENCES topic(id) not null,
    release_date date,
    availability boolean not null,
    id_author uuid REFERENCES author(id) not null
);

insert into book (id, name, page_number, id_topic, release_date, availability, id_author) values ('eb1f284a-da97-4d4d-881f-8e78d729f041','Une brève histoire du temps',236,3,'1988-03-10',true,'aa13ec63-ce74-4de3-bc32-636c4bce1cb1');
insert into book (id, name, page_number, id_topic, release_date, availability, id_author) values ('38a4a561-6aaf-4d1b-8283-f3a2ac87adb4','Heartstopper - tome 1',288,2,'2019-02-07',true,'51b87b57-5a86-46a6-ab26-4844dec1bfbe');
insert into book (id, name, page_number, id_topic, release_date, availability, id_author) values ('4ab36ed2-3814-48e0-8674-2b39bab30912','Loveless',432,2,'2022-01-03',true,'51b87b57-5a86-46a6-ab26-4844dec1bfbe');
