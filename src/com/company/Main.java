package com.company;

import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer> notes = new ArrayList<>();
    private static ArrayList<Integer>[] opyat;
    private static int[][] graph;
    private static int[][] cities;
    private static boolean node = false;
    private static boolean сfound = false;
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        // bi = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Users\\assig\\IdeaProjects\\AnotherTestAlgLab\\src\\com\\company\\gryadka.txt")));
        String str = bi.readLine();
        StringTokenizer strtk = new StringTokenizer(str, " ");
        int n = (Integer.parseInt(strtk.nextToken()));
        int k = (Integer.parseInt(strtk.nextToken()));
        int a;
        //answer = new int[n];
        //opyat = new ArrayList[n];
//        for (int i = 0; i < n; i++)
//            opyat[i] = new ArrayList<>();
        str = bi.readLine();
        while (strtk.hasMoreTokens()) {
            a = (Integer.parseInt(strtk.nextToken()));
            notes.add(a);
        }
        graph = new int[n][n];
        answer = new int[n];
        for (int i = 0; i < n; i++) {
            str = bi.readLine();
            strtk = new StringTokenizer(str, " ");
            for (int j = 0; j < n; j++) {
                a = (Integer.parseInt(strtk.nextToken()));
                graph[i][j] = a;
            }
        }

        System.out.println(Arrays.deepToString(graph));
//        for (int k = 0; k < answer.length; k++) {
//            answer[k] = -1;
//        }
//        for (int i = 0; i < opyat.length; i++) {
//            ArrayList li = opyat[i];
//            if (li.size() > 2)
//                notes.add(i);
//        }
//        cities = new int[n][2];
//        if (notes.isEmpty())
//            for (int i = 0; i < n; i++)
//                System.out.print(0 + " ");
//        else {
//            for (int i : notes) {
//                for (int k = 0; k < cities.length; k++) {
//                    cities[k][0] = -1;
//                    cities[k][1] = -1;
//                }
//                node = false;
//                mydfs(i, i, -1, 0);
//                if (node)
//                    for (int j = 0; j < answer.length; j++) {
//                        if ((cities[j][0] != -1 && cities[j][0] < answer[j]) || answer[j] == -1)
//                            answer[j] = cities[j][0];
//                    }
//            }
//            for (int i = 0; i < answer.length; i++)
//                System.out.print(answer[i] + " ");
//        }
    }

    private static void dfs(int station, int start, int pr, int fl) {
        cities[station][1] = 1;
        cities[station][0] = fl;
        fl++;
        for (int i = 0; i < opyat[station].size(); i++) {
            int il = opyat[station].get(i);
            for (int j = 0; j < graph[il].length; ++j) {
                if ((graph[il][j] == station) && (graph[il][1 - j] != pr)) {
                    int ik = graph[il][1 - j];
                    if (cities[ik][1] == -1) {
                        dfs(ik, start, station, fl);
                    } else if (graph[il][1 - j] == start) {
                        node = true;
                        if (!сfound) {
                            for (int jl = 0; jl < cities.length; jl++) {
                                int[] ig = cities[jl];
                                if (ig[1] == 1)
                                    answer[jl] = 0;
                            }
                            сfound = true;
                        }
                    }
                }
            }
        }
        cities[station][1] = 2;
    }
}


