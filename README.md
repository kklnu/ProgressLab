# ProgressLab

ProgressLab is a full-stack fitness tracking web application designed to help users set fitness goals, track progress, monitor body measurements, and receive personalized AI-assisted fitness guidance.

The project combines a Java/Spring Boot backend with a responsive web frontend, MySQL persistence, secure user authentication, and an AI-powered coaching system.

> 🚧 **Status: Active Development**  
> ProgressLab is currently under active development. Core authentication functionality is complete, while fitness goal management, progress tracking, and AI coaching features are continuing to evolve.

---

## ✨ Features

### 🔐 Authentication

- User registration with email and password validation
- Secure password hashing
- User login
- Forgot-password workflow
- Password reset through email
- Time-limited password reset tokens
- Reset token expiration and cleanup

### 🎯 Fitness Goal Setup

- Interactive goal selection interface
- Multiple fitness goal categories
- Goal-specific setup flow
- Foundation for personalized goal tracking

Current goal options include:

- Lose Weight
- Gain Weight
- Build Muscle
- Get Toned
- Improve Endurance
- Stay Consistent
- General Fitness

### 📊 Fitness Dashboard

A dashboard interface designed to provide users with a centralized view of their fitness journey.

The dashboard is being developed to support:

- Fitness goal progress
- Weight tracking
- BMI information
- Progress trends
- Measurements
- Workout information
- Quick actions for fitness logging

### 🤖 AI Fitness Coach

ProgressLab includes an AI coaching layer integrated with the Spring Boot backend.

Current AI functionality includes:

- Conversational fitness coach endpoint
- AI-generated fitness guidance
- Function/tool calling from the AI layer
- Retrieval of user fitness goal information
- Context-aware responses based on fitness data

The AI coach is being expanded alongside the application's fitness tracking features.

---

## 🛠️ Tech Stack

### Backend

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Maven
- REST APIs

### Frontend

- HTML
- CSS
- JavaScript

### Database

- MySQL
- JPA / Hibernate

### AI Integration

- Google Gemini API
- Function calling / tool integration

### Development Tools

- Git
- GitHub
- VS Code
- Maven
- MySQL Workbench

---

## 🏗️ Project Architecture

ProgressLab separates frontend, backend, data access, and AI-related responsibilities.

```text
ProgressLab/
│
├── backend/
│   └── src/main/java/com/progresslab/progresslab/
│       ├── controller/
│       ├── dto/
│       ├── model/
│       ├── repository/
│       ├── service/
│       └── tool/
│
├── frontend/
│   ├── css/
│   ├── images/
│   ├── js/
│   └── *.html
│
└── README.md
```

The backend follows a layered structure:

```text
Client
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
MySQL Database
```

This separation keeps request handling, business logic, and persistence responsibilities organized independently.

---

## 🔄 Application Flow

A typical request follows this flow:

```text
Browser / Frontend
        ↓
   HTTP Request
        ↓
Spring Boot Controller
        ↓
      Service
        ↓
    Repository
        ↓
      MySQL
        ↓
   HTTP Response
        ↓
Browser / Frontend
```

The frontend communicates with the Spring Boot backend using JavaScript and HTTP requests.

---

## 🔒 Security

ProgressLab includes several security-focused design decisions:

- Passwords are stored using secure hashing rather than plain text
- Password reset tokens expire after a limited period
- Sensitive application configuration is excluded from version control
- Local credentials and API keys are stored outside the public repository
- An example configuration file can be used to document required settings without exposing credentials

---

## 🚧 Current Development

### Completed / Implemented

- [x] User registration
- [x] Login
- [x] Password hashing
- [x] Forgot-password email workflow
- [x] Password reset
- [x] Reset-token expiration
- [x] Dashboard interface
- [x] Initial AI coach backend integration
- [x] AI tool/function calling foundation
- [x] Initial fitness goal selection interface

### In Progress / Planned

- [ ] Complete fitness goal persistence and management
- [ ] Body measurement tracking
- [ ] Weight history
- [ ] BMI calculation and healthy-range feedback
- [ ] Goal progress visualization
- [ ] Workout logging
- [ ] Expanded dashboard analytics
- [ ] Deeper AI coach personalization
- [ ] Additional validation and testing
- [ ] Responsive UI improvements

---

## 🎯 Project Goals

ProgressLab is being developed to explore and apply software engineering concepts including:

- Full-stack application development
- REST API design
- Layered backend architecture
- Relational database design
- Authentication and security
- Frontend/backend integration
- AI integration with application data
- Git-based development workflows

The long-term goal is to create a fitness platform that remains simple for everyday users while providing increasingly personalized insights as more fitness data becomes available.

---

## 👩‍💻 Author

**Kiranpreet Kaur**

Computer Science student focused on software engineering, Java backend development, full-stack applications, and applied AI.

GitHub: [@kklnu](https://github.com/kklnu)