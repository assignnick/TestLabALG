package com.company.useless;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ochenInteresno {

    private static int cycle_st = -1, cycle_end;
    private static ArrayList<Integer> maxcircle = new ArrayList<>();
    private static ArrayList<Integer> circle = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bi.readLine());
        ArrayList<Integer>[] graph = new ArrayList[n];

        boolean[] used;
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
            mas[a][b] = 1;
            mas[b][a] = 1;
            newgraph[i][0] = a;
            newgraph[i][1] = b;
            graph[i] = new ArrayList<>(Arrays.asList(a, b));
        }

//        for(int i=0;i<newgraph.length;i++)
//            Arrays.sort(newgraph[i]);
//        System.out.println((Arrays.deepToString(newgraph)));
//        Arrays.sort(newgraph, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return Integer.compare(o1[0], o2[0]);
//            }
//        });
//        System.out.println((Arrays.deepToString(newgraph)));

        System.out.println((Arrays.deepToString(newgraph)));

//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                System.out.print(mas[i][j] + " ");
//            }
//            System.out.println();
//        }


        int start = newgraph[0][0];
        stations[start][0] = 0;
        int it = stations[start][0];
        int current = start;
        int vertices = 1;

        //ArrayList<Integer> circle = new ArrayList<>();


        for (int k = 0; k < pass.length; k++) {
            pass[k][0] = -1;
            pass[k][1] = -1;
        }
        mydfs(0, newgraph, pass, circle, -1, 0);
        System.out.println((Arrays.deepToString(pass)));



//        while (vertices < n) {
//            for (int i = 0; i < newgraph.length; i++) {
//
//                for (int j : newgraph[i]) {
//                    if (j == current) {
//                        if (stations[newgraph[i][1 - j]][0] == -1) {
//                            stations[j][0] = it + 1;
//                        } else if (stations[newgraph[i][1 - j]][1] == -1) {
//                            stations[j][0] = it + 1;
//                        }
//                    }
//                }
//                stations[newgraph[0][1]][0] = 1;
//                int[] next = newgraph[i];
//
//                for (int j : next) {
//                    stations[j][0] = it;
//                }
//                it++;
//                //  System.out.println(Arrays.toString(stations) + "stations");
//                // System.out.println(Arrays.toString(pass) + "pass");
//                // System.out.println();
//            }
//            vertices--;
//        }
        used = new boolean[graph.length];
//        System.out.println(Arrays.toString(used));
        //fdfs(1,newgraph,used);
        //dfs(1, newgraph, stations, pass);
        // solution(1, 1, mas, graph);
//        int[] p = new int[n];
//        for (int i : p)
//            p[i] = -1;
//        int[] cl = new int[n];

        //int cycle_st = -1, cycle_end=0;
