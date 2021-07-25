package com.company;

public class Subscriber {
    String name;

    public Subscriber(String name) {
        this.name = name;
    }
    public void receive (Publishable pub) {
        System.out.println(name + " has received " + pub);
    }
}
