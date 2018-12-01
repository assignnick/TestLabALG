package com.company.OldShit;

import java.io.IOException;
import java.util.Scanner;

public class MaximumSum {
    public static void main(String[] args) throws IOException {

        Scanner buffer = new Scanner(System.in);
        int n = buffer.nextInt();

        int c;
        int[][] mas = new int[n][n];
        for (int i = 0; i < n; i++) {
            c = 0;
            for (int j = 0; j < n; j++) {
                c += buffer.nextInt();
                mas[i][j] = c;
            }
        }
        for (int i = 0; i < n; i++) {
            c = 0;
            for (int j = 0; j < n; j++) {
                c += mas[j][i];
                mas[j][i] = c;
            }
        }

        c=-200;
        int otv=c;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                for (int i = 0; i <= x; i++) {
                    for (int j = 0; j <= y; j++) {
                        c = mas[x][y];
                        if (i>0)
                            c -=mas[i-1][y];
                        if (j>0)
                            c -=mas[x][j-1];
                        if (i>0 && j>0)
                            c +=mas[i-1][j-1];
                        if(c>otv) {
                            otv = c;

                        }
                    }
                }
            }
        }


        System.out.println(otv);

    }
}
