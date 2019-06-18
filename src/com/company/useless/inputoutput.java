package com.company.useless;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class inputoutput {
    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        //   bi = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Users\\assig\\IdeaProjects\\AnotherTestAlgLab\\src\\com\\company\\gryadka.txt")));
        // sc = new Scanner(new FileInputStream("E:\\Users\\assig\\IdeaProjects\\AnotherTestAlgLab\\src\\com\\company\\gryadka2.txt"));
        Map<Long, Long> first = new TreeMap<>();
        Map<Long, Long> last = new TreeMap<>();

        int n = Integer.parseInt(bi.readLine());
        long a = 0, it = 0;
        String str = bi.readLine();
        StringTokenizer strtk = new StringTokenizer(str, " ");
        while (strtk.hasMoreTokens()) {
            a = (Integer.parseInt(strtk.nextToken()));
//            if (!first.containsKey(a)) {
//                first.put(a, it);
//            }
//            last.put(a, it);
            it++;
        }
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

