package com.company;

import java.util.Comparator;

public class meh implements Comparator<x> {
    public int compare(x o1, x o2)
    {
        return -Double.compare(o1.getf(),o2.getf());
    }
}


