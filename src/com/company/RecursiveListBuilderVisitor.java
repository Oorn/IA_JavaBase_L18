package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursiveListBuilderVisitor implements GeoAdminVisitor{
    List<String> IGNORE_LIST = Arrays.asList("$global map");

    ArrayList<GeographicalAdminObject> res = new ArrayList<>();
    ArrayList<GeographicalAdminObject> getResult() {
        return res;
    }
    @Override
    public void visit(Town obj) {
        if (!IGNORE_LIST.contains(obj.name))
            res.add(obj);
    }

    @Override
    public void visit(Region obj) {
        if (!IGNORE_LIST.contains(obj.name))
            res.add(obj);
        obj.elements.values().forEach((o) -> o.accept(this));
    }
    public void reset() {
        res = new ArrayList<>();
    }
}
