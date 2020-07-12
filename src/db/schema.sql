create table if not exists accidenttype
(
    id   serial primary key,
    name varchar(50)
);

create table if not exists accident
(
    id               serial primary key,
    name             varchar(50),
    text             varchar(1000),
    address          varchar(100),
    accidenttype_id int references accidenttype (id)
);

create table if not exists rule
(
    id   serial primary key,
    name varchar(200)
);

create table if not exists accident_rule
(
    accident_id int references accident (id),
    rule_id int references rule (id)
);
