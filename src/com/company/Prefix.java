package com.company;

import java.util.ArrayList;

public  class Prefix {
    public static ArrayList getPrefix(String str){
        int n = str.length();
        ArrayList<Integer> pi = new ArrayList<Integer>(n);
            pi.add(0,0);
            Integer j;
            for (int i = 1; i < n; ++i) {
                j = pi.get(i - 1);
                while (j > 0 && (str.charAt(i) != (str.charAt(j))))
                    j = pi.get(j - 1);
                if (str.charAt(i) == (str.charAt(j))) ++j;
                    pi.add(i, j);
            }
            return pi;
    }

}

