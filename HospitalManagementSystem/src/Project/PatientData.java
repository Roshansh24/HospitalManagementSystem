package Project;

public class PatientData {
    int pid, age;
    String pname, gender, disease, phone;

    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
    	  if(age > 0) {
              this.age = age;
          }
    	  else
    	  {
              throw new IllegalArgumentException("Age must be positive.");
          }
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getDisease() {
        return disease;
    }
    public void setDisease(String disease) {
        this.disease = disease;
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

