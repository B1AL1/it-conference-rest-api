INSERT INTO USER(id, email, login) VALUES (1, 'test1@test.pl', 'Test1');
INSERT INTO USER(id, email, login) VALUES (2, 'test2@test.pl', 'Test2');
INSERT INTO USER(id, email, login) VALUES (3, 'test3@test.pl', 'Test3');
INSERT INTO USER(id, email, login) VALUES (4, 'test4@test.pl', 'Test4');
INSERT INTO USER(id, email, login) VALUES (5, 'test5@test.pl', 'Test5');
INSERT INTO USER(id, email, login) VALUES (6, 'test6@test.pl', 'Test6');
INSERT INTO USER(id, email, login) VALUES (7, 'test7@test.pl', 'Test7');
INSERT INTO USER(id, email, login) VALUES (8, 'test8@test.pl', 'Test8');
INSERT INTO USER(id, email, login) VALUES (9, 'test9@test.pl', 'Test9');
INSERT INTO USER(id, email, login) VALUES (10, 'test10@test.pl', 'Test10');

INSERT INTO LECTURE(id, title, starting, ending, max_amount_of_users) VALUES (1, 'V is for Visibility: The Essential Cybersecurity Ingredient in a VUCA World.', {ts '2021-06-01 10:00:00.00'}, {ts '2021-06-01 11:45:00.00'}, 5);
INSERT INTO LECTURE(id, title, starting, ending, max_amount_of_users) VALUES (2, 'Cybersecurity First Principles.', {ts '2021-06-01 12:00:00.00'}, {ts '2021-06-01 13:45:00.00'}, 5);
INSERT INTO LECTURE(id, title, starting, ending, max_amount_of_users) VALUES (3, 'Human Security Engineering: Stop Relying on the Failed Human Firewall.', {ts '2021-06-01 14:00:00.00'}, {ts '2021-06-01 15:45:00.00'}, 5);
INSERT INTO LECTURE(id, title, starting, ending, max_amount_of_users) VALUES (4, 'Crouching Hacker, Killer Robot? Removing FUD from Cyber-physical Security.', {ts '2021-06-01 10:00:00.00', {ts '2021-06-01 11:45:00.00'}}, 5);
INSERT INTO LECTURE(id, title, starting, ending, max_amount_of_users) VALUES (5, 'Jak rozmawiać o cyberbezpieczeństwie z CEO?', {ts '2021-06-01 12:00:00.00'}, {ts '2021-06-01 13:45:00.00'}, 5);
INSERT INTO LECTURE(id, title, starting, ending, max_amount_of_users) VALUES (6, 'Czy z Twojej strony XS-wyciekają wrażliwe dane?', {ts '2021-06-01 14:00:00.00'}, {ts '2021-06-01 15:45:00.00'}, 5);
INSERT INTO LECTURE(id, title, starting, ending, max_amount_of_users) VALUES (7, 'Jak przestępcy wykorzystują technologię do kradzieży pieniędzy w oszustwie tzw. "fałszywych inwestycji".', {ts '2021-06-01 10:00:00.00'}, {ts '2021-06-01 11:45:00.00'}, 5);
INSERT INTO LECTURE(id, title, starting, ending, max_amount_of_users) VALUES (8, 'Dziś i jutro e-commerce – jakie trendy zyskują na popularności i znaczeniu?', {ts '2021-06-01 12:00:00.00'}, {ts '2021-06-01 13:45:00.00'}, 5);
INSERT INTO LECTURE(id, title, starting, ending, max_amount_of_users) VALUES (9, '2021 rokiem zakupów online, ale czy do sukcesu wciąż wystarczy tylko sam sklep?', {ts '2021-06-01 14:00:00.00'}, {ts '2021-06-01 15:45:00.00'}, 5);

INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (1, 1, 1, localtimestamp()-365);
INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (2, 1, 5, localtimestamp()-365);
INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (3, 1, 6, localtimestamp()-365);

INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (4, 2, 1, localtimestamp()-365);
INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (5, 2, 2, localtimestamp()-365);
INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (6, 2, 3, localtimestamp()-365);

INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (7, 3, 4, localtimestamp()-365);
INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (8, 3, 8, localtimestamp()-365);
INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (9, 3, 6, localtimestamp()-365);

INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (10, 4, 7, localtimestamp()-365);
INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (11, 4, 2, localtimestamp()-365);
INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (12, 4, 9, localtimestamp()-365);

INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (13, 5, 8, localtimestamp()-365);
INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (14, 5, 9, localtimestamp()-365);

INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (15, 6, 6, localtimestamp()-365);

INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (16, 7, 2, localtimestamp()-365);
INSERT INTO REGISTRATION(id, user_id, lecture_id, created) VALUES (17, 7, 9, localtimestamp()-365);
