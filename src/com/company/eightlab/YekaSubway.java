package com.company.eightlab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class YekaSubway {
    // private static int[] mas;
    private static HashSet<Integer> used = new HashSet<>();
    private static int[][] list;

    private static int p = 0;

    public static void main(String[] args) throws IOException {
//        long st, en;
//        st = System.nanoTime();
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
       // bi = new BufferedReader(new InputStreamReader(new FileInputStream("src\\com\\company\\gryadka3.txt")));
        String str = bi.readLine();
        StringTokenizer strtk = new StringTokenizer(str, " ");
        int n = (Integer.parseInt(strtk.nextToken()));
        int k = (Integer.parseInt(strtk.nextToken()));
        int m = (Integer.parseInt(strtk.nextToken()));
        list = new int[k][3];
//        for (int i = 0; i < k; i++)
//            list.add(new int[3]);
        int a;
        for (int i = 0; i < k; i++) {
            str = bi.readLine();
            strtk = new StringTokenizer(str, " ");
            for (int j = 0; j < 2; j++) {
                a = (Integer.parseInt(strtk.nextToken()));
                list[i][j] = a;
            }
            list[i][2] = 0;
        }
        for (int i = 0; i < m; i++)
            str = bi.readLine();
      //  mas = new int[n + 1];

      //  for (int i = 0; i <= n; i++)
      //      mas[i] = 0;
        // for (int[] ints : list) System.out.println(ints[0] + " " + ints[1]);
        for (int i = 1; i <= n; i++) {
           // if (mas[i] == 0) {
            if (!used.contains(i)) {
                p++;
                dfs(i, p);
            }
        }
        System.out.println(p - 1);
//        en = System.nanoTime();
//        System.out.println(en - st);
//        System.out.println((en - st) / 1000000000. + " sec");
    }

    private static void dfs(int i, int p) {
     //   mas[i] = p;
        used.add(i);
        for (int j = 0; j < list.length; j++) {
            if (list[j][2] == 0)
                for (int k = 0; k < 2; k++)
                    if (list[j][k] == i) {
                        list[j][2] = 1;
                        //System.out.println(i+" i    "+p+" p");
                        //if (mas[list.get(j)[1 - k]] == 0)
                        if (!used.contains(list[j][1 - k]))
                            dfs(list[j][1 - k], p);
                    }
        }
    }
}