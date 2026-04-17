# Expenso.io
Expenso.io is a expense tracker that tracks users daily expenses.

Overview
Expenso.io is a backend application built with Spring Boot that helps users manage their personal finances. It allows CRUD operations for expenses and categories, with planned features like authentication, a frontend interface, and dashboards for monthly analytics.

✨ Features
Add, update, delete, and view expenses

Planned:

🔒 User authentication (Spring Security + JWT)

🎨 Frontend integration (React/Angular)

📈 Dashboard with monthly analytics

🛠 Tech Stack
Backend: Spring Boot, Spring Data JPA, Hibernate

Database: PostgreSQL

Authentication: Spring Security (planned)

Frontend: React/Angular (planned)

Build Tool: Maven/Gradle

📡 API Endpoints
Method	Endpoint	Description
GET	/http://localhost:8081/v1/expenso/view-expense - Get all expenses
GET	/http://localhost:8081/v1/expenso/view-expense/{id} - Get all expenses
POST	/http://localhost:8081/v1/expenso/add-expense -	Add a new expense
PUT	/http://localhost:8081/v1/expenso/update-expense/{id} -	Update an expense
DELETE	/http://localhost:8081/v1/expenso/delete-expense/{id}	- Delete an expense by id
DELETE	/http://localhost:8081/v1/expenso/delete-expense	- Delete all expenses

🚀 Future Enhancements
User authentication & role-based access

Frontend integration

Analytics dashboard (monthly/weekly reports)

Export expenses to CSV/PDF

🤝 Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you’d like to change.

📜 License
This project is licensed under the MIT License.
