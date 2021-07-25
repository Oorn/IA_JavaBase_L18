package com.company;

import java.util.TreeMap;


public class Region implements GeographicalAdminObject{
    TreeMap<String, GeographicalAdminObject> elements;
    String name;
    Region parent;
    Region(String name, Region parent) {
        this.name = name;
        elements = new TreeMap<>();
        this.parent = parent;
    }

    public Region getParent() {
        return parent;
    }
    void add (GeographicalAdminObject elem) {
        elements.put(elem.getName(), elem);
    }
    void remove (String elemName) {
        elements.remove(elemName);
    }
    GeographicalAdminObject getChild (String elemName) {
        return elements.get(elemName);
    }
    Region getChildTree (String elemName) {
        GeographicalAdminObject res = elements.get(elemName);
        if (!(res instanceof Region))
            return null;
        return (Region) res;
    }


    @Override
    public String adminObjectString() {
        return "region " + name;
    }
    public String toString () {
        return adminObjectString() + " " + elements.values();
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
