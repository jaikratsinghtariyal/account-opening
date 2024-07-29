package org.example.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FVQ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fvqid;
    private String content;
    private String applicationstatus;
    private int applicationid;

    public int getFvqid() {
        return fvqid;
    }

    public void setFvqid(int fvqid) {
        this.fvqid = fvqid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getApplicationstatus() {
        return applicationstatus;
    }

    public void setApplicationstatus(String applicationstatus) {
        this.applicationstatus = applicationstatus;
    }

    public int getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(int applicationid) {
        this.applicationid = applicationid;
    }
}
