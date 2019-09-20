package com.company.sixsevenLabs;

import java.io.*;
import java.util.*;

public class electric {
    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        // bi = new BufferedReader(new InputStreamReader(new FileInputStream("src\\com\\company\\gryadka.txt")));
        String str = bi.readLine();
        StringTokenizer strtk = new StringTokenizer(str, " ");
        int n = (Integer.parseInt(strtk.nextToken()));
        int k = (Integer.parseInt(strtk.nextToken()));
        int a;
        ArrayList<Integer> notes = new ArrayList<>();
        ArrayList<Integer> cities = new ArrayList<>();
        ArrayList<Integer> prices = new ArrayList<>();
        int[][] graph = new int[n][n];
        str = bi.readLine();
        strtk = new StringTokenizer(str, " ");
        while (strtk.hasMoreTokens()) {
            a = (Integer.parseInt(strtk.nextToken()));
            notes.add(a - 1);
        }
        for (int i = 0; i < n; i++) {
            str = bi.readLine();
            strtk = new StringTokenizer(str, " ");
            for (int j = 0; j < n; j++) {
                a = (Integer.parseInt(strtk.nextToken()));
                graph[i][j] = a;

            }
            prices.add(-1);
            cities.add(-1);
        }
        for (int i : notes) {
            cities.set(i, 0);
            for (int j = 0; j < graph.length; j++) {
                if (prices.get(j) != -1)
                    prices.set(j, Math.min(prices.get(j), graph[i][j]));
                else
                    prices.set(j, graph[i][j]);
            }
        }
        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i) == 0)
                prices.set(i, 1000000);
        }
        int sum = 0;
        int ind;
        while (cities.contains(-1)) {
            ind = prices.indexOf(Collections.min(prices));
            sum += Collections.min(prices);
            cities.set(ind, 1);
            prices.set(ind, 1000000);
            for (int j = 0; j < graph.length; j++) {
                if (prices.get(j) != 1000000 && graph[ind][j] != 0)
                    prices.set(j, Math.min(prices.get(j), graph[ind][j]));
            }
        }
        System.out.println(sum);
//        System.out.println(Arrays.deepToString(graph));
//        System.out.println(Arrays.toString(answer));
//        System.out.println(cities.toString() + " cities");
//        System.out.println(prices.toString() + " prices");
    }
}


