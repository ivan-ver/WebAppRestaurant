DROP TABLE IF EXISTS public.assessment;

CREATE TABLE public."assessment"
(
   id               INTEGER REFERENCES users,
   name             VARCHAR                 NOT NULL
);