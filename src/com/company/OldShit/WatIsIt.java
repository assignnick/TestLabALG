package com.company.OldShit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class WatIsIt {
    WatIsIt()throws IOException {
    long before = Calculator.mem();
    String str;
    Scanner scanner = new Scanner(System.in);

    InputStreamReader vvod = new InputStreamReader(System.in);
    BufferedReader buffer = new BufferedReader(vvod);
    int n = scanner.nextInt();
    int a, r;

    int[] h = new int[10];
    // while ((str = buffer.readLine()) != null)
        for (int i = 0; i < n; ++i) {
        buffer = new BufferedReader(vvod);
        str = buffer.readLine();
        if (str.isEmpty()) break;
        r = str.length() - 1;
        while (r >= 0) {
            a = 0;
            if (r > 0) {
                h[0] = (str.charAt(r) - 'a' + 1);
                h[1] = (str.charAt(r - 1) - 'a' + 1) * 31 + h[0];
            } else break;
            if (h[1] == 293)
                a = 2;
            else {
                if (r > 1) {
                    h[2] = (str.charAt(r - 2) - 'a' + 1) * 961 + h[1];
                } else break;
                if (h[2] == 14854 || h[2] == 15086)
                    a = 3;
                else {
                    if (r > 3) {
                        h[3] = (str.charAt(r - 3) - 'a' + 1) * 29791 + h[2];
                        h[4] = (str.charAt(r - 4) - 'a' + 1) * 923521 + h[3];
                    } else break;
                    if (h[4] == 15421646 || h[4] == 8744810)
                        a = 5;
                    else {
                        if (r > 4) {
                            h[5] = (str.charAt(r - 5) - 'a' + 1) * 28629151 + h[4];
                        } else break;
                        if (h[5] == 449443073)
                            a = 6;
                        else break;
                    }
                }
            }

            r -= a;
        }

        if (r == -1)
            System.out.println("YES");
        else
            System.out.println("NO");

    }
        buffer.close();


    long after = Calculator.mem();
        System.out.println("Diff " + (after - before));



}
public static class Calculator {
    public static long mem() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
}
