package org.example.models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appid;

    private String customername;
    private String dob;
    private String mobilenumber;
    private String emailid;
    private String postcode;
    private String applicationstatus;
    private String fraudresult;
    private String idnvresult;
    private String creditdecisionresult;

    @Override
    public String toString() {
        return "{" +
                " customername='" + customername + '\'' +
                ", dob='" + dob + '\'' +
                ", mobilenumber='" + mobilenumber + '\'' +
                ", emailid='" + emailid + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }

    public String getFraudresult() {
        return fraudresult;
    }

    public void setFraudresult(String fraudresult) {
        this.fraudresult = fraudresult;
    }

    public String getIdnvresult() {
        return idnvresult;
    }

    public void setIdnvresult(String idnvresult) {
        this.idnvresult = idnvresult;
    }

    public String getCreditdecisionresult() {
        return creditdecisionresult;
    }

    public void setCreditdecisionresult(String creditdecisionresult) {
        this.creditdecisionresult = creditdecisionresult;
    }

    public String getApplicationstatus() {
        return applicationstatus;
    }

    public void setApplicationstatus(String applicationstatus) {
        this.applicationstatus = applicationstatus;
    }

    public Long getAppid() {
        return appid;
    }

    public void setAppid(Long appid) {
        this.appid = appid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
