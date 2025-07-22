# JavaExam2025
The exam focused on developing a Java application that reads data from a text file and imports it into a SQL database using JDBC and Maven. A user menu allows basic queries against the database. 

# Java Scrapyard Database Project

This project was developed as a solution to the final exam in the course **PGR112 – Object-Oriented Programming (Spring 2024)**.

## 📄 About

The application reads data from `vehicles.txt` and imports it into a SQL database using **JDBC** and **Maven**. The database schema is defined in `scrapyard.sql`. After the import, the program provides a command-line menu that allows users to run basic queries on the data, such as listing vehicles, filtering by year, and getting a total count.

The project is built with a strong focus on object-oriented principles like **inheritance**, **encapsulation**, and **abstraction**. Exception handling is also implemented to ensure a smooth user experience.

## 💡 Key Concepts

- Object-Oriented Programming (inheritance, abstraction, encapsulation)
- Java file handling (reading structured data)
- JDBC for database access
- SQL data import and queries
- Exception handling
- Modular and clean code

## ⚙️ Technologies Used

- Java 17+
- Maven
- JDBC
- IntelliJ IDEA (recommended)
- MySQL Workbench

## ▶️ How to Run

1. Clone the repository  
   ```bash
   git clone https://github.com/<your-username>/<repo-name>.git
Set up your database using the scrapyard.sql file

Create a db.properties file in the resources folder with your own database credentials:
url=jdbc:mysql://localhost:3306/scrapyard
username=YOUR_USERNAME
password=YOUR_PASSWORD
Run the Main class to launch the application
