# Golf Club REST API

This project is a simple REST API for managing a golf club’s members and tournaments. It allows you to create and manage members, tournaments, and associate members with specific tournaments. The project uses Spring Boot, JPA/Hibernate, and MySQL, and it's fully containerized using Docker for easy deployment.

---

## 📦 Features

### ✅ Member Endpoints
- Add new members
- Get all members
- Search members by:
  - Name
  - Membership type
  - Phone number
  - Start date

### ✅ Tournament Endpoints
- Create tournaments
- View all tournaments
- Search tournaments by:
  - Start date
  - Location
- Add members to a tournament
- View all members in a tournament
- Find tournaments a specific member is in

---

## 🔍 Supported Search Endpoints

### Members:
- `GET /members/search?name=John`
- `GET /members/search?membershipType=Gold`
- `GET /members/search?phone=709-555-1234`
- `GET /members/search?startDate=2025-07-01`

### Tournaments:
- `GET /tournaments/search?date=2025-07-01`
- `GET /tournaments/search?location=St. John's`
- `GET /tournaments/{id}/members`
- `GET /tournaments/member/{memberId}`

---

## 🐳 Running with Docker

### Requirements:
- Docker
- Docker Compose

### Steps:
1. Clone the project:
   ```bash
   git clone https://github.com/your-username/golf-club-api.git
   cd golf-club-api

2. Start the application:
    ```bash
    docker-compose up --build

3. Once running, access the API at:
    http://localhost:8080
    
---

### 🧪 Postman Testing
All endpoints were tested using Postman. Screenshots are available in the /screenshots folder to show working functionality for:

- Adding and retrieving members

- Adding and retrieving tournaments

- Adding members to tournaments

- Searching by all required fields

---

### ☁️ AWS Notes
Although full deployment to AWS is not completed, this API is designed to work with AWS RDS. To switch from local MySQL to an RDS instance, simply update your application.properties file with your RDS connection details.

---

### 🧾 Tech Stack
- Java 17

- Spring Boot

- Spring Data JPA

- MySQL

- Docker & Docker Compose

- Postman (for API testing)