//        for (int i = 0; i < n; ++i) {
//            if (dfs(i, newgraph, cl, p,-1)) {
//                if (cycle_st == -1)
//                    System.out.println("Acyclic");
//                else {
//                    System.out.println("Cyclic");
//                    ArrayList<Integer> cycle = new ArrayList<>();
//                    cycle.add(cycle_st);
//                    for (int v = cycle_end; v != cycle_st; v = p[v])
//                        cycle.add(v);
//                    cycle.add(cycle_st);
//                    Collections.reverse(cycle);
//                    for (int j = 0; j < cycle.size(); ++j)
//                        System.out.printf("%d ", cycle.get(j) + 1);
//                }
//            }
//        }
    }

    public static void mydfs(int pos, int[][] newgraph, int[][] pass, ArrayList<Integer> circle, int pr, int fl) {

        if (pass[pos][0] == -1) {
            circle.add(pos+1);
            pass[pos][0] = fl;
            fl++;
            for (int j = 0; j < newgraph.length; j++) {
                if (j != pos && j != pr)
                    for (int i = 0; i < newgraph[j].length; ++i) {
//            int to = newgraph[pos][i];
//                if (next == station) {
//                    if (pass[newgraph[pos][1 - next]][0] == -1) {
//                        pass[next][0]++;
//                    } else if (pass[newgraph[pos][1 - next]][1] == -1) {
//                        pass[next][1]++;
//                    }
//                }
                        if (newgraph[pos][0] == newgraph[j][i] && pass[j][1] == -1) {

                            mydfs(j, newgraph, pass, circle, pos, fl);
                        }
                        if (newgraph[pos][1] == newgraph[j][i] && pass[j][1] == -1) {
                            mydfs(j, newgraph, pass, circle, pos, fl);
                        }
                    }
            }
        } else {
            if(circle.size()>maxcircle.size())
                maxcircle = circle;

            pass[pos][0] = Math.min(fl, pass[pos][0]);
            pass[pos][1] = fl;
            //System.out.println(circle.toString());
            circle = new ArrayList<>();

        }
        circle.add(pos);
        System.out.println((Arrays.deepToString(pass)));
    }


    public static boolean dfs(int v, int[][] g, int[] cl, int[] p, int pr) {
        if (pr == v)
            return false;
        cl[v] = 1;
        for (int i = 0; i < g[v].length; ++i) {
            int to = g[v][i];
            if (cl[to] == 0) {
                p[to] = v;
                pr = v;
                if (dfs(to, g, cl, p, pr)) return true;
            } else if (cl[to] == 1) {
                cycle_end = v;
                cycle_st = to;
                return true;
            }
        }
        cl[v] = 2;
        return false;
    }


    public static void fdfs(int pos, int[][] graph, boolean[] used) {
        used[pos] = true;
        System.out.println(pos);
        for (int next : graph[pos]) {
            if (!used[next]) {
                fdfs(next, graph, used);
            }
        }
        //        System.out.print(stations[pos] + " ");
//        for (int next : pass) {
//            if (next < graph.length)
//            if (!(pass[next]==1)) {
//                dfs(next, graph, stations,pass);
//            }
//        }
    }

    public static void olddfs(int pos, int[][] graph, int[] stations, int[] pass) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(pos);
        if (pass[pos] > 1) {
            System.out.println(integers + "integers");
            return;
        }
        if (stations[pos] > 1) {
            System.out.println(integers + "integers");
            return;
        }
        for (int i = 0; i < graph.length; i++) {

            int[] next = graph[i];
            if (pass[i + 1] == 0) {
                if (next[0] == pos) {
                    pass[i + 1]++;
                    if (stations[next[0]] == 0)
                        stations[next[0]] = 2;
                    else
                        stations[next[0]] = 3;
                    if (stations[next[0]] == 0)
                        stations[next[1]] = 1;
                    else
                        stations[next[0]] = 3;
                    olddfs(next[1], graph, stations, pass);
                }
                if (next[1] == pos) {
                    pass[i + 1]++;
                    if (stations[next[0]] == 0)
                        stations[next[0]] = 1;
                    else
                        stations[next[0]] = 3;
                    if (stations[next[0]] == 0)
                        stations[next[1]] = 2;
                    else
                        stations[next[0]] = 3;
                    olddfs(next[0], graph, stations, pass);
                }
            }
        }
//
//        System.out.print(stations[pos] + " ");
//        for (int next : pass) {
//            if (next < graph.length)
//            if (!(pass[next]==1)) {
//                dfs(next, graph, stations,pass);
//            }
//        }

        System.out.println(Arrays.toString(stations) + "stations");
        System.out.println(Arrays.toString(pass) + "pass");
        System.out.println();
    }

    public static void dfs2(int pos, ArrayList<Integer>[] graph, boolean[] used) {
        used[pos] = true;
        System.out.print(pos + " ");
        ArrayList<Integer> integers = graph[pos];
        for (int i = 0; i < integers.size(); i++) {
            int next = integers.get(i);
            if (next < graph.length)
                if (!used[next]) {
                    dfs2(next, graph, used);
                }
        }
    }

    public static void solution(int start, int current_vertex, int[][] mas, ArrayList<Integer>[] graph) {
        int amount = 0;
        ArrayList<Integer> integers = graph[current_vertex];
        for (int j = 0; j < integers.size(); j++) {
            if (mas[current_vertex][j] == 1) {
                mas[current_vertex][j] = -1;
                mas[j][current_vertex] = -1;
                System.out.println((current_vertex + 1) + "->" + (j + 1)); // просто вывод для наглядности
                if (j == start) amount++;
                solution(start, j, mas, graph);
            }
        }
    }
}

