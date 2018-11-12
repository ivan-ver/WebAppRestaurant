DELETE FROM public."users";
ALTER SEQUENCE public."global_seq" RESTART WITH 100000;

INSERT INTO public."users" (name, status, email, password) VALUES
  ('Иван', 'admin', 'ivan_ver89@mail.ru', 'password'),
  ('Сергей', 'user', 'sergey@mail.ru', '123'),
  ('Alex', 'user', 'alex@mail.ru', 'qwe');
