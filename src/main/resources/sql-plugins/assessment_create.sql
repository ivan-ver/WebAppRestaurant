DROP TABLE IF EXISTS public.assessment;

CREATE TABLE public."assessment"
(
   as_id               INTEGER REFERENCES users,
   name             VARCHAR                 NOT NULL
);