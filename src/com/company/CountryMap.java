package com.company;

import java.util.ArrayList;

public class CountryMap {
    Region globalMap;
    CountryMap() {
        globalMap = new Region("$global map", null);
    }
    void addCountry(String countryName) {
        globalMap.add(new Region(countryName, globalMap));
    }
    void removeCountry(String countryName) {
        globalMap.remove(countryName);
    }
    GeographicalAdminObject getCountry(String countryName) {
        return globalMap.getChild(countryName);
    }
    void addRegionToCountry(String regionName, String countryName) {
        Region r = globalMap.getChildTree(countryName);
        r.add(new Region(regionName, r));
    }
    void removeGeoObjFromCountry(String geoObjName, String countryName) {
        globalMap.getChildTree(countryName).remove(geoObjName);
    }
    void addTownToCountry(String regionName, String countryName) {
        Region r = globalMap.getChildTree(countryName);
        r.add(new Town(regionName, r));
    }
    GeographicalAdminObject getGeoObjFromCountry(String geoObjName, String countryName) {
        return globalMap.getChildTree(countryName).getChild(geoObjName);
    }
    void addTownToRegionCountry(String townName, String countryName,String regionName) {
        Region r = globalMap.getChildTree(countryName).getChildTree(regionName);
        r.add(new Town(townName, r));
    }
    GeographicalAdminObject getGeoObjFromCountryRegion(String townName, String geoObjName, String countryName) {
        return  globalMap.getChildTree(countryName).getChildTree(geoObjName).getChild(townName);
    }
    void removeTownFromRegionCountry(String townName, String countryName,String regionName) {
        globalMap.getChildTree(countryName).getChildTree(regionName).remove(townName);
    }
    public String toString() {
        return globalMap.toString();
    }
    public ArrayList<GeographicalAdminObject> toList() {
        RecursiveListBuilderVisitor v = new RecursiveListBuilderVisitor();
        globalMap.accept(v);
        return v.getResult();
    }

}
