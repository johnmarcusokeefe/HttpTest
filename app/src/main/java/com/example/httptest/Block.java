package com.example.httptest;

public class Block {

    private String id;
    private String date;
    private String job;

    public Block(String id, String date, String job ) {
        this.id=id;
        this.date=date;
        this.job=job;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
