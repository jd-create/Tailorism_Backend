# Tailorism
Een inleiding

## Inhoud
 * [Voorbereiding](#voorbereiding)
 * [Korte uitleg](#korte-uitleg)
    * [Gebruikersrollen](#gebruikersrollen)
    * [Voorbeeld](#voorbeeld)  
    * [Rest endpoints](#rest-endpoints)
 * [Hoe te gebruiken](#hoe-te-gebruiken)
    * [Gebruiker aanmaken](#gebruiker-aanmaken)
    * [Register](#extra informatie voor gebruiker opgeven)  
    * [Inloggen](#inloggen)
    * [Rest endpoint benaderen met access-token](#rest-endpoint-benaderen-met-access-token)
 * [Uitleg code](#uitleg-code)
    * [De payload-package](#de-payload-package-dto)
    * [Json code](#rest-endpoints importeren)
    
## Voorbereiding
 * Pas de databaseinstellingen aan in `src/main/resources/application.properties`
     * Start de applicatie: `mvnw spring-boot:run`

De applicatie is nu klaar voor gebruik.

## Korte uitleg 
Dit project is een applicatie voor een naaiatelier, waar een drietal gebruikers in deelneemt. De klant/customer, 
de naaister/tailor, en het staflid/operator die de administratie doet en aanpassingen kan maken op het systeem. 
Iedereen is bij een eerste inlog user en wordt omgezet naar een klant. Alleen de operator kan rollen aanpassen. Een
gebruiker kan inloggen en vervolgens registreren met extra gegevens. Door de rol kan hij na inlog met de rest endpoint 
kan communiceren waar hij de authorisatie voor heeft.

### Gebruikersrollen
Dit voorbeeld maakt gebruik van drie user-rollen. `tailor`, `operator` , `customer`, `admin`& `user`. 
Elke gebruiker wordt eerst automatisch `customer`. Het is belangrijk om je te realiseren dat wanneer een gebruiker 
de `admin`-rol heeft dat deze dan niet automatisch de `user` en `operator`-rollen heeft. 

### Voorbeeld 
Je maakt een gebruiker aan, geeft geen rol op, deze krijgt automatisch de customerrol. Je logt in met de rol operator, 
en past de rol van de customer aan. Wanneer een gebruiker ingelogd iets vraagt dat niet past bij zijn rechten dan geeft
de applicatie de volgende error terug:
```
HTTP 401 Unauthorized
```

### Rest endpoints.
De back-end is op de volgende end-points te bereiken:
 1. `/api/auth/signup`
    * Hier kun je de volgende JSON sturen om een gebruiker aan te maken, rol is customer.
 2. `/api/auth/signin`
    * Hier kun je login gegevens naar sturen. Je krijgt een Authorisatie-token terug.
#TEST    
 3. `/api/test/all`
    * Iedereen kan data uit deze end-point uitlezen.
 4. `/api/test/user`
    * Alleen (ingelogd) gebruikers met de user-rol kunnen data uit deze API uitlezen.
 5. `/api/test/admin`
     * Alleen (ingelogd) gebruikers met de admin-rol kunnen data uit deze API uitlezen.
 6. `/api/test/customer`
    * Alleen (ingelogd) gebruikers met de customer-rol kunnen data uit deze API uitlezen.
 7. `/api/test/operator`
    * Alleen (ingelogd) gebruikers met de operator-rol kunnen data uit deze API uitlezen.
 8. `/api/test/tailor`
    * Alleen (ingelogd) gebruikers met de tailor-rol kunnen data uit deze API uitlezen.    
#CUSTOMER
 9. `/api/customer/id/{id}`
     * Alleen (ingelogd) gebruikers met de customer-rol kunnen data uit deze API uitlezen.
 10. `/api/customer/lastname/{lastname}`
     * Alleen (ingelogd) gebruikers met de de customer-rol kunnen data uit deze API uitlezen.
 11. `/api/customer/register`
    * Alleen (ingelogd) gebruikers met de customer-rol kunnen data uit deze API uitlezen.     
 13. `/api/customer/upload/customerid/{id}`
     * Alleen (ingelogd) gebruikers met de customer-rol kunnen data uit deze API uitlezen.
 14. `/api/customer/download/customerid/{id}`
    * Alleen (ingelogd) gebruikers met de customer-rol kunnen data uit deze API uitlezen.    
 15. `/api/customer/address/customer_lastname/{lastname}`
    * Alleen (ingelogd) gebruikers met de operator-rol kunnen data uit deze API uitlezen.
#OPERATOR
 16. `/api/operator/customer/list`
     * Alleen (ingelogd) gebruikers met de operator-rol kunnen data uit deze API uitlezen.
 8. `/api/operator/customer/lastname/{lastname}`
     * Alleen (ingelogd) gebruikers met de operator-rol kunnen data uit deze API uitlezen.
 8. `/api/operator/customer/id/{id}`
    * Alleen (ingelogd) gebruikers met de operator-rol kunnen data uit deze API uitlezen. 
 8. `/api/customer/order/list`
     * Alleen (ingelogd) gebruikers met de operator-rol kunnen data uit deze API uitlezen.
 8. `/api/customer/product/list`
     * Alleen (ingelogd) gebruikers met de tailor-rol kunnen data uit deze API uitlezen.
 8. `/api/customer/addressbystreetandhousenumber/list`
    * Alleen (ingelogd) gebruikers met de tailor-rol kunnen data uit deze API uitlezen.   
#ORDER
8. `/api/order/list`
    * Alleen (ingelogd) gebruikers met de operator-rol kunnen data uit deze API uitlezen.
#PRODUCT
8. `/api/product/list`
    * Alleen (ingelogd) gebruikers met de tailor-rol kunnen data uit deze API uitlezen.
    
## Hoe te gebruiken.
Je kunt tegen de hierboven genoemde rest-points communiceren.

### Gebruiker aanmaken
Praat via Postman met de volgende link: `http://localhost:8080/api/auth/signup` en geef de volgende JSON in de body mee:

#### Gebruiker aanmaken, rol wordt automatisch customer
```json
{
    "username": "user",
    "email" : "user@mail.nl",
    "password" : "password"
}
```
### Register: Extra informatie van de klant/customer opgeven
````json
{
"firstName": "Tjerk",
"lastName": "Tiktok",
"street": "tafelbergweg",
"houseNumber": "5",
"postcode": "1234XX",
"city": "Lutjebroek",
"phoneNumber": "0687654329",
"bankAccount": "BANK654329"
}
````
### Inloggen
Wanneer je inlogt geeft de backend-server een Json WebToken terug. Bewaar deze, want deze moet je meesturen.
Praat via Postman met de volgende link: `http://localhost:8080/api/auth/signin` en geef de volgende JSON in de body mee:
#### Inloggen user
```json
{
    "username":"user",
    "password":"password"
}
```
### In de data.sql staan enkele rollen voorgeprogrammeerd. Hierdoor kun je inloggen met de andere rollen. Het idee was
### om de operator de andere rollen aan te laten passen. Dit is een feature die ik later graag meeneem.

#### Resultaat
De backend-server communiceert het volgende (soortgelijks) terug:
```json
{
  "id": 1,
  "username": "user",
  "email": "user@mail.nl",
  "roles": [
    "ROLE_USER"
  ],
  "tokenType": "Bearer",
  "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNjE0NTM2MTg4LCJleHAiOjE2MTQ2MjI1ODh9.zRyyHsPl4X0_vMt1OMfPhTgHgSctuhs0fzUlI0KipxOS_qSxtnkJd1-xLIIrN5-3VXMtYjqH0epUWVa-mzLOhg"
}
```

Wil je als ingelogde gebruiker nu tegen de beveiligde rest-points aanpraten dan moet je altijd `tokenType` en
`accesstoken` meesturen. Zie volgend kopje.

### Rest endpoint benaderen met access-token
Op het moment dat bovenstaande is gelukt, dan heb je van de server een Bearer + access  token ontvangen. Spring security
geeft deze uit en controleert op basis van die token wat de gebruiker wel of niet mag doen op de website. Dus willen we
praten met één van de drie beveiligde rest endpoints, dan moeten we token type + access token meegeven in postman. Dat
doen we zo:

![Plaatje postman met Authorization](img/auth_postman_example.png)

Onder het kopje headers voeg je als `Key` `Authorization` toe. Daarin zet je `<TOKEN TYPE> <SPATIE> <ACCESSTOKEN>`. 
Zonder de <>. Zie plaatje hierboven.

De volgende resultaten worden teruggegevn door de server, wanneer het succesvol is:

 1. `/api/test/all`
    * Iedereen kan data uit deze end-point uitlezen.
    * `Public Content.`
 2. `/api/test/user`
    * Alleen (ingelogd) gebruikers met de user-rol kunnen data uit deze API uitlezen.
    * `User Content.`
 3. `/api/test/admin`
     * Alleen (ingelogd) gebruikers met de admin-rol kunnen data uit deze API uitlezen.
     `Admin Board.`
 4. `/api/test/customer`
     * Alleen (ingelogd) gebruikers met de customer-rol kunnen data uit deze API uitlezen.
     `Customer Board.`
 5. `/api/test/tailor`
    * Alleen (ingelogd) gebruikers met de tailor-rol kunnen data uit deze API uitlezen.
      `Tailor Board.`
 6. `/api/test/operator`
    * Alleen (ingelogd) gebruikers met de operator-rol kunnen data uit deze API uitlezen.
      `Operator Board.`
      
## Uitleg code
Dit hoofdstuk legt verschillende stukken code uit.

### De payload-package (DTO)
Dit voorbeeld maakt gebruik van DTO's. DTO's zijn Data Transfer Objects. Data Transfer Objects zijn objecten die
gebruikt worden om te communiceren tussen verschillende lagen. Deze zijn onderverdeeld in een request (te ontvangen 
objecten) en een response (antwoord-objecten) package.

#### Request package
Hier vind je `SignupRequest.java` en `LoginRequest.java`en `RegisterUserRequest`. 
De eerste klasse is het object dat binnenkomt om een gebruiker te registreren. 
Het tweede object is het object dat binnenkomt om de login af te handelen. De laatste is om extra informatie over de
klant/customer te vullen. 

### De Json code in Postman
In de root van het project staat het volgende bestand: Tailorism.postman_collection.json dit bestand kun je importeren 
in postman. In de installatiehandleiding leg ik uit hoe. 