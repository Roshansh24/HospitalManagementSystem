package Project;

import java.sql.*;
import java.util.*;

public class HospitalData implements HospitalOperations {
	 Connection con;
     List<PatientData> patientCache = new ArrayList<>();
     List<DoctorData> doctorCache = new ArrayList<>();

    public HospitalData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb", "root", "qwertyuiop");
             System.out.println("Connected Successfully");
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addPatient(PatientData p) {
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO Patient(pname, age, gender, disease, phone) VALUES(?,?,?,?,?)");
            pstmt.setString(1, p.getPname());
            pstmt.setInt(2, p.getAge());
            pstmt.setString(3, p.getGender());
            pstmt.setString(4, p.getDisease());
            pstmt.setString(5, p.getPhone());
            int i = pstmt.executeUpdate();
            if(i > 0) {
                System.out.println(" Patient added successfully.");
                patientCache.add(p); 
            }
        } 
         catch (Exception e) {
            System.out.println(" Error adding patient: " + e.getMessage());
        }
    }

    @Override
    public void displayPatients() {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Patient");
            while(rs.next()) {
                System.out.println(rs.getInt("pid") + " | " +rs.getString("pname") + " | " +
                                   rs.getInt("age") + " | " +rs.getString("gender") + " | " +
                                   rs.getString("disease") + " | " +rs.getString("phone") );
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deletePatient(int pid) {
        try {
            // First delete all appointments for this patient
            PreparedStatement ps1 = con.prepareStatement("DELETE FROM appointment WHERE pid=?");
            ps1.setInt(1, pid);
            ps1.executeUpdate();

            // Now delete patient
            PreparedStatement ps2 = con.prepareStatement("DELETE FROM patient WHERE pid=?");
            ps2.setInt(1, pid);
            int rows = ps2.executeUpdate();

            if (rows > 0) {
                System.out.println(" Patient deleted successfully");
            }
            else 
            {
                System.out.println(" Patient not found");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void addDoctor(DoctorData d) {
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO Doctor(dname, specialization, phone) VALUES(?,?,?)");
            pstmt.setString(1, d.getDname());
            pstmt.setString(2, d.getSpecialization());
            pstmt.setString(3, d.getPhone());
            int i = pstmt.executeUpdate();
            if(i > 0) {
                System.out.println(" Doctor added successfully.");
                doctorCache.add(d);
            }
        }  
        catch (Exception e) {
            System.out.println(" Error adding doctor: " + e.getMessage());
        }
    }

    @Override
    public void displayDoctors() {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Doctor");
            while(rs.next()) {
                System.out.println(rs.getInt("did") + " | " + rs.getString("dname") + " | " +
                    rs.getString("specialization") + " | " +  rs.getString("phone") );
            }
        }   catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteDoctor(int did) {
        try {
            // First delete appointments for this doctor
            PreparedStatement ps1 = con.prepareStatement("DELETE FROM appointment WHERE did=?");
            ps1.setInt(1, did);
            ps1.executeUpdate();

            // Now delete doctor
            PreparedStatement ps2 = con.prepareStatement("DELETE FROM doctor WHERE did=?");
            ps2.setInt(1, did);
            int rows = ps2.executeUpdate();

            if (rows > 0) {
                System.out.println("Doctor deleted successfully");
            } else {
                System.out.println(" Doctor not found");
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    
    @Override
    public void bookAppointment(int pid, int did) {
        try {
            con.setAutoCommit(false); // Transaction start

            PreparedStatement pstmt = con.prepareStatement("INSERT INTO Appointment(pid, did, date, status) VALUES(?,?,CURDATE(),?)");
            pstmt.setInt(1, pid);
            pstmt.setInt(2, did);
            pstmt.setString(3, "Scheduled");

            int i = pstmt.executeUpdate();
            if(i > 0) {
                con.commit();  // commit transaction if successful
                System.out.println(" Appointment booked successfully.");
            } 
            else { 
            	// rollback if insertion fails
                con.rollback();   
                System.out.println(" Failed to book appointment.");
            }
        } catch (Exception e) {
            try {
            	con.rollback();
            	}
            catch (SQLException ex) { 
            		ex.printStackTrace(); 
            	}
            System.out.println(" Error booking appointment: " + e.getMessage());
        } 
        finally {
            try { //to reset the connection
            	con.setAutoCommit(true);
            	}
            catch (SQLException e) {
            	e.printStackTrace();
            	}
        }
    }

    @Override
    public void displayAppointments() {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT a.aid, p.pname, d.dname, a.date, a.status " +"FROM Appointment a " +
                "JOIN Patient p ON a.pid=p.pid " +"JOIN Doctor d ON a.did=d.did");
            while(rs.next()) {
                System.out.println("Appt ID: " + rs.getInt("aid") +" | Patient: " + rs.getString("pname") +
                    " | Doctor: " + rs.getString("dname") + " | Date: " + rs.getDate("date") +
                    " | Status: " + rs.getString("status"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteAppointment(int aid) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM appointment WHERE aid=?");
            ps.setInt(1, aid);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println(" Appointment deleted successfully");
            } else {
                System.out.println(" Appointment not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
