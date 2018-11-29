package com.company;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

public  class qsort {
    public  static void qsort(int[] mas,int l,int r) {
        if (mas.length == 0)
            return;
        if (l >= r)
            return;
        int middle = l + (r - l) / 2;
        int opora = mas[middle];

        int i = l, j = r;
        while (i <= j) {
            while (mas[i] < opora) {
                i++;
            }
            while (mas[j] > opora) {
                j--;
            }
            if (i <= j) {
                int temp = mas[i];
                mas[i] = mas[j];
                mas[j] = temp;
                i++;
                j--;
            }
        }
        if (l < j)
            qsort(mas, l, j);

        if (r > i)
            qsort(mas, i, r);
    }
    }
/*
OutputStream out = new BufferedOutputStream( System.out );
        int[] mas={50, 24, 48, 33, 20, 10, 75, 4, 70, 89, 83, 26, 47, 81, 60, 91, 17, 30, 9, 71, 57, 54, 55, 15, 92, 18, 97, 50, 85, 31};
        int l=0,p=mas.length-1;
        qsort.qsort(mas,l,p);
        for(int s=0; s<mas.length;s++)
            out.write(((mas[s])+" ").getBytes());
        out.write(("\n").getBytes());
            out.flush();
*/