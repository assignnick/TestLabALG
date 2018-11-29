package com.company;

public class WarmTest {
    public static long measure() {
        long st, en;
        st = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            ;
        }
        en = System.nanoTime();
        return en - st;
    }
}