# Clinic System – QAP 4 (Java)

This is a simple Java console application built as part of QAP 4 for the Software Development course (SD13).  
It demonstrates **File Handling**, **Exception Handling**, and **Database Connectivity (PostgreSQL)** using **JDBC**.

## Features

- Add drug details and save to `drugs.txt` file
- Add patient details and save to PostgreSQL database
- Display all patients from the database
- Display all drugs from the text file
- Menu system with user input using Scanner

## Technologies Used

- Java SE
- File I/O (BufferedReader / BufferedWriter)
- JDBC with PostgreSQL
- Exception Handling (try-catch)

## How to Run

1. Make sure PostgreSQL is running and a database named `clinic` exists.
2. Compile the code:

```bash
javac -cp ".:postgresql-42.7.7.jar" *.java
```
