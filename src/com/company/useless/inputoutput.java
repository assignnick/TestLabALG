package com.company.useless;

import java.io.*;
import java.util.*;

public class inputoutput {
    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        //   bi = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Users\\assig\\IdeaProjects\\AnotherTestAlgLab\\src\\com\\company\\gryadka.txt")));
       //  sc = new Scanner(new FileInputStream("E:\\Users\\assig\\IdeaProjects\\AnotherTestAlgLab\\src\\com\\company\\gryadka2.txt"));
        Map<Long, Long> first = new TreeMap<>();
        Map<Long, Long> last = new TreeMap<>();

      //  int n = Integer.parseInt(bi.readLine());
       // long a = 0, it = 0;
      //  String str = bi.readLine();
      //  StringTokenizer strtk = new StringTokenizer(str, " ");


        FileWriter writer = new FileWriter("E:\\Users\\assig\\IdeaProjects\\AnotherTestAlgLab\\src\\com\\company\\gryadka2.txt", false);
        String text = "50000 50000";
        writer.write(text);
        // запись по символам
        writer.append('\n');
        for(int i=0;i<50000;i++) {
            System.out.println(i);
            int a =0,b=0;
            b=new Random().nextInt(50000)+1;
            writer.append(String.valueOf(b));
            writer.append(" ");
            for (int j=0;j<b;j++){
                a=new Random().nextInt(50000-a-b+j)+a+1;
                writer.append(String.valueOf(a));
                writer.append(" ");
            }
                writer.append('\n');
                writer.flush();
        }




/*        while (strtk.hasMoreTokens()) {
            a = (Integer.parseInt(strtk.nextToken()));
//            if (!first.containsKey(a)) {
//                first.put(a, it);
//            }
//            last.put(a, it);
            it++;
        }*/
//        long n = sc.nextLong();
//        long a = 0;
//        for (long i = 0; i < n; i++) {
//            a = sc.nextLong();
//            if (!first.containsKey(a)) {
//                first.put(a, i);
//            }
//            last.put(a, i);
        }
    }

