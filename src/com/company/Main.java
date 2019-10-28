package com.company;

import java.io.*;
import java.util.*;

public class Main {
    private static int[] way;
    private static int[] groups;

    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
       // bi = new BufferedReader(new InputStreamReader(new FileInputStream("src\\com\\company\\gryadka.txt")));
        String str = bi.readLine();
        StringTokenizer strtk = new StringTokenizer(str, " ");
        int n = (Integer.parseInt(strtk.nextToken()));
        int m = (Integer.parseInt(strtk.nextToken()));
        way = new int[n + 1];
        groups = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            way[i] = 1;
            groups[i] = i;
        }
        int a, k;
        for (int i = 0; i < m; i++) {
            str = bi.readLine();
            strtk = new StringTokenizer(str, " ");
            a = (Integer.parseInt(strtk.nextToken()));
            k = a;
            int x = 0, y, fx, fy;
            for (int j = 0; j < k; j++) {
                if (j == 0)
                    x = (Integer.parseInt(strtk.nextToken()));
                else {
                    y = (Integer.parseInt(strtk.nextToken()));
                    fx = dfs(x);
                    fy = dfs(y);
                    if (fx != fy) {
                        groups[fy] = fx;
                        way[fx] += way[fy];
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            a = dfs(i);
            System.out.print(way[a] + " ");
        }
    }

    private static int dfs(int x) {
        if (groups[x] == x)
            return x;
        else return groups[x] = dfs(groups[x]);
    }
}