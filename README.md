# Doctor-Patient Portal (Medi-Connect)
[![Live Demo](https://img.shields.io/badge/Live_Demo-Visit_Site-2ea44f?style=for-the-badge&logo=render&logoColor=white)](https://doctor-patient-portal-08hh.onrender.com/index.jsp)
[![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com/)
[![JSP & Servlets](https://img.shields.io/badge/JSP_&_Servlets-Core-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://jakarta.ee/)
[![Bootstrap](https://img.shields.io/badge/Bootstrap-5-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white)](https://getbootstrap.com/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![Docker](https://img.shields.io/badge/Docker-Containerized-2496ED?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com/)
[![Render](https://img.shields.io/badge/Deployment-Render-46E3B7?style=for-the-badge&logo=render&logoColor=white)](https://render.com/)

> **A secure, full-stack healthcare management system built with Core Java web technologies and modern DevOps practices.**

---

## Overview

The **Doctor-Patient Portal** is a digital solution designed to streamline clinic operations. It bridges the gap between doctors and patients through a responsive, role-based web interface.

Unlike traditional JSP projects, this application is **fully containerized with Docker**, featuring automated database initialization and environment-based configuration, making it cloud-ready and easy to deploy.

### Key Features

#### **Admin Dashboard**
* **User Management:** Add and manage Doctors and Specialists.
* **System Oversight:** View total count of patients, doctors, and appointments.

#### 👨‍⚕️ **Doctor Dashboard**
* **Appointment Management:** View upcoming schedules.
* **Status Updates:** Accept, Reject, or Comment on patient appointments.

#### 👤 **Patient Dashboard**
* **Easy Booking:** Search doctors by specialization and book slots.
* **History:** View past appointment status (Pending/Approved).
* **Secure Access:** User registration, secure login, and session management.

---

## Tech Stack & Architecture

This project follows the **MVC (Model-View-Controller)** design pattern without using heavy frameworks, demonstrating a strong grasp of Core Java Web fundamentals.

| Component | Technology | Description |
| :--- | :--- | :--- |
| **Frontend** | JSP, Bootstrap 5, CSS3 | Responsive UI with dynamic data rendering. |
| **Backend** | Java Servlets, JDBC | Request handling, business logic, and DB connectivity. |
| **Database** | MySQL | Relational data storage for users and appointments. |
| **DevOps** | Docker, Docker Compose | Containerization for consistent environments. |
| **Deployment** | Render | Cloud hosting with automated CI/CD. |

---

## Application Tour

### 1. Landing & General
| Home Page |
| :---: |
| <img src="screenshots/home.png" alt="Home Page" height="400" width="800"/> |

### 2. Login & Register (The Controller)
| Login Page | Signup Page |
| :---: | :---: |
| <img src="screenshots/admin_login.png" alt="Admin Login" width="400"/> | <img src="screenshots/user_signup.png" alt="User Signup" width="400"/> |

### 3. Admin Module (The Controller)
| Admin Login | Admin Dashboard |
| :---: | :---: |
| <img src="screenshots/admin_login.png" alt="Admin Login" width="400"/> | <img src="screenshots/admin_dashboard.png" alt="Admin Dashboard" width="400"/> |

| Manage Doctors | Create New Doctor |
| :---: | :---: |
| <img src="screenshots/admin_view_doctor.png" alt="View Doctors" width="400"/> | <img src="screenshots/admin_doctor_create.png" alt="Create Doctor" width="400"/> |

| Add Specialist | All Appointments (Admin View) |
| :---: | :---: |
| <img src="screenshots/admin_dr_speciality.png" alt="Add Specialty" width="400"/> | <img src="screenshots/admin_patient_appointment.png" alt="Admin Appointments" width="400"/> |

### 4. Doctor Module
| Doctor Dashboard | View Appointments |
| :---: | :---: |
| <img src="screenshots/doctor_dashboard.png" alt="Doctor Dashboard" width="400"/> | <img src="screenshots/doctor_view_appointment.png" alt="Doctor View Appt" width="400"/> |

| Edit Profile |
| :---: |
| <img src="screenshots/doctor_edit_profile.png" alt="Doctor Profile" width="400"/> |

### 5. Patient Module
| Book Appointment | View Status |
| :---: | :---: |
| <img src="screenshots/user_appointment.png" alt="Book Appointment" width="400"/> | <img src="screenshots/user_view_appointment.png" alt="View Status" width="400"/> |

---

## How to Run (The Modern Way)

Since this project is **Dockerized**, you don't need to manually configure Apache Tomcat or MySQL on your machine.

### Prerequisites
* Docker & Docker Compose

### 1. Clone & Run
```bash
# Clone the repository
git clone [https://github.com/ss029v/Healthcare-Management-Application.git](https://github.com/ss029v/Healthcare-Management-Application.git)
cd Doctor-Patient-Portal

# Run with Docker Compose
docker-compose up --build
````

### 2\. Access the App

  * **Application:** Open `http://localhost:8080`
  * **Database (Internal):** The MySQL container initializes automatically with the schema.

-----

##  How to Run (The Traditional Way)

If you prefer using an IDE like Eclipse:

1.  **Database:** Import the `database_schema.sql` file into your local MySQL Workbench.
2.  **Config:** Update `db.properties` with your local MySQL credentials.
3.  **Server:** Add the project to **Apache Tomcat 9.0+** server.
4.  **Run:** Right-click project -\> *Run As* -\> *Run on Server*.

-----

##  Security & Validation

  * **Authentication:** Custom login logic with encrypted password handling.
  * **Session Management:** `HttpSession` is used to protect Dashboard routes (preventing unauthorized URL access).
  * **Input Validation:** both Client-side (HTML5/JS) and Server-side (Java) validation.

-----

##  Contact

**Shreyash Vairagade** (Full Stack Java Developer)

  * **GitHub:**[ss029v](https://github.com/ss029v)
  * **LinkedIn:** .[LinkedIn Profile](https://www.linkedin.com/in/shreyash-vairagade/)
  * **Email:** shreyashvairagadegithub29@gmail.com

-----

 **Like this project?** Give it a Star\!
