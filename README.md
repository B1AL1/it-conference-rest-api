# IT conference REST API
## Purpose of the project
REST API to handle IT conference written for needs of recruitment process.


## Software required to run project
- IntelliJ IDEA 2021.3.3

## How to run project
You have to clone the repository.
Then open project in IntelliJ IDEA and add configuration on main. After that build project.
You have to enable Lombom if the IDE ask you for that.

## Testing
If the project launched without any problems go to site and test endpoints:

<a href="http://localhost:8080/swagger-ui/index.html#/" target="_blank">LINK</a>

## Features
- User can view conference plan,
- User can view lectures where he signed up by entering the login,
- If the lecture has free places, then user can sign up by enering login and email,
- If there is user in data base with the given login and diffrent email, system send messege that the login is taken,
- If the registration is correct then date, receiver and content of email are stored into txt file, 
- User can cancel registration,
- User can update his email,
- System gives opportunity to view list of registered users with ther emails,
- System gives opportunity to generate statistics for organizers:
  - the percentage of participants in a given lecture,
  - the percentage of participants in a given thematic path

## Technologies
- Java 18,
- Maven,
- Spring Boot 2.6.7.
- Swagger (OpenAPI),
- Lombok,
- JPA,
- JSON,
- H2

## Available endpoints

![image](https://user-images.githubusercontent.com/64408066/168271734-e6a62313-e8db-44dc-ae11-8008f07ad3e8.png)
