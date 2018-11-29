package com.company.OldShit;

import java.util.Scanner;
import java.io.BufferedOutputStream;
import java.io.OutputStream;

public class TableOfResults  {
    TableOfResults() throws Exception{
        Scanner scanner = new Scanner(System.in);
        OutputStream out = new BufferedOutputStream( System.out );
        int n=scanner.nextInt();
        int[][] puish = new int[n][2];
        for(int i = 0;i<n;i++) {
            puish[i][0]=scanner.nextInt();
            puish[i][1]=scanner.nextInt();
        }
        int Max=-1,indexMax=-1;
        for(int i = 0;i<n;i++)
        {
            if (puish[i][1]>Max)
            {
                Max=puish[i][1];
                indexMax=i;
            }
        }
        out.write((puish[indexMax][0]+" "+puish[indexMax][1]+ "\n").getBytes());
        //  System.out.println(puish[indexMax][0]+" "+puish[indexMax][1]);
        int size=n-1, curMax=0, index=0, chislo;
        boolean check=false;
        while (size>0)
        {
            for(int i = 0;i<n;i++)
            {
                chislo=puish[i][1];
                if (chislo>curMax && chislo<Max)
                {
                    curMax=chislo;
                    index=i;check=true;
                }
                if (chislo==Max && i>indexMax)
                {
                    curMax=chislo;
                    index=i;
                    out.write((puish[index][0]+" "+puish[index][1] + "\n").getBytes());
                    //System.out.println(puish[index][0]+" "+puish[index][1]);
                    indexMax=index; size--;check=false;
                }
            }
            if (check){
                out.write((puish[index][0]+" "+puish[index][1] + "\n").getBytes());
                // System.out.println(puish[index][0]+" "+puish[index][1]);
                size--; check=true;}
            Max=curMax; indexMax=index;
            curMax=-1;index=0;
        }
        out.flush();
}
}
