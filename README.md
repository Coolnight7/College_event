# College Event Registration System

A **console-based Java application** that allows students to register for college events and organizers to manage them. It features a **menu-driven interface**, uses **JDBC with PostgreSQL**, and demonstrates **OOP principles** along with **multithreading**.

---

##  Introduction

This project simulates a real-world system where:
- **Organizers** can add new events.
- **Students** can view and register for events.
- All data is stored and retrieved using a PostgreSQL database.

The system is built with **core Java**, **JDBC**, and follows **modular design** using Maven.

---

##  Features

-  Organizer login and event creation  
-  Student registration with event list view  
-  Date validation and input checking  
-  Multithreading for simulated registration feedback  
-  PostgreSQL-based backend with two linked tables (`events`, `registrations`)  
-  Menu-driven console interface  
-  Maven-based project structure

---

##  Technologies Used

- **Java (Core)** – for logic, OOP,multithreading and Exception Handling  
- **PostgreSQL** – for backend relational data  
- **JDBC** – for database connectivity  
- **Maven** – for dependency and project management  
- **VS Code** – as the IDE

---

##  Dependencies

Added via `pom.xml`:

```xml
<dependencies>
  <dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.2</version>
  </dependency>
</dependencies>
```
---

## Prerequisites

Before running the program , you need to have the following in your system:
- Java Development Kit (JDK) 17 or higher
- Apache Maven 3.8.6 or higher
-  PostgreSQL 15 or higher
- create the following tables in a Postgre database:

```sql
     -- Table event details
CREATE TABLE events (
    eid SERIAL PRIMARY KEY,
    ename VARCHAR(100),
    edate VARCHAR(20),  
    eloc VARCHAR(100)
);

-- Table registrations
CREATE TABLE registrations(
	studname VARCHAR(50),
	rolno INT PRIMARY KEY,
	eventId INT
);
```
---
## Contact

Hope you liked the Simple Mini Project , for any questions , modifications or feedback:

  - Name : Amina Subhedar
  - Email: aminasubhedar2022@gmail.com
  - Github: https://github.com/Coolnight7




