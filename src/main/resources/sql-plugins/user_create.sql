DROP TABLE IF EXISTS public."users";
DROP SEQUENCE IF EXISTS public."global_seq";

CREATE SEQUENCE global_seq START 100000;
CREATE TABLE public."users"
(
   id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
   name             VARCHAR                 NOT NULL,
   status           VARCHAR                 NOT NULL,
   email            VARCHAR                 NOT NULL,
   password         VARCHAR                 NOT NULL
);