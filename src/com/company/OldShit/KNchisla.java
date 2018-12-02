package com.company.OldShit;

import java.util.Scanner;

public class KNchisla {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//кол во карт
        int k = scanner.nextInt();//система счисления
        long otv = (k - 1);
        long t = otv * (k - 1);
        long o = (k - 1);
        long temp;
        otv = t + o;
        for (int i = 3; i <= n; i++) {
            temp = otv;
            otv = temp * (k - 1) + (k - 1) * o;
            o = temp;

        }
        System.out.println(otv);
    }
}

