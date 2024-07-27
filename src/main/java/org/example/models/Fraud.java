package org.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Fraud {

    @Id
    private int fraudid;
    private String fraudtype;
    private String emailid;

    public int getFraudid() {
        return fraudid;
    }

    public void setFraudid(int fraudid) {
        this.fraudid = fraudid;
    }

    public String getFraudtype() {
        return fraudtype;
    }

    public void setFraudtype(String fraudtype) {
        this.fraudtype = fraudtype;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }
}
