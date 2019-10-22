/**
 * https://codeforces.com/contest/131/problem/D
 * D. Метро
 */
package com.company.sixsevenLabs;
import java.io.*;
import java.util.*;

public class Metro {
    private static ArrayList<Integer> notes = new ArrayList<>();
    private static ArrayList<Integer>[] opyat;
    private static int[][] graph;
    private static int[][] stations;
    private static boolean node = false;
    private static boolean сfound = false;
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bi.readLine());
        answer = new int[n];
        graph = new int[n][2];
        opyat = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            opyat[i] = new ArrayList<>();
        }
        int a, b;
        for (int i = 0; i < n; i++) {
            String str = bi.readLine();
            StringTokenizer strtk = new StringTokenizer(str, " ");
            a = (Integer.parseInt(strtk.nextToken()));
            b = (Integer.parseInt(strtk.nextToken()));
            opyat[a - 1].add(i);
            opyat[b - 1].add(i);
            graph[i][0] = a - 1;
            graph[i][1] = b - 1;
        }
        for (int k = 0; k < answer.length; k++) {
            answer[k] = -1;
        }
        for (int i = 0; i < opyat.length; i++) {
            ArrayList li = opyat[i];
            if (li.size() > 2)
                notes.add(i);
        }
        stations = new int[n][2];
        if (notes.isEmpty())
            for (int i = 0; i < n; i++)
                System.out.print(0 + " ");
        else {
            for (int i : notes) {
                for (int k = 0; k < stations.length; k++) {
                    stations[k][0] = -1;
                    stations[k][1] = -1;
                }
                node = false;
                mydfs(i, i, -1, 0);
                if (node)
                    for (int j = 0; j < answer.length; j++) {
                        if ((stations[j][0] != -1 && stations[j][0] < answer[j]) || answer[j] == -1)
                            answer[j] = stations[j][0];
                    }
            }
            for (int i = 0; i < answer.length; i++)
                System.out.print(answer[i] + " ");
        }
    }

    private static void mydfs(int station, int start, int pr, int fl) {
        stations[station][1] = 1;
        stations[station][0] = fl;
        fl++;
        for (int i = 0; i < opyat[station].size(); i++) {

            int il = opyat[station].get(i);
            for (int j = 0; j < graph[il].length; ++j) {
                if ((graph[il][j] == station) && (graph[il][1 - j] != pr)) {
                    int ik = graph[il][1 - j];
                    if (stations[ik][1] == -1) {
                        mydfs(ik, start, station, fl);
                    } else if (graph[il][1 - j] == start) {
                        node = true;
                        if (!сfound) {
                            for (int jl = 0; jl < stations.length; jl++) {
                                int[] ig = stations[jl];
                                if (ig[1] == 1)
                                    answer[jl] = 0;
                            }
                            сfound = true;
                        }
                    }
                }
            }
        }
        stations[station][1] = 2;
    }
}

