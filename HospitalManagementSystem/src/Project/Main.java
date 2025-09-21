package Project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HospitalOperations dao = new HospitalData();

        while (true) {
            System.out.println("\n===== Hospital Management System =====");
            System.out.println("[1] Add Patient");
            System.out.println("[2] Display Patients");
            System.out.println("[3] Add Doctor");
            System.out.println("[4] Display Doctors");
            System.out.println("[5] Book Appointment");
            System.out.println("[6] Display Appointments");
            System.out.println("[7] Delete Patient");
            System.out.println("[8] Delete Doctor");
            System.out.println("[9] Delete Appointment");
            System.out.println("[0] Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    try {
                        PatientData p = new PatientData();
                        System.out.print("Enter patient name: ");
                        p.setPname(sc.nextLine());
                        System.out.print("Enter age: ");
                        p.setAge(sc.nextInt());
                        sc.nextLine(); // consume newline
                        System.out.print("Enter gender: ");
                        p.setGender(sc.nextLine());
                        System.out.print("Enter disease: ");
                        p.setDisease(sc.nextLine());
                        System.out.print("Enter phone (10 digits): ");
                        p.setPhone(sc.nextLine());

                        dao.addPatient(p);
                    } 
                    catch (Exception e) {
                        System.out.println("❌ Invalid input: " + e.getMessage());
                    }
                    break;

                case 2:
                    dao.displayPatients();
                    break;

                case 3:
                    try {
                        DoctorData d = new DoctorData();
                        System.out.print("Enter doctor name: ");
                        d.setDname(sc.nextLine());
                        System.out.print("Enter specialization: ");
                        d.setSpecialization(sc.nextLine());
                        System.out.print("Enter phone (10 digits): ");
                        d.setPhone(sc.nextLine());

                        dao.addDoctor(d);
                    }
                    catch (Exception e) {
                        System.out.println("❌ Invalid input: " + e.getMessage());
                    }
                    break;

                case 4:
                    dao.displayDoctors();
                    break;

                case 5:
                    try {
                        System.out.print("Enter patient ID: ");
                        int pid = sc.nextInt();
                        System.out.print("Enter doctor ID: ");
                        int did = sc.nextInt();
                        dao.bookAppointment(pid, did);
                    } catch (Exception e) {
                        System.out.println("❌ Error booking appointment: " + e.getMessage());
                    }
                    break;

                case 6:
                    dao.displayAppointments();
                    break;

                case 7:
                    System.out.print("Enter patient ID to delete: ");
                    int delPid = sc.nextInt();
                    dao.deletePatient(delPid);
                    break;

                case 8:
                    System.out.print("Enter doctor ID to delete: ");
                    int delDid = sc.nextInt();
                    dao.deleteDoctor(delDid);
                    break;

                case 9:
                    System.out.print("Enter appointment ID to delete: ");
                    int delAid = sc.nextInt();
                    dao.deleteAppointment(delAid);
                    break;

                case 0:
                    System.out.println("... Exiting ... ");
                    sc.close();
                    System.out.println("Exited");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
