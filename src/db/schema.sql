CREATE TABLE IF NOT EXISTS accidenttype
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS accident
(
    id               SERIAL PRIMARY KEY,
    name             VARCHAR(50),
    text             VARCHAR(1000),
    address          VARCHAR(100),
    accidenttype_id INT REFERENCES accidenttype (id)
);

CREATE TABLE IF NOT EXISTS rule
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS accident_rule
(
    accident_id INT REFERENCES accident (id),
    rule_id INT REFERENCES rule (id)
);
