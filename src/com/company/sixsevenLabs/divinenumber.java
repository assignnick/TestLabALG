package com.company.sixsevenLabs;

import java.math.BigInteger;
import java.util.Scanner;

public class divinenumber {
    public static void main(String[] args) {
        //BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        String str = sc.next();
        int a = Integer.parseInt(String.valueOf(str.charAt(0)));
        int b = -1;
        BigInteger one;
        BigInteger two;
        BigInteger t1, t2;
        int bl = 0, br = 0;
        int sz = l / 2;
        int p = 0;

        b = Integer.parseInt(String.valueOf(str.charAt(sz)));
        if (l % 2 == 1) {
            if (b != 0 && b < a) {
                print(str, sz);
            } else if (b != 0) {
                print(str, sz + 1);
            } else if (Integer.parseInt(String.valueOf(str.charAt(sz + 1))) != 0) {
                print(str, sz + 1);
            } else {
                while (bl == 0 && br == 0) {
                    p++;
                    br = Integer.parseInt(String.valueOf(str.charAt(sz + p + 1)));
                    bl = Integer.parseInt(String.valueOf(str.charAt(sz - p)));
                }
                if (bl == 0) {
                    print(str, sz + p + 1);
                }
                if (br == 0) {
                    print(str, sz - p);
                }
                if (br != 0 && bl != 0) {
                    one = new BigInteger(str.substring(0, sz - p));
                    two = new BigInteger(str.substring(sz - p));
                    t1 = one.add(two);
                    one = new BigInteger(str.substring(0, sz + p + 1));
                    two = new BigInteger(str.substring(sz + p + 1));
                    t2 = one.add(two);
                    System.out.println(t1.min(t2));
                }
            }
        } else {
            if (b != 0) {
                print(str, sz);
            } else {
                while (bl == 0 && br == 0) {
                    p++;
                    br = Integer.parseInt(String.valueOf(str.charAt(sz + p)));
                    bl = Integer.parseInt(String.valueOf(str.charAt(sz - p)));
                }
                if (bl == 0) {
                    print(str, sz + p);
                }
                if (br == 0) {
                    print(str, sz - p);
                }
                if (br != 0 && bl != 0) {
                    one = new BigInteger(str.substring(0, sz - p));
                    two = new BigInteger(str.substring(sz - p));
                    t1 = one.add(two);
                    one = new BigInteger(str.substring(0, sz + p));
                    two = new BigInteger(str.substring(sz + p));
                    t2 = one.add(two);
                    System.out.println(t1.min(t2));
                }
            }
        }
    }

    private static void print(String str, int sz) {
        BigInteger one;
        BigInteger two;
        one = new BigInteger(str.substring(0, sz));
        two = new BigInteger(str.substring(sz));
        System.out.println(one.add(two));
    }
}