package com.company;

public class Publishable {
    String publishName, issueName;

    public Publishable(String publishName, String issueName) {
        this.publishName = publishName;
        this.issueName = issueName;
    }
    public String toString() {
        return publishName + " " + issueName;
    }
}
