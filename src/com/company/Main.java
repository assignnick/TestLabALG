package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner buffer = new Scanner(System.in);
        int n = buffer.nextInt();
        int k = buffer.nextInt();
        int temp=n-2;
        int zz=0;
        while (temp>0) {
            zz +=temp;
            temp--;
        }
        System.out.println(Math.pow(k,n)-Math.pow(k,n-1)-k*zz);

    }
}