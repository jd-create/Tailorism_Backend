/*
Spring runt dit SQL-bestand automatisch. Spring zoekt namelijk naar een bestand dat data.sql heet (in deze folder) en
voert de SQL commando's voor je uit. Dit is een van de manier om de database te vullen. Om dit te laten werken, is het
volgende aan application.properties toegevoegd:

spring.datasource.initialization-mode=always

Zoals gezegd, dit is een van de manieren. De huidige opzet van deze applicatie heeft een vast aantal user-rollen. Deze
kunnen alleen door de rol Operator of Admin aangepast worden. De enige andere manier om iets in de
database te krijgen is via SQL statements in dit bestand.

 */
INSERT INTO role(name) VALUES('ROLE_USER');
INSERT INTO role(name) VALUES('ROLE_ADMIN');
INSERT INTO role(name) VALUES('ROLE_CUSTOMER');
INSERT INTO role(name) VALUES('ROLE_TAILOR');
INSERT INTO role(name) VALUES('ROLE_OPERATOR');

INSERT INTO app_user(username,email,password) VALUES ( 'user','user@mail.nl','$2a$10$44azppeekabMTwZZ1vtq4OWr/SboMJh4KxUOepB8EFkEJH6gbfeQq');
INSERT INTO app_user(username,email,password) VALUES ( 'admin','admin@mail.nl','$2a$10$44azppeekabMTwZZ1vtq4OWr/SboMJh4KxUOepB8EFkEJH6gbfeQq');
INSERT INTO app_user(username,email,password) VALUES ( 'customer','customer@mail.nl','$2a$10$44azppeekabMTwZZ1vtq4OWr/SboMJh4KxUOepB8EFkEJH6gbfeQq');
INSERT INTO app_user(username,email,password) VALUES ( 'tailor','tailor@mail.nl','$2a$10$44azppeekabMTwZZ1vtq4OWr/SboMJh4KxUOepB8EFkEJH6gbfeQq');
INSERT INTO app_user(username,email,password) VALUES ( 'operator','operator@mail.nl','$2a$10$44azppeekabMTwZZ1vtq4OWr/SboMJh4KxUOepB8EFkEJH6gbfeQq');

INSERT INTO address(street, house_number, postcode, city) VALUES ( 'hoofdstraat', '1', '1234AA', 'Bergen');
INSERT INTO address(street, house_number, postcode, city) VALUES ( 'dwarsstraat', '15', '1234AA', 'Bunnik');
INSERT INTO address(street, house_number, postcode, city) VALUES ( 'havenweg', '5', '1234AA', 'Batenburg');
INSERT INTO address(street, house_number, postcode, city) VALUES ( 'beukenlaan', '20', '1234AA', 'hoofdstad');
INSERT INTO address(street, house_number, postcode, city) VALUES ( 'kastanjelaan', '21', '1234AA', 'hoofdstad');

INSERT INTO customerdetails(first_Name,last_Name, telephone_Number, bank_Account) VALUES ( 'Jopie', 'Joviaal', '0612345678', 'BANK123456');
INSERT INTO customerdetails(first_Name,last_Name, telephone_Number, bank_Account) VALUES ( 'Truus', 'Truien', '0612345678', 'BANK123456');
INSERT INTO customerdetails(first_Name,last_Name, telephone_Number, bank_Account) VALUES ( 'Kees', 'Kapper', '0612345678', 'BANK123456');
INSERT INTO customerdetails(first_Name,last_Name, telephone_Number, bank_Account) VALUES ( 'Mark', 'Nevel', '0612345678', 'BANK123456');

INSERT INTO user_role(user_id, role_id) VALUES ( 1, 1 );
INSERT INTO user_role(user_id, role_id) VALUES ( 2, 2 );
INSERT INTO user_role(user_id, role_id) VALUES ( 3, 3 );
INSERT INTO user_role(user_id, role_id) VALUES ( 4, 4 );
INSERT INTO user_role(user_id, role_id) VALUES ( 5, 5 );

INSERT INTO status(name) VALUES ('NEW'), ('ASSIGNED'), ('WAITING'), ('READY'), ('DECLINED'), ('CLOSED'), ('AVAILABLE'), ('BACKORDER'), ('OUT_OF_STOCK'), ('DELIVERED');

INSERT INTO product(product_type,description, product_name, price, storage_location, end_time, start_time, status)VALUES (1, 'Gütermann naaigaren 1000 meter wit' , 'naaigaren1000w', '9.60','A720SL', null, null,1);
INSERT INTO product(product_type,description, product_name, price, storage_location, end_time, start_time, status)VALUES (1, 'Scheepjeswol Catona 106 white 50GR' , 'catona106w50', '2.10','Q030AI', null, null,2);
INSERT INTO product(product_type,description, product_name, price, storage_location, end_time, start_time, status)VALUES (2, 'Jasverlenging' , 'KL2546804', '51.00',null, '202102171500', '202102171100',3);
INSERT INTO product(product_type,description, product_name, price, storage_location, end_time, start_time, status)VALUES (1, 'Hydrofielstof uni bordeaux 200 centimeter' , 'NB3001018', '15.60', 'Z120AS', null, null,4);

INSERT INTO api_order(time_of_order,customer_id)VALUES ('het moment dat deze order is aangemaakt',1);
INSERT INTO api_order(time_of_order,customer_id)VALUES ('het moment dat deze order is aangemaakt',2);
INSERT INTO api_order(time_of_order,customer_id)VALUES ('het moment dat deze order is aangemaakt',3);
INSERT INTO api_order(time_of_order,customer_id)VALUES ('het moment dat deze order is aangemaakt',4);

INSERT INTO order_product(order_id, product_id) VALUES ( 1,1);
INSERT INTO order_product(order_id, product_id) VALUES ( 2,2);
INSERT INTO order_product(order_id, product_id) VALUES ( 3,3);
INSERT INTO order_product(order_id, product_id) VALUES ( 3,4);

