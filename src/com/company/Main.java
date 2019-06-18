package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> maxcircle = new ArrayList<>();
    private static ArrayList<ArrayList<Integer>> circle = new ArrayList<>();
    private static ArrayList<Integer> notes = new ArrayList<>();
    private static int[][] answer;
    private static int[][] stations;

    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bi.readLine());
        //int[][] mas = new int[n + 1][n + 1];
        int[][] graph = new int[n][2];
        int[] empty = new int[n];
        for (int k = 0; k < empty.length; k++) {
            empty[k] = -1;
        }
        answer = new int[n][2];
        Map<Integer, Integer> map = new TreeMap<>();
        int a, b;
        for (int i = 0; i < n; i++) {
            String str = bi.readLine();
            StringTokenizer strtk = new StringTokenizer(str, " ");
            a = (Integer.parseInt(strtk.nextToken()));
            b = (Integer.parseInt(strtk.nextToken()));
            for (int j = a; ; j = b) {
                if (map.containsKey(j))
                    map.put(j, map.get(j) + 1);
                else
                    map.put(j, 1);
                if (j == b)
                    break;
            }
//            mas[a][b] = 1;
//            mas[b][a] = 1;
            graph[i][0] = a;
            graph[i][1] = b;
        }
        //System.out.println(map.toString());
        //System.out.println((Arrays.deepToString(graph)));
        for (int k = 0; k < answer.length; k++) {
            answer[k][0] = -1;
            answer[k][1] = -1;
        }
        for (Map.Entry<Integer, Integer> key : map.entrySet())
            if (key.getValue() > 2) {
                notes.add(key.getKey() - 1);
                //System.out.println(key.getKey());
            }
        int round = 0;
        if (notes.isEmpty())
            for (int i = 0; i < n; i++)
                System.out.print(0 + " ");
        else {
            for (int i : notes) {
                stations = new int[n][2];
                for (int k = 0; k < stations.length; k++) {
                    stations[k][0] = -1;
                    stations[k][1] = -1;
                }
                mydfs(i, graph, stations, i, -1, 0, round);
                round++;
                System.out.println((Arrays.deepToString(answer) + "ans"));
                System.out.println((Arrays.deepToString(stations) + "stat"));
                for (int j = 0; j < answer.length; j++) {
                    if (stations[j][0] != -1 && stations[j][0] < answer[j][0] || answer[j][0] == -1)
                        answer[j][0] = stations[j][0];
                }
                System.out.println((Arrays.deepToString(answer) + "ans"));
            }

            System.out.println(maxcircle.toString() + "cirkule");

            ArrayList<Integer> zero = maxcircle.get(maxcircle.size() - 1);

            int remov = zero.get(1) + 1;
            int post = zero.get(1) + 1;
            for (int j = maxcircle.size() - 1; j >= 0; j--) {
                zero = maxcircle.get(j);
                if ((zero.get(1) + 1) == (post)) {
                    zero = maxcircle.get(j);
                    remov = zero.get(0);
                    post = zero.get(1);
                    if (remov >= 0) {
                        answer[remov][0] = 0;
                        System.out.println(zero + " " + (remov + 1));
                    }
                }
            }
            //System.out.println();
            for (int i = 0; i < answer.length; i++)
                System.out.print(answer[i][0] + " ");
        }
    }

    private static void mydfs(int station, int[][] graph, int[][] stations, int start, int pr, int fl, int round) {
        if (stations[station][1] != round) {
            circle.add(new ArrayList<Integer>(Arrays.asList(station, fl)));
            if (stations[station][0] != -1) {
                stations[station][0] = Math.min(fl, stations[station][0]);
            } else {
                stations[station][0] = fl;
            }
            stations[station][1] = round;
            fl++;
            for (int j = 0; j < graph.length; j++) {
                for (int i = 0; i < graph[j].length; ++i) {
                    if (graph[j][i] - 1 == station && graph[j][1 - i] - 1 != pr) {
                        mydfs(graph[j][1 - i] - 1, graph, stations, start, station, fl, round);
                    }
                }
            }
        } else if (station == start) {
            circle.add(new ArrayList<Integer>(Arrays.asList(station, fl)));
            if (maxcircle.size() < circle.size())
                maxcircle = circle;
            circle = new ArrayList<>();
            //stations[pr][0] = 0;
//            if (!notes.contains(pr))
//                for (int j = 0; j < graph.length; j++) {
//                    for (int i = 0; i < graph[j].length; ++i) {
//                        if (graph[j][i] - 1 == pr && graph[j][1 - i] - 1 != station) {
//                            mydfs(graph[j][1 - i] - 1, graph, stations, start, station, 0, round);
//                            break;
//                        }
//                    }
//                }
            answer = stations;
        }
//        else {
//            System.out.println("говножопа");
//            for (int k = 0; k < stations.length; k++) {
//                stations[k][0] = -1;
//            }
        System.out.println(Arrays.deepToString(stations) + "syk");
        System.out.println(maxcircle.toString() + "cirkule");


    }
}

