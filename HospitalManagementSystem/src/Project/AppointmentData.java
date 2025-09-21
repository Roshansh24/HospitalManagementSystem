package Project;

import java.sql.Date;

public class AppointmentData {
    private int aid, pid, did;
    private Date date;
    private String status;

    public int getAid() {
        return aid;
    }
    public void setAid(int aid) {
        this.aid = aid;
    }
    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }
    public int getDid() {
        return did;
    }
    public void setDid(int did) {
        this.did = did;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
