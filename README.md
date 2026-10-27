# JWT Authentication API

A REST API built using Java, Spring Boot, Spring Security, and JSON Web Tokens (JWT) to demonstrate user registration, login, and role-based authorization.

## Technologies Used

- Java 21
- Spring Boot 3.5.0
- Spring Security
- JWT using JJWT 0.12.6
- Spring Data JPA
- H2 in-memory database
- Maven

## Features

- User registration
- User login and JWT token generation
- JWT-based authentication for protected endpoints
- User profile endpoint
- Role-based authorization for the admin dashboard
- Password handling through the application's security configuration
- Automated Maven test execution

## Prerequisites

- JDK 21 or compatible Java version
- Maven, or the included Maven Wrapper

## Run the Application

Open a terminal in the project root directory and run:

```powershell
.\mvnw.cmd spring-boot:run
```

Alternatively, build the application:

```powershell
.\mvnw.cmd clean package
```

Then run the generated JAR:

```powershell
java -jar target\jwt-auth-api-0.0.1-SNAPSHOT.jar
```

The API runs at:

`http://localhost:8080`

## API Endpoints

| Method | Endpoint | Purpose | Authentication |
|---|---|---|---|
| POST | `/api/auth/register` | Register a user | Not required |
| POST | `/api/auth/login` | Log in and obtain a JWT | Not required |
| GET | `/api/user/profile` | Access the user profile | Bearer token |
| GET | `/api/admin/dashboard` | Access the admin dashboard | Admin role required |

### Register a User

POST `/api/auth/register`

Example request:

```json
{
  "username": "sampleuser",
  "email": "sample@example.com",
  "password": "ChangeThisPassword123!"
}
```

### Log In

POST `/api/auth/login`

Example request:

```json
{
  "username": "sampleuser",
  "password": "ChangeThisPassword123!"
}
```

Use the JWT returned by the login response for protected endpoints.

### Access a Protected Endpoint

GET `/api/user/profile`

Add this HTTP header:

`Authorization: Bearer YOUR_JWT_TOKEN`

Replace `YOUR_JWT_TOKEN` with the token returned by a successful login.

The admin dashboard requires an account with the appropriate admin role. A regular user should not be able to access it.

## Run Tests

Execute the test suite with:

```powershell
.\mvnw.cmd test
```

## Database

The application uses an H2 in-memory database. Data is temporary and may be lost when the application restarts.

## Security Notes

- Do not commit real passwords, production JWT secrets, or other credentials to version control.
- Use a securely generated secret supplied through environment-specific configuration for deployment.
- The included configuration is intended for development and testing, not production deployment.

## Project Structure

- `config` — application and security configuration
- `controller` — REST API endpoints
- `dto` — request and response data objects
- `entity` — database entities
- `repository` — data access
- `security` — JWT and authentication components
- `service` — application business logic
- `src/test` — automated tests

## Project Status

Core registration, login, JWT-protected profile access, and role-based admin access have been tested during development.
