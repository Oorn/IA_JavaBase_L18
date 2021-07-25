package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetTopRegionVisitor implements GeoAdminVisitor{
    String res = null;
    List<String> IGNORE_LIST = Arrays.asList("$global map");
    @Override
    public void visit(Town obj) {
        for (Region cur = obj.getParent(); cur != null; cur = cur.getParent())
            if (!IGNORE_LIST.contains(cur.name))
                res = cur.name;

    }

    @Override
    public void visit(Region obj) {
        res = obj.name;
        for (Region cur = obj.getParent(); cur != null; cur = cur.getParent())
            if (!IGNORE_LIST.contains(cur.name))
                res = cur.name;
    }
    public String getResult() {
        return res;
    }
    public void reset() {
        res = null;
    }
}
