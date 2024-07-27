package org.example.models;

public class Comms {

    private int commsId;
    private String email;
    private int customerId;
    private int applicationId;


    public int getCommsId() {
        return commsId;
    }

    public void setCommsId(int commsId) {
        this.commsId = commsId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }
}
