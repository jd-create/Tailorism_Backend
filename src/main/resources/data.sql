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
INSERT INTO role(name) VALUES('ROLE_CUSTOMER');
INSERT INTO role(name) VALUES('ROLE_TAILOR');

INSERT INTO app_user(username,email,password) VALUES ( 'user','user@mail.nl','$2a$10$44azppeekabMTwZZ1vtq4OWr/SboMJh4KxUOepB8EFkEJH6gbfeQq');
INSERT INTO app_user(username,email,password) VALUES ( 'moderator','mod@mail.nl','$2a$10$44azppeekabMTwZZ1vtq4OWr/SboMJh4KxUOepB8EFkEJH6gbfeQq');
INSERT INTO app_user(username,email,password) VALUES ( 'admin','admin@mail.nl','$2a$10$44azppeekabMTwZZ1vtq4OWr/SboMJh4KxUOepB8EFkEJH6gbfeQq');
INSERT INTO app_user(username,email,password) VALUES ( 'customer','customer@mail.nl','$2a$10$44azppeekabMTwZZ1vtq4OWr/SboMJh4KxUOepB8EFkEJH6gbfeQq');
INSERT INTO app_user(username,email,password) VALUES ( 'tailor','tailor@mail.nl','$2a$10$44azppeekabMTwZZ1vtq4OWr/SboMJh4KxUOepB8EFkEJH6gbfeQq');

INSERT INTO address(street, house_number, postcode, city) VALUES ( 'hoofdstraat', '1', '1234AA', 'hoofdstad' );

INSERT INTO customer(first_Name,last_Name, telephone_Number, bank_Account) VALUES ( 'jopie', 'joviaal', '0612345678', 'BANK123456' );

INSERT INTO user_role(user_id, role_id)VALUES ( '1', '1' );
INSERT INTO user_role(user_id, role_id)VALUES ( '2', '2' );
INSERT INTO user_role(user_id, role_id)VALUES ( '3', '3' );
INSERT INTO user_role(user_id, role_id)VALUES ( '4', '4' );
INSERT INTO user_role(user_id, role_id)VALUES ( '5', '5' );

INSERT INTO product(product_type,description, name, price, is_available, storage_location, end_time, start_time)VALUES ( '1', 'Gütermann naaigaren 1000 meter wit' , 'naaigaren1000w', '9.60', TRUE, 'A-720-SL', null, null)

INSERT INTO api_order(time_of_order)VALUES ('het moment dat deze order is aangemaakt' )