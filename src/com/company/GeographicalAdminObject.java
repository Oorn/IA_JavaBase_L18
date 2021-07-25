package com.company;

public interface GeographicalAdminObject {
    String adminObjectString();
    String getName();
    void accept(GeoAdminVisitor v);
}
