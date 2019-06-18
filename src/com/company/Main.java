package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    private static int cycle_st = -1, cycle_end;
    private static ArrayList<Integer> maxcircle = new ArrayList<>();
    private static ArrayList<Integer> circle = new ArrayList<>();
    private static ArrayList<Integer> notes = new ArrayList<>();
    private static int[][] answer;

    public static void main(String[] args) throws IOException {

        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bi.readLine());
        ArrayList<Integer>[] graph = new ArrayList[n];
        int[][] mas = new int[n + 1][n + 1];
        int[][] newgraph = new int[n][2];
        int[][] stations = new int[n][2];
        int[][] pass = new int[n][2];
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
            mas[a][b] = 1;
            mas[b][a] = 1;
            newgraph[i][0] = a;
            newgraph[i][1] = b;
            graph[i] = new ArrayList<>(Arrays.asList(a, b));
        }

        System.out.println(map.toString());
        System.out.println((Arrays.deepToString(newgraph)));


        for (int k = 0; k < stations.length; k++) {
            pass[k][0] = -1;
            pass[k][1] = -1;
            stations[k][0] = -1;
            stations[k][1] = -1;
        }
        //ArrayList<Integer> notes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> key : map.entrySet())
            if (key.getValue() > 2) {
                notes.add(key.getKey() - 1);
                System.out.println(key.getKey());
            }
        int round = 0;


        for (int i : notes) {
            mydfs(i, newgraph, stations, i, -1, 0, round);
            System.out.println((Arrays.deepToString(answer)));
            round++;
        }
    }

    public static void mydfs(int station, int[][] newgraph, int[][] stations, int start, int pr, int fl, int round) {
        if (stations[station][1] != round) {
            if (stations[station][0] != -1)
                stations[station][0] = Math.min(fl, stations[station][0]);
            else
                stations[station][0] = fl;

            stations[station][1] = round;
            fl++;
            for (int j = 0; j < newgraph.length; j++) {
                for (int i = 0; i < newgraph[j].length; ++i) {
                    if (newgraph[j][i]-1 == station && newgraph[j][1-i]-1  != pr) {
                        mydfs(newgraph[j][1 - i] - 1, newgraph, stations, start, station, fl, round);
                    }
                }
            }
        } else if (station == start) {

            stations[pr][0] = 0;
            if (!notes.contains(pr))
            for (int j = 0; j < newgraph.length; j++) {
                for (int i = 0; i < newgraph[j].length; ++i) {
                    if (newgraph[j][i]-1  == pr && newgraph[j][1-i]-1  != station) {
                        mydfs(newgraph[j][1 - i] - 1, newgraph, stations, start, station, 0, round);
                        break;
                    }
                }
            }
            answer = stations;
        }
        else if (!notes.contains(station) && fl==0) {
            stations[station][0] = 0;
            for (int j = 0; j < newgraph.length; j++) {
                for (int i = 0; i < newgraph[j].length; ++i) {
                    if (newgraph[j][i]-1 == station && newgraph[j][1-i]-1 != pr) {
                        if (!notes.contains(newgraph[j][1 - i] - 1))
                        mydfs(newgraph[j][1 - i] - 1, newgraph, stations, start, station, 0, round);
                        break;
                    }
                }
            }

        }

       // System.out.println((Arrays.deepToString(stations)));

//            if (pass[pos][0] == -1) {
//            circle.add(pos+1);
//            pass[pos][0] = fl;
//            fl++;
//            for (int j = 0; j < newgraph.length; j++) {
//                if (j != pos && j != pr)
//                    for (int i = 0; i < newgraph[j].length; ++i) {
////            int to = newgraph[pos][i];
////                if (next == station) {
////                    if (pass[newgraph[pos][1 - next]][0] == -1) {
////                        pass[next][0]++;
////                    } else if (pass[newgraph[pos][1 - next]][1] == -1) {
////                        pass[next][1]++;
////                    }
////                }
//                        if (newgraph[pos][0] == newgraph[j][i] && pass[j][1] == -1) {
//
//                            mydfs(j, newgraph, pass, circle, pos, fl);
//                        }
//                        if (newgraph[pos][1] == newgraph[j][i] && pass[j][1] == -1) {
//                            mydfs(j, newgraph, pass, circle, pos, fl);
//                        }
//                    }
//            }
//        } else {
//            if(circle.size()>maxcircle.size())
//                maxcircle = circle;
//
//          //  pass[pos][0] = Math.min(fl, pass[pos][0]);
//            pass[pos][0]=0;
//            pass[pos][1] = fl;
//            //System.out.println(circle.toString());
//            circle = new ArrayList<>();
//
//        }
//        circle.add(pos);
//        System.out.println((Arrays.deepToString(pass)));

    }
}




