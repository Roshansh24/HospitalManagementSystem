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
-HospitalManagementSystem/src/Project/ PatientData.java,DoctorData.java,AppointmentData.java,
                                      HospitalOperations.java,HospitalData.java,MainApp.java
-HospitalManagementSystem/hospitaldb.sql
-README.md
-LICENSE


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

Screenshots :

 
<img width="1366" height="745" alt="MySQL Workbench 9_21_25 4_28_24 PM" src="https://github.com/user-attachments/assets/8534d55e-3af9-4f1e-878c-bf0526463848" />

<img width="1366" height="725" alt="Advanced java - AdvancedJava_src_Project_HospitalData java - Eclipse IDE 9_21_25 4_29_35 PM" src="https://github.com/user-attachments/assets/dcd07e18-3f51-419b-b865-ca84c80ebf96" />

<img width="1366" height="725" alt="Advanced java - AdvancedJava_src_Project_Main java - Eclipse IDE 9_21_25 4_31_06 PM" src="https://github.com/user-attachments/assets/072b7960-5330-48ba-877f-64b8552dc24d" />
<img width="1366" height="725" alt="Advanced java - AdvancedJava_src_Project_Main java - Eclipse IDE 9_21_25 4_32_16 PM" src="https://github.com/user-attachments/assets/133704c1-c97f-429b-b23e-f8af7ce7f3aa" />

<img width="1366" height="725" alt="Advanced java - AdvancedJava_src_Project_Main java - Eclipse IDE 9_21_25 4_33_53 PM" src="https://github.com/user-attachments/assets/d9435aed-2151-4f3f-8a38-8ae6179a8086" />

<img width="1366" height="725" alt="Advanced java - AdvancedJava_src_Project_Main java - Eclipse IDE 9_21_25 4_35_06 PM" src="https://github.com/user-attachments/assets/69614bf4-96b3-459b-a2c4-22bca6209180" />
