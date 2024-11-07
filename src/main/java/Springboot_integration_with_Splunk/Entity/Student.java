package Springboot_integration_with_Splunk.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="studentinfo")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int sid;
    String sname;
    String scity;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getScity() {
        return scity;
    }

    public void setScity(String scity) {
        this.scity = scity;
    }
}
