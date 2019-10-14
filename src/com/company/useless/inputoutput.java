package com.company.useless;

import java.io.*;
import java.util.*;

public class inputoutput {
    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        //   bi = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Users\\assig\\IdeaProjects\\AnotherTestAlgLab\\src\\com\\company\\gryadka.txt")));
         sc = new Scanner(new FileInputStream("E:\\Users\\assig\\IdeaProjects\\AnotherTestAlgLab\\src\\com\\company\\gryadka2.txt"));
        Map<Long, Long> first = new TreeMap<>();
        Map<Long, Long> last = new TreeMap<>();

      //  int n = Integer.parseInt(bi.readLine());
       // long a = 0, it = 0;
      //  String str = bi.readLine();
      //  StringTokenizer strtk = new StringTokenizer(str, " ");


        FileWriter writer = new FileWriter("E:\\Users\\assig\\IdeaProjects\\AnotherTestAlgLab\\src\\com\\company\\gryadka3.txt", false);
        String text = "1000 15000";
        writer.write(text);
        // запись по символам
        writer.append('\n');
        for(int i=1;i<17;i++)
            for(int j=i+1;j<1001;j++){
               // writer.append(String.valueOf(i)).append(" ").append(String.valueOf(j)).append(" ").append(String.valueOf(new Random().nextInt(1000000)+1));
                writer.append(String.valueOf(i)).append(" ").append(String.valueOf(j)).append(" ").append(String.valueOf(1000000));
                writer.append('\n');
            }



        writer.flush();

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

