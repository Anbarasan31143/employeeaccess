# Getting Started

A secured microservice built with Spring Boot 3, Java 17, and Spring Security (JWT).
Supports role-based access to employee APIs.

Download & Install postgress
https://www.postgresql.org/download/windows/
and open in UI :pgAdmin4
Ex: C:\Program Files\PostgreSQL\17\pgAdmin 4\runtime\


## Features
- ✅ JWT-based authentication
- ✅ Role-based access (Admin/User)
- ✅ RESTful APIs for employee operations
- ✅ In-memory H2 DB for quick setup
- ✅ Factory Pattern for notification
- ✅ Swagger-ready (add springdoc-openapi if needed)

## How to Run
```bash
git clone https://github.com/<your-username>/employeeaccess.git
cd employeeaccess
./mvnw spring-boot:run
```
Visit Swagger UI (if enabled): `http://localhost:8080/swagger-ui.html`

## Sample Users
| Username | Password | Role  |
|----------|----------|-------|
| admin    | admin123 | ADMIN |
| user     | user123  | USER  |

## API Endpoints
| Method | Endpoint              | Role    | Description                    |
|--------|------------------------|---------|--------------------------------|
| POST   | /api/auth/register     | Public  | Register new user              |
| POST   | /api/auth/login        | Public  | Authenticate user and get JWT |
| GET    | /api/employees/        | ADMIN   | Get all employees              |
| POST   | /api/employees/        | ADMIN   | Add new employee               |
| DELETE | /api/employees/{id}    | ADMIN   | Delete employee by ID          |
*/

Clarification : Reach -> anbarasan.31143@gmail.com