package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class customHash {
  /*  String str;
    public customHash(String str) {
        this.str=str;
    }*/

    public void hash(String str){
        int[] ppows=new int[10000000];
        ArrayList<x> hhh = new ArrayList<>();
        int n =str.length();
        long[][] h=new long[n][2];
        int p=31;
        //BigInteger hash=new BigInteger("0"),ppow=new BigInteger("1");
        long hash=0;

        ppows[0]=1;
        for (int i=1;i<10000000;++i)
            ppows[i]=ppows[i-1]*p;

        int asd=123;
        // hash+=(str.charAt(i)-'a'+1)*ppow;
        // ppow*=p;


        for (int i=0;i<n;++i) {
            if ((str.charAt(i)-'\n')==0) break;
            hash+=(str.charAt(i) - 'a' + 1) * ppows[i];
            hhh.add(new x(hash,i));
            h[i][0]=hash;
            h[i][1]=i;
        }
        hhh.sort(new meh());

        for (int i=0, group=0; i<n; ++i)
        {
            if (i == 0 || hhh.get(i).getf()!=hhh.get(i-1).getf())
                System.out.println("\nGroup "+ ++group + ":" + ' ' + hhh.get(i).gets());
        }

        //Collections.sort(  hhh, new  meh() );

    }
}