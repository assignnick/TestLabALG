package com.company;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

public class WarmTest {
    public static long measure() {
        long start,finish,time;
        start = System.nanoTime();
        OutputStream out = new BufferedOutputStream( System.out );

        {}

        //TimeUnit.SECONDS.sleep(2);
        finish = System.nanoTime();
        time=finish-start;
        System.out.println("cold start " + String.format("%,12d",time/1000000) + " ms");
        System.out.println("warmed jre time " + String.format("%,12d", time/1000000) + " ms");
        return time;
    }
}

//        long start,finish,time;
//        start = System.nanoTime();
//        OutputStream out = new BufferedOutputStream( System.out );
//        Reader inputStreamReader = new InputStreamReader(System.in);
//        BufferedReader reader = new BufferedReader(inputStreamReader);
//        int[] mas=new int[10];
//        String str;
//
//        for(int i=0;i<10;++i){
//            str=reader.readLine();
//            mas[i]=Integer.parseInt(str);
//        }
//
//        for (int ma : mas) out.write((String.format("%2d", (ma)) + " ").getBytes());
//        out.write(("\n").getBytes());
//        out.flush();
//
//        int l=0,p=mas.length-1,n;
//        com.company.qsort.qsort(mas,l,p);
//
//
//        for (int ma : mas) out.write((String.format("%2d", (ma)) + " ").getBytes());
//        out.write((" sorrrtr "+"\n").getBytes());
//        out.flush();
//
//        //TimeUnit.SECONDS.sleep(2);
//        finish = System.nanoTime();
//        time=finish-start;
//        System.out.println("cold start " + String.format("%,12d",time/1000000) + " ms");
//        //System.out.println("warmed jre time " + String.format("%,12d", time/1000000) + " ms");
//    }
//}
