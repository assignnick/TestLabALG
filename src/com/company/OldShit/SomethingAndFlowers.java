package com.company.OldShit;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class SomethingAndFlowers {
    SomethingAndFlowers() throws Exception {
    Scanner scanner = new Scanner(System.in);
    OutputStream out = new BufferedOutputStream( System.out );
        long c,min,max,minCt,maxCt;
    int n=scanner.nextInt();
        c = scanner.nextInt();
        min=c;max=c;minCt=1;maxCt=1;
        for(int i = 1;i<n;i++) {
            c = scanner.nextInt();
            if(c<min){
                min=c; minCt=1;
            }
            else if(c==min){
                minCt++;
            }
            if(c>max){
                max=c; maxCt=1;
            }
            else if(c==max){
                maxCt++;
            }
        }
        long Ct=maxCt*minCt;
        long minmax=max-min;
        if(minmax==0){Ct=0;
            while (maxCt>0){
                maxCt--;Ct+=maxCt;}}
        out.write((minmax + " " + Ct + "\n").getBytes());
        out.flush();
}}
