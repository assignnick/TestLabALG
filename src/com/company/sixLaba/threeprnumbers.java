package com.company.sixLaba;

import java.io.*;
        import java.math.BigInteger;
        import java.util.*;

public class threeprnumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        //   bi = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Users\\assig\\IdeaProjects\\AnotherTestAlgLab\\src\\com\\company\\gryadka.txt")));
        // sc = new Scanner(new FileInputStream("E:\\Users\\assig\\IdeaProjects\\AnotherTestAlgLab\\src\\com\\company\\gryadka2.txt"));


        // long n=sc.nextLong();
        int n = 1000;

        ArrayList<Integer> chisla = new ArrayList<>(Arrays.asList(101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151,
                157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223,
                227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281,
                283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359,
                367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433,
                439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503,
                509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593,
                599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659,
                661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743,
                751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827,
                829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911,
                919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997));
        ArrayList<Integer> newlist = new ArrayList<>();
        int a,cont=0;

        for(int nr=0;nr<n-3;nr++) {
            for (int i = 0; i < chisla.size(); i++) {
                for (int j = 1; j < 10; j++) {
                    a = (chisla.get(i) % 100) * 10 + j;
                    if (chisla.contains(a)) {

                        //  System.out.println(chisla.get(i)/100+""+a);
                        cont++;
                        newlist.add(a);
                    }
                }
            }
            chisla=newlist;
            newlist= new ArrayList<>();
            System.out.println(cont%1000000009+" cont");
            cont=0;
        }


        BigInteger sum = BigInteger.valueOf(0);
        int ans = 0;
        long out = 0;
        String str = "1";
        int df = Integer.parseInt(String.valueOf(str.charAt(0)));
        boolean no = false;
        for (int i = (int) Math.pow(10, n - 1); i < (int) Math.pow(10, n); i++) {
            str = String.valueOf(i);
            for (int j = 0; j < str.length() - 2; j++) {
                ans = 100 * Integer.parseInt(String.valueOf(str.charAt(j))) + 10 * Integer.parseInt(String.valueOf(str.charAt(j + 1))) + Integer.parseInt(String.valueOf(str.charAt(j + 2)));
                if (ans > 99) {
                    if (!chisla.contains(ans)) {
                        no = true;
                        break;
                    }
                } else {
                    no = true;
                    break;
                }
            }
            if (!no) {
                out++;
                //  System.out.println(str);
            }
            no = false;
        }


        // System.out.println(out % 1000000009);
    }
}