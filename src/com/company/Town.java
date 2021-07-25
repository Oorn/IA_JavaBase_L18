package com.company;

public class Town implements GeographicalAdminObject{

    String name;
    Region parent;
    Town(String name, Region parent) {
        this.name = name;
        this.parent = parent;
    }
    public Region getParent() {
        return parent;
    }
    @Override
    public String adminObjectString() {
        return "town " + name;
    }
    public String toString () {
        return adminObjectString();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void accept(GeoAdminVisitor v) {
        v.visit(this);
    }
}
