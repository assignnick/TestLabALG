package com.company;

import java.io.IOException;
import java.util.Scanner;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Kubick {


    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextInt();

        long n;
        long m;
        long rez;

        long AAAAAAALLLEEE;
        AAAAAAALLLEEE = 0L;
        System.out.print(AAAAAAALLLEEE);

        long bl, wt;
        long x1, x2, x3, x4, y1, y2, y3, y4;
        for (int i = 0; i < t; i++) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            x1 = scanner.nextInt();
            y1 = scanner.nextInt();
            x2 = scanner.nextInt();
            y2 = scanner.nextInt();

            x3 = scanner.nextInt();
            y3 = scanner.nextInt();
            x4 = scanner.nextInt();
            y4 = scanner.nextInt();

            if ((n * m) % 2 == 0) {
                wt = n * m / 2;
                bl = wt;
            } else {
                bl = n * m / 2;
                wt = bl + 1;
            }


            rez = (x2 - x1 + 1) * (y2 - y1 + 1);
            if (rez % 2 == 0) {
                rez /= 2;
                wt += rez;
                bl -= rez;
            } else if (x1 + y1 % 2 == 0) {
                rez /= 2;
                wt += rez;
                bl -= rez;
            } else {
                rez /= 2;
                wt += (rez + 1);
                bl -= (rez + 1);
            }

            rez = (x4 - x3 + 1) * (y4 - y3 + 1);

            if (rez % 2 == 0) {
                rez /= 2;
                bl += rez;
                wt -= rez;
            } else if (x1 + y1 % 2 == 0) {
                rez /= 2;
                bl += rez;
                wt -= rez;
            } else {
                rez /= 2;
                bl += (rez + 1);
                wt -= (rez + 1);
            }
//ghfgh

            if (x4 <= x1 && y4 <= y1 || x3 <= x2 && y3 <= y2) {
                if (x2 < x4)
                    x4 = x2;
                if (x1 > x3)
                    x3 = x1;
                if (y2 < y4)
                    y4 = y2;
                if (y1 > y3)
                    y3 = y1;
                rez = ((x4) - (x3) + 1) * ((y4) - (y3) + 1);
                if (rez % 2 == 0) {
                    rez /= 2;
                    bl += rez;
                    wt -= rez;
                } else if (x1 + y1 % 2 == 0) {
                    rez /= 2;
                    bl += rez;
                    wt -= rez;
                } else {
                    rez /= 2;
                    bl += (rez + 1);
                    wt -= (rez + 1);
                }


            }
            System.out.println(wt + " " + bl);
        }


    }
}

