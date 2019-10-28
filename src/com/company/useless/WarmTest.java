package com.company.useless;

public class WarmTest {
    public static long measure() {
        long st, en;
        st = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
         int a;
        }
        en = System.nanoTime();
        return en - st;
    }
}