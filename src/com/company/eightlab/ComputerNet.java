package com.company.eightlab;

/*
http://acm.timus.ru/problem.aspx?space=1&num=1056&locale=en
        1056. Computer Net
        */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ComputerNet {
    private static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    private static int[] used;
    private static int[] way;
    private static ArrayList<Integer> centers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
       // bi = new BufferedReader(new InputStreamReader(new FileInputStream("src\\com\\company\\gryadka.txt")));
        String str = bi.readLine();
        StringTokenizer strtk = new StringTokenizer(str, " ");
        int n = (Integer.parseInt(strtk.nextToken()));
        used = new int[n];
        for (int i = 0; i < n; i++)
            list.add(new ArrayList<>());
        int a;
        for (int i = 0; i < n - 1; i++) {
            str = bi.readLine();
            strtk = new StringTokenizer(str, " ");
            a = (Integer.parseInt(strtk.nextToken()));
            list.get(i + 1).add(a - 1);
            list.get(a - 1).add(i + 1);
        }


        dfs(0, 0);
        int max = 0;
        int maxi = 0;
        for (int i = 0; i < used.length; i++)
            if (max < used[i]) {
                max = used[i];
                maxi = i;
            }


        used = new int[n];
        way = new int[n];
        dfs2(maxi, 0);
        int max2 = 0;
        int maxi2 = 0;
        for (int i = 0; i < used.length; i++)
            if (max2 < used[i]) {
                max2 = used[i];
                maxi2 = i;
            }

        int b=maxi2;
        while (b!=maxi){
            centers.add(b);
            b=way[b];
        }
        centers.add(maxi);


        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(centers.get(centers.size()/2)+1);
        if(centers.size()%2==0)
        ans.add(centers.get(centers.size()/2-1)+1);
        Collections.sort(ans);
        for (int i: ans)
        System.out.print(i+" ");
    }

    private static void dfs(int n, int c) {
        c++;
        used[n] += c;
        for (int nv : list.get(n))
            if (used[nv] == 0)
                dfs(nv, c);

    }

    private static void dfs2(int n, int c) {
        c++;
        used[n] += c;
        for (int nv : list.get(n))
            if (used[nv] == 0) {
                way[nv]=n;
                dfs2(nv, c);
            }

    }
}