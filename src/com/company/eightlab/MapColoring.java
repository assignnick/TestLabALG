package com.company.eightlab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MapColoring {
    public static void main(String[] args) throws IOException {
        //long st, en;
        // st = System.nanoTime();
        boolean p = true;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[] colors;
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        //bi = new BufferedReader(new InputStreamReader(new FileInputStream("src\\com\\company\\gryadka.txt")));
        String str = bi.readLine();
        StringTokenizer strtk = new StringTokenizer(str, " ");
        int n = (Integer.parseInt(strtk.nextToken()));
        colors = new int[n];
        for (int i = 0; i < n; i++)
            list.add(new ArrayList<>());
        int a;
        for (int i = 0; i < n; i++) {
            str = bi.readLine();
            strtk = new StringTokenizer(str, " ");
            a = (Integer.parseInt(strtk.nextToken()));
            while (a != 0) {
                list.get(i).add(a - 1);
                list.get(a - 1).add(i);
                a = (Integer.parseInt(strtk.nextToken()));
            }
        }
        colors[0] = 1;
        int[] queue = new int[n + 1];
        int qH = 0;
        int qT = 0;
        queue[qT++] = 0;
        int it;
        while (qH < qT) {
            it = queue[qH++];
            a = colors[it];
            for (int j : list.get(it)) {
                if (colors[j] == 0) {
                    colors[j] = 3 - a;
                    queue[qT++] = j;
                } else if (colors[j] == a) {
                    qH = qT;
                    p = false;
                    break;
                }
            }
        }
        if (!p)
            System.out.println(-1);
        else
            for (int i = 0; i < colors.length; i++) {
                System.out.print(colors[i] - 1);
            }
//        en = System.nanoTime();
//        System.out.println(en - st);
//        System.out.println((en - st) / 1000000000. + " sec");
    }
}