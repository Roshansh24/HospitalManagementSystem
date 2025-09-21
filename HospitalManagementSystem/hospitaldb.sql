-- Create Database
CREATE DATABASE IF NOT EXISTS hospitaldb;
USE hospitaldb;

-- Drop tables if they already exist 
DROP TABLE IF EXISTS appointment;
DROP TABLE IF EXISTS patient;
DROP TABLE IF EXISTS doctor;

-- Create Patient Table
CREATE TABLE patient (
    pid INT AUTO_INCREMENT PRIMARY KEY,
    pname VARCHAR(100) NOT NULL,
    age INT CHECK(age > 0),
    gender VARCHAR(10),
    disease VARCHAR(100),
    phone VARCHAR(10) UNIQUE
);

-- Create Doctor Table
CREATE TABLE doctor (
    did INT AUTO_INCREMENT PRIMARY KEY,
    dname VARCHAR(100) NOT NULL,
    specialization VARCHAR(100),
    phone VARCHAR(10) UNIQUE
);

-- Create Appointment Table
CREATE TABLE appointment (
    aid INT AUTO_INCREMENT PRIMARY KEY,
    pid INT,
    did INT,
    date DATE,
    status VARCHAR(50),
    FOREIGN KEY (pid) REFERENCES patient(pid) ON DELETE CASCADE,
    FOREIGN KEY (did) REFERENCES doctor(did) ON DELETE CASCADE
);

-- Insert Sample Patients
INSERT INTO patient (pname, age, gender, disease, phone) VALUES
('Ravi Kumar', 30, 'Male', 'Fever', '9876543210'),
('Anita Sharma', 25, 'Female', 'Cold', '9123456789'),
('Suresh Mehta', 40, 'Male', 'Diabetes', '9988776655');

-- Insert Sample Doctors
INSERT INTO doctor (dname, specialization, phone) VALUES
('Dr. Arjun Singh', 'Cardiology', '9998887776'),
('Dr. Neha Kapoor', 'Dermatology', '8887776665'),
('Dr. Manish Rao', 'Orthopedics', '7776665554');

-- Insert Sample Appointments
INSERT INTO appointment (pid, did, date, status) VALUES
(1, 1, CURDATE(), 'Scheduled'),
(2, 2, CURDATE(), 'Completed'),
(3, 3, CURDATE(), 'Scheduled');
