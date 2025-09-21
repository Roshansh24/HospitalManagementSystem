# HospitalManagementSystem

A Hospital Management System built using Core Java (JDBC) and MySQL.
This project demonstrates CRUD operations, SQL joins, transactions (commit/rollback), and exception handling in a real-world scenario.

Tech Stack
-Java (Core Java, JDBC)
-MySQL Database
-SQL (CRUD, Joins, Transactions)

Features:
- Manage Patients – Add, view, and delete patient records

- Manage Doctors – Add, view, and delete doctors

- Appointments – Book, view, and cancel appointments

- Transaction Handling – Commit and rollback for appointment booking

- Database Integration – MySQL with JDBC and PreparedStatements

- SQL Joins & Reports – View appointments with patient & doctor details

Project Structure:
-HospitalManagementSystem/
    └── src/Project/
        ├── PatientData.java
        ├── DoctorData.java
        ├── AppointmentData.java
        ├── HospitalOperations.java
        ├── HospitalData.java
        └── MainApp.java
    └──hospitaldb.sql
-README.md
- LICENSE


Setup Instructions :

1.Clone the repository:

git clone https://github.com/your-username/HospitalManagementSystem.git

2.Import into Eclipse/IntelliJ as a Java project.

3.Create the MySQL database by using the commands in HospitalManagementSystem/hospitaldb.sql

4.Update DB credentials in HospitalData.java,i.e enter your mySQL password in the following line:

con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb", "root", "yourpassword");

5.Run Main.java.

Sample Test Cases :

 Add a patient → commit to DB

 Add a doctor → commit to DB

 Book appointment → success → COMMIT

 Book appointment with invalid pid or did → rollback

 
