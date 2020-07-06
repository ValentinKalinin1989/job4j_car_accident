create table if not exists accident_type
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
    accident_type_id int references accident_type (id)
);

create table if not exists rule
(
    id   serial primary key,
    name varchar(200)
);

create table if not exists accident_to_rule
(
    accident_rule_id int references accident (id),
    rule_accident_id int references rule (id)
);
