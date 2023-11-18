CREATE TABLE subscriber(
    id uuid primary key,
    name varchar(250) not null,
    reference varchar(50) not null,
    sex char
);

insert into subscriber (id, name, reference, sex) values ('c073c58d-65bd-4381-b8fe-12022920e438', 'Maggi', 'S-001', 'M');
insert into subscriber (id, name, reference, sex) values ('38b6b6fc-48dc-4911-a455-c05bd29346ab', 'Winnie', 'S-002', 'F');
insert into subscriber (id, name, reference, sex) values ('2cd37629-59cf-4ce7-9ee6-9e37c05b7f06', 'Lura', 'S-003', 'M');