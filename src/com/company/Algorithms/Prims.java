package com.company.Algorithms;

import java.util.ArrayList;

public class Prims {


    public static void main(String[] args) {
        int n=1; //вершины
        ArrayList<ArrayList<Integer>> g= new ArrayList<>();
        int INF = 1000000000; // значение "бесконечность"
        // алгоритм
        //ArrayList<Boolean> used = new ArrayList<>(n);
        boolean[] used = new boolean[n];
        //ArrayList<Integer> min_e = new ArrayList<>(n);
        int[] min_e = new int[n];
        for (int i = 0; i < min_e.length; i++)
            min_e[i] = INF;
        // vector<int> min_e (n, INF);
        // sel_e(n, -1);
        int[] sel_e = new int[n];
        for (int i = 0; i < sel_e.length; i++)
            sel_e[i] = INF;
        min_e[0] = 0;
        for (int i = 0; i < n; ++i) {
            int v = -1;
            for (int j = 0; j < n; ++j)
                if (!used[j] && (v == -1 || min_e[j] < min_e[v]))
                    v = j;
            if (min_e[v] == INF) {
                System.out.println("No MST!");
                break;
            }

            used[v] = true;
            if (sel_e[v] != -1)
                System.out.println(v + " " + sel_e[v]);

            for (int to = 0; to < n; ++to)
                if (g.get(v).get(to) < min_e[to]) {
                    min_e[to] = g.get(v).get(to);
                    sel_e[to] = v;
                }
        }
    }
}
