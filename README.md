# 🏠 Renta
## 📱 Overview
**Renta** is a desktop application developed using JavaFX and SQLite that allows users to browse, manage, and book boarding houses or apartments. The system supports two distinct types of users: **Tenants** and **Landlords**, each with their own tailored dashboard and functionalities. This project demonstrates the practical use of **Object-Oriented Programming (OOP)** and a **local database (SQLite)** to manage rental listings and booking transactions.

---

## 🎯 Features

### 👤 Tenant
* View available boarding houses and apartments
* Search and filter listings
* View property details
* Book or reserve a property
* View real-time booking status
* Leave reviews for properties

### 🏠 Landlord
* Add new property listings
* Edit or delete existing listings
* Manage property availability
* View incoming booking requests
* Approve or reject bookings
* Automatic availability update upon booking approval

---

## 🧱 Tech Stack

| Layer | Technology |
|---|---|
| Language | Java |
| UI Framework | JavaFX (FXML + CSS) |
| Architecture | MVC (Model-View-Controller) |
| Database | SQLite |
| DB Driver | SQLite JDBC |
| Build Tool | Maven |
| IDE | IntelliJ IDEA |
| UI Designer | SceneBuilder |
| Version Control | Git + GitHub |

---

## 🗄️ Database

The application utilizes a local database implemented with **SQLite**.

### Main Tables:
* Users
* Properties
* Rooms
* Bookings
* Reviews

---

## 📊 System Diagrams

### Class Diagram
![Renta Class Diagram](https://github.com/user-attachments/assets/da1fdca9-e587-4d63-9420-4ccce3703590)

### Use Case Diagram
![Renta Use Case Diagram](https://github.com/user-attachments/assets/f0bd9c72-71e9-4c02-986e-bb5d7f599446)

---

## 👥 Team

| Role | Responsibilities |
|---|---|
| Backend & Database | Models, DAOs, DatabaseHelper, schema.sql, seed.sql |
| Frontend & UI | FXML views, CSS styling, SceneBuilder layouts |
| Feature Logic & Integration | Controllers, SessionManager, App.java, business logic |

---

**How to Run (IntelliJ IDEA)**
1. Open the project in IntelliJ
2. Right‑click `pom.xml` → **Add as Maven Project**
3. Open the **Maven tab** (on the right side of IntelliJ)
4. Expand **Plugins → javafx → javafx:run**
5. Double‑click `javafx:run` to launch the app
   
---

## 🧠 Project Purpose

The goal of this project is to simulate a functional **boarding house booking management system** using a structured, offline database while practically applying core programming concepts such as OOP, database management, and desktop UI design using JavaFX.

---

## 📌 Notes

* This is a school project and relies entirely on a **local database** (no internet connection is required).
* Some features may still be actively under development.

---

## 📄 License

This project is developed for academic purposes only.
