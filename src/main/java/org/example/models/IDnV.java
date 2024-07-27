package org.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class IDnV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idnvid;
    private String postcode;
    private String result;

    public String getIdnvid() {
        return idnvid;
    }

    public void setIdnvid(String idnvid) {
        this.idnvid = idnvid;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
