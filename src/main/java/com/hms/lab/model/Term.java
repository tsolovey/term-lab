package com.hms.lab.model;

public class Term {
    private long id;
    private String name;
    private int numberOfPatients;

    public Term(long id, String name, int numberOfPatients) {
        this.id = id;
        this.name = name;
        this.numberOfPatients = numberOfPatients;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfPatients() {
        return numberOfPatients;
    }
}
