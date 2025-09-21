package Project;



public interface HospitalOperations {
    void addPatient(PatientData p);
    void displayPatients();
    void addDoctor(DoctorData d);
    void displayDoctors();
    void bookAppointment(int pid, int did);
    void displayAppointments();
    void deletePatient(int pid);
    void deleteDoctor(int did);
    void deleteAppointment(int aid);

}
