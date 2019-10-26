package com.company;
import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer> list = new ArrayList<>();
    private static ArrayList<ArrayList<Integer>> mas = new ArrayList<>();
    private static int[] way;
    private static int[] used;
    private static int ot;

    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        //bi = new BufferedReader(new InputStreamReader(new FileInputStream("src\\com\\company\\gryadka.txt")));
        String str = bi.readLine();
        StringTokenizer strtk = new StringTokenizer(str, " ");
        int n = (Integer.parseInt(strtk.nextToken()));
        int m = (Integer.parseInt(strtk.nextToken()));
        way = new int[n];
        used = new int[n];
        //mas = new int[n][n];
        int a, k,nx=0;
        for (int i = 0; i < m; i++) {
            str = bi.readLine();
            strtk = new StringTokenizer(str, " ");
            a = (Integer.parseInt(strtk.nextToken()));
            k = a;
            list = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                a = (Integer.parseInt(strtk.nextToken()));
                list.add(a);
            }
            for (int l = 0; l < list.size(); l++)
                for (int h = l + 1; h < list.size(); h++) {
                    nx++;
                    mas.add(new ArrayList<>());
                    mas.get(nx).add(l);
                    mas.get(nx).add(h);

                }
        }
        //System.out.println(Arrays.deepToString(mas));

        for (int i = 0; i < way.length; i++)
            if (way[i] < 1)
            {
                list = new ArrayList<>();
                ot = 0;
                dfs(i, list);
                for (int j : list)
                    way[j] = ot;
            }

        for (int i = 0; i < way.length; i++) {
            System.out.print(way[i] + " ");
        }
        System.out.println();

    }

    private static void dfs(int n, ArrayList<Integer> i) {
        ot++;
        i.add(n);
        used[n] = 1;
        for (int nv = 0; nv < mas.size(); nv++)
            if (mas.get(n).contains(nv) && used[nv] == 0) {
                dfs(nv, i);
            }
    }
}