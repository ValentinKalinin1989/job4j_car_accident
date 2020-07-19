CREATE TABLE authorities
(
    id        SERIAL PRIMARY KEY,
    authority VARCHAR(50) NOT NULL unique
);

CREATE TABLE users
(
    id           SERIAL PRIMARY KEY,
    username     VARCHAR(50)  NOT NULL unique,
    password     VARCHAR(100) NOT NULL,
    enabled      BOOLEAN DEFAULT TRUE,
    authority_id INT NOT NULL REFERENCES authorities (id)
);