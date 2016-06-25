package com.hms.lab.model;

public class ExternalReference {
    private String name;
    private String url;

    public ExternalReference() {
    }

    public ExternalReference(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
