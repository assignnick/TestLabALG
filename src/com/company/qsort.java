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
        int cen = mas[middle];

        int i = l, j = r;
        int temp;
        while (i <= j) {
            while (mas[i] < cen) {
                i++;
            }
            while (mas[j] > cen) {
                j--;
            }
            if (i <= j) {
                temp = mas[i];
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
