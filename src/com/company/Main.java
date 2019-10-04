package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        bi = new BufferedReader(new InputStreamReader(new FileInputStream("src\\com\\company\\gryadka.txt")));
        String str = bi.readLine();
        StringTokenizer strtk = new StringTokenizer(str, " ");
        int n = (Integer.parseInt(strtk.nextToken()));
        int m = (Integer.parseInt(strtk.nextToken()));
        for (int i = 0; i < m; i++)
            list.add(new ArrayList<>());
        int a;
        for (int i = 0; i < m; i++) {
            str = bi.readLine();
            strtk = new StringTokenizer(str, " ");
            for (int j = 0; j < 3; j++) {
                a = (Integer.parseInt(strtk.nextToken()));
                list.get(i).add(a);
            }
        }
        System.out.println(list.toString());

        Collections.sort(list, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(2).compareTo(o2.get(2));
            }
        });
        System.out.println(list.toString());

        ArrayList<Integer> nes = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
        ArrayList<Integer> t = new ArrayList<>();
        int f = list.get(0).get(2);
        int lastf = 0;
        while (nes.size() < n || list2.size() < n - 1) {
            for (ArrayList<Integer> integers : list) {
                if (f < integers.get(2)) {
                    lastf = f;
                    f = integers.get(2);
                    break;
                }
                if (!nes.contains(integers.get(0)))
                    nes.add(integers.get(0));
                if (!nes.contains(integers.get(1)))
                    nes.add(integers.get(1));
                t = new ArrayList<>();
                t.add(integers.get(0));
                t.add(integers.get(1));
                list2.add(t);
            }
        }

        System.out.println(lastf);
        System.out.println(list2.size());
        for (ArrayList<Integer> integers : list2) {
            System.out.println(integers.get(0) + " " + integers.get(1));
        }
    }
//    private static void dfs(double expect, int s, int start, int pr) {
//        boolean end = true;
//        used[start] = 1;
//        double div = list.get(start).size() - 1;
//        if (start == 0)
//            div++;
//        for (int i = 0; i < list.get(start).size(); ++i) {
//            if (used[start] != 2) {
//                if ((list.get(start).get(i) != pr)) {
//                    dfs(expect / div, s + 1, list.get(start).get(i), start);
//                    end = false;
//                }
//            }
//        }
//        used[start] = 2;
//        if (end) {
//            //System.out.println(s + " s " + (start + 1) + " start+1 " + expect);
//            sum += expect * s;
//        }
//    }
}