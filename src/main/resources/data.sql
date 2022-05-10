INSERT INTO USER(id, email, login) VALUES (1, 'test@test.pl', 'Janusz');

INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (1, 1, 1, localtimestamp());