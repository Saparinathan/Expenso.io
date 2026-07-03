# Expenso.io

A RESTful Expense Management API built with Spring Boot and PostgreSQL.

# Overview

Expenso.io is a RESTful backend application that enables users to track and manage personal expenses through CRUD operations. The project follows a layered architecture and demonstrates backend development practices using Spring Boot, Spring Data JPA, Hibernate, and PostgreSQL.

---

## Features

* Add expenses
* View expenses
* Update expenses
* Delete expenses

## Tech Stack

* Backend : Java, Springboot, Spring MVC
* Database : postgresql
* ORM : Spring data JPA / Hibernate
* Build Tools : Maven
* Version control : Git & GitHub
* IDE : Intelij IDEA
* API Testing : Swagger UI / Postman

 ## Demo Docs

 [Architecture & DB schema](https://github.com/Saparinathan/Expenso.io/tree/230389cd8a218a5d31189a2d10ad083669425349/Docs/Architecture%20%26%20DB%20schema)
 
 [Postman Collections](https://github.com/Saparinathan/Expenso.io/tree/230389cd8a218a5d31189a2d10ad083669425349/Docs/Postman%20Collections)
 
 [Swagger Screenshots](https://github.com/Saparinathan/Expenso.io/tree/230389cd8a218a5d31189a2d10ad083669425349/Docs/swagger%20screenshots)

 ## API Endpoints

| Method | Endpoint | Description |
|----------|----------|----------|
| POST | /expenses | Create expense |
| GET | /expenses | Get all expenses |
| GET | /expenses/{id} | Get expense by ID |
| PUT | /expenses/{id} | Update expense |
| DELETE | /expenses/{id} | Delete expense |
| DELETE | /expenses/{id} | Delete all expense |

## Setup & Installation

### Prerequisites
- [ ] Java 21
- [ ] Spring Boot 3.5.16
- [ ] Postgresql 18.2
- [ ] Maven 3.9

### Clone Project

Clone the git repo : git clone https://github.com/Saparinathan/Expenso.io.git

Change directory : cd Expenso.io

### Database Configuration

Create a postgresql database : 

expense_db

Update application properties :

spring.datasource.url=jdbc:postgresql://localhost:5432/expense_db
spring.datasource.username=your_username
spring.datasource.password=your_password

### Run the application
> mvn spring-boot:run

Application runs on :

> http://localhost:8081

## Planned Features

- JWT Authentication & Authorization
- Pagination & Filtering
- Global Exception Handling
- Logging & Monitoring
- Unit & Integration Testing
- Dashboard & Analytics
- AI-powered Expense Insights
- Cloud Deployment 

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you’d like to change.

## License

This project is licensed under the MIT License.

## Project Status

🚧 Currently under active development
