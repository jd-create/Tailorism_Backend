/*
Spring runt dit SQL-bestand automatisch. Spring zoekt namelijk naar een bestand dat data.sql heet (in deze folder) en
voert de SQL commando's voor je uit. Dit is een van de manier om de database te vullen. Om dit te laten werken, is het
volgende aan application.properties toegevoegd:

spring.datasource.initialization-mode=always

Zoals gezegd, dit is een van de manieren. De huidige opzet avn deze applicatie heeft een vast aantal user-rollen. Deze
kunnen niet door eindgebruikers, moderators of admins toegevoegd worden. Alleen de programmeur kan user-rollen
toevoegen. Daarom is er ook geen Service & repo voor de user-rollen geprogrammeerd. De enige manier om dan iets in de
database te krijgen is via SQL statements in dit bestand.

 */
INSERT INTO role(name) VALUES('ROLE_USER');
INSERT INTO role(name) VALUES('ROLE_MODERATOR');
INSERT INTO role(name) VALUES('ROLE_ADMIN');

INSERT INTO app_user(username, email, password, bank_account, phone_number) VALUES ( 'jopie','jede@mail.nl','123456', '00123456', '061234567');
INSERT INTO app_user(username, email, password, bank_account, phone_number) VALUES ( 'eric','erde@mail.nl','123456', '00234567', '062345678');
INSERT INTO app_user(username, email, password, bank_account, phone_number) VALUES ( 'charles','chdr@mail.nl','123456', '00345678', '063456789');
INSERT INTO app_user(username, email, password, bank_account, phone_number) VALUES ( 'max','madr@mail.nl','123456', '00456789', '064567890');

INSERT INTO user_role(user_id, role_id) VALUES ( DEFAULT,1 );
INSERT INTO user_role(user_id, role_id) VALUES ( DEFAULT,2 );
INSERT INTO user_role(user_id, role_id) VALUES ( DEFAULT,3 );
INSERT INTO user_role(user_id, role_id) VALUES ( DEFAULT,3 );