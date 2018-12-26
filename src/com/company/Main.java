package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        long st, en;
        st = System.nanoTime();


        ArrayList asd = new ArrayList();
        asd=Prefix.getPrefix("abbababb");
        System.out.println(asd.toString());


        Random random = new Random();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("input.txt"));
            writer.write("198303 4\n");
            for (int i = 0; i < 200000; i++) {
                writer.write(i+1 + " " + (100000000 - random.nextInt(100000000)) + "\n");
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        long sum = 0;
        long ans = 0;
        long one = -1, two = -1;
        Scanner scanner = new Scanner(new File("input.txt"));

        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int[][] mas = new int[n][3];
        int[][] mas2 = new int[n][3];

        for (int i = 0; i < mas.length; i++) {
            mas[i][0] = scanner.nextInt();
            mas[i][1] = scanner.nextInt();
            mas[i][2] = i + 1;
            mas2[i][0] = mas[i][0];
            mas2[i][1] = mas[i][1];
            mas2[i][2] = mas[i][2];
        }

        if (mas[n - 1][0] - d <= mas[0][0] + d) {
            int min = mas[n - 1][0] - d + 1;
            int max = mas[0][0] + d - 1;
            int newlg = 0;
            for (int i = 0; i < mas.length; i++) {
                if (mas[i][0] < min || mas[i][0] > max)
                    newlg++;
            }
            mas = new int[newlg][3];
            int j = 0;
            for (int i = 0; i < n; i++) {
                if (mas2[i][0] < min || mas2[i][0] > max) {
                    mas[j][0] = mas2[i][0];
                    mas[j][1] = mas2[i][1];
                    mas[j][2] = mas2[i][2];
                    j++;
                }

            }
        }
        Arrays.sort(mas, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[1], o1[1]);
            }
        });
        int kap = mas.length;
        for (int i = 0; i < kap - 1; i++)
            for (int j = i + 1; j < kap; j++) {
                if (Math.abs(mas[j][0] - mas[i][0]) >= d) {
                    sum = mas[i][1] + mas[j][1];
                    if (sum > ans) {
                        ans = sum;
                        one = mas[j][2];
                        two = mas[i][2];
                        kap = j;
                    }
                    break;
                }
            }
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        writer.write(one + " " + two);
        writer.close();


//        en = System.nanoTime();
//        System.out.println((en - st) / 1000000);
    }
}
