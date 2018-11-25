DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;
CREATE TABLE users
(
   user_id        INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
   name           VARCHAR                 NOT NULL,
   email          VARCHAR                 NOT NULL,
   possword       VARCHAR                 NOT NULL,
   status         VARCHAR                 NOT NULL
);