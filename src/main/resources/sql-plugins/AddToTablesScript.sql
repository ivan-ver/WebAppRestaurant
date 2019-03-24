DELETE FROM assessment;
DELETE FROM dish;
DELETE FROM person;
DELETE FROM restaurant;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO person ( email, password, person_name, status) VALUES
  ('ivan_ver89@mail.ru', '$2a$12$OXshbj5eb0ULlLQmuIMJFOnGlvfFCVddxUpbH2xstTOq1egXkmpKC', 'Ivan', 'ROLE_ADMIN'),
  ('dima@mail.com', '$2a$12$f1yrdzK4cWzb8mmH7.XKX.OJwcNVIW6KYH12L/nQSvFYDeoS4Jchq', 'Dmitriy', 'ROLE_USER');
