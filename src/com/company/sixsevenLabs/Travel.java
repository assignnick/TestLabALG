package com.company.sixsevenLabs;

import java.io.*;
import java.util.*;

public class Travel {
    private static int[] used;
    private static double sum = 0;
    private static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        //bi = new BufferedReader(new InputStreamReader(new FileInputStream("src\\com\\company\\gryadka.txt")));
        String str = bi.readLine();
        StringTokenizer strtk = new StringTokenizer(str, " ");
        int n = (Integer.parseInt(strtk.nextToken()));
        int a, b;
        used = new int[n];
        for (int i = 0; i < n; i++)
            list.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            str = bi.readLine();
            strtk = new StringTokenizer(str, " ");
            a = (Integer.parseInt(strtk.nextToken()));
            b = (Integer.parseInt(strtk.nextToken()));
            list.get(a - 1).add(b - 1);
            list.get(b - 1).add(a - 1);
        }
        dfs(1, 0, 0, -1);
        System.out.println(sum);
    }

    private static void dfs(double expect, int s, int start, int pr) {
        boolean end = true;
        used[start] = 1;
        double div = list.get(start).size() - 1;
        if (start == 0)
            div++;
        for (int i = 0; i < list.get(start).size(); ++i) {
            if (used[start] != 2) {
                if ((list.get(start).get(i) != pr)) {
                    dfs(expect / div, s + 1, list.get(start).get(i), start);
                    end = false;
                }
            }
        }
        used[start] = 2;
        if (end) {
            //System.out.println(s + " s " + (start + 1) + " start+1 " + expect);
            sum += expect * s;
        }
    }
}
