package com.company.eightlab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Network {
    public static void main(String[] args) throws IOException {
//          long st, en;
//          st = System.nanoTime();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
       // bi = new BufferedReader(new InputStreamReader(new FileInputStream("src\\com\\company\\gryadka2.txt")));
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

        Collections.sort(list, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(2).compareTo(o2.get(2));
            }
        });

        TreeSet<Integer> used = new TreeSet<>();

        int lastf = 0;
        used.add(1);
        int it = -1;
        int f = 0;
        ArrayList<Integer> edge;
        while (used.size() < n) {
            for (int i = 0; i < list.size(); i++) {
                edge = list.get(i);
                if ((used.contains(edge.get(0)) && !used.contains(edge.get(1))) || (used.contains(edge.get(1)) && !used.contains(edge.get(0)))) {
                    it = i;
                    break;
                }
            }
            edge = list.get(it);
            if (!used.contains(edge.get(0)))
                used.add(edge.get(0));
            else
                used.add(edge.get(1));
            if (f <= edge.get(2))
                f = edge.get(2);
            if (lastf <= it + 1)
                lastf = it + 1;

        }
        System.out.println(f);
        System.out.println(lastf);
        for (int i = 0; i < lastf; i++) {
            ArrayList<Integer> integers = list.get(i);
            System.out.println(integers.get(0) + " " + integers.get(1));
        }
//          en = System.nanoTime();
//        System.out.println(en - st);
//         System.out.println((en - st)/1000000000.+" sec");
    }
}