package com.company.sixsevenLabs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TwoTeams {

    private static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    private static ArrayList<Integer> one = new ArrayList<>();
    private static ArrayList<Integer> two = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        //bi = new BufferedReader(new InputStreamReader(new FileInputStream("src\\com\\company\\gryadka.txt")));
        String str = bi.readLine();
        StringTokenizer strtk = new StringTokenizer(str, " ");
        int n = (Integer.parseInt(strtk.nextToken()));
        int a;
        for (int i = 0; i <= n; i++)
            list.add(new ArrayList<>());

        for (int i = 1; i <= n; i++) {
            str = bi.readLine();
            strtk = new StringTokenizer(str, " ");
            a = (Integer.parseInt(strtk.nextToken()));
            do {
                list.get(i).add(a);
                a = (Integer.parseInt(strtk.nextToken()));
            } while (a != 0);
        }
        for (int i = 1; i < list.size(); i++) {
            if (!two.contains(i) && !one.contains(i))
                one.add(i);
            dfs(i);
        }
        System.out.println(one.size());
        for (int i = 0; i < one.size(); i++) {
            System.out.print(one.get(i) + " ");
        }
//        System.out.println(list.toString());
//        System.out.println(one.toString());
//        System.out.println(two.toString());
    }

    private static void dfs(int i) {
        int n;
        for (int j = 0; j < list.get(i).size(); j++) {
            n = list.get(i).get(j);
            if (!two.contains(n) && !one.contains(n))
                if (one.contains(i)) {
                    two.add(n);
                    dfs(n);
                } else if (two.contains(i)) {
                    one.add(n);
                    dfs(n);
                }
        }
    }
}
