INSERT INTO USER(id, email, login) VALUES (1, 'test1@test.pl', 'Janusz');
INSERT INTO USER(id, email, login) VALUES (2, 'test2@test.pl', 'Tomasz');
INSERT INTO USER(id, email, login) VALUES (3, 'test3@test.pl', 'Jacek');

INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (1, 1, 1, DATEADD(HOUR, 9, DATE '2021-06-01'));
INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (2, 1, 1, localtimestamp());
INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (3, 1, 1, localtimestamp());
INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (4, 1, 1, localtimestamp());
INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (5, 1, 1, localtimestamp());

INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (6, 2, 1, localtimestamp());
INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (7, 2, 1, localtimestamp());
INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (8, 2, 1, localtimestamp());
INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (9, 2, 1, localtimestamp());
INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (10, 2, 1, localtimestamp());

INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (11, 3, 1, localtimestamp());
INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (12, 3, 1, localtimestamp());
INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (13, 3, 1, localtimestamp());
INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (14, 3, 1, localtimestamp());
INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (15, 3, 1, localtimestamp());