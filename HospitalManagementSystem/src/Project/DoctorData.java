package Project;


public class DoctorData {
    private int did;
    private String dname, specialization, phone;

    public int getDid() {
        return did;
    }
    public void setDid(int did) {
        this.did = did;
    }
    public String getDname() {
        return dname;
    }
    public void setDname(String dname) {
        this.dname = dname;
    }
    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        if(phone.matches("\\d{10}")) {
            this.phone = phone;
        } 
        else
        {
        	 System.out.println("Phone must be 10 digits.");
        }
    }
}
