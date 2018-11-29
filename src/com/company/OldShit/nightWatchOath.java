package com.company.OldShit;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.util.Random;
import java.util.Scanner;

public class nightWatchOath {
    nightWatchOath() throws Exception {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        OutputStream out = new BufferedOutputStream( System.out );
        long c,min,max,minCt,maxCt;
        int n=30;
        c = random.nextInt(2);
        out.write((c + "\n").getBytes());
        out.flush();
        min=c;max=c;minCt=1;maxCt=1;
        for(int i = 1;i<n;i++) {
            c = random.nextInt(2);
            out.write((c + "\n").getBytes());
            out.flush();
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
        long Ct=n-maxCt-minCt;
        long minmax=max-min;
        if(minmax==0)Ct=0;

        out.write(("\n"+Ct + "\n").getBytes());
        out.flush();
}}
