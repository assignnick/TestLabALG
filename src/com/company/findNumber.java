package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class findNumber {

    public static void main(String[] args) {
        //InputStreamReader input = new InputStreamReader(System.in);
        //BufferedReader buffer = new BufferedReader(input);
        //   FileInputStream fstream = new FileInputStream("text.txt");
        //  BufferedReader buffer = new BufferedReader(new InputStreamReader(fstream));
        //  Scanner scanner = new Scanner(fstream);
        Scanner scanner = new Scanner(System.in);
        boolean nine =false;
        Integer d = 80, s = 79;
//        d = scanner.nextInt();
//        s = scanner.nextInt();


        ArrayList<Integer> signDivArr = new ArrayList<>();
        ArrayList<Integer> otvetArr = new ArrayList<>();


        if (s > 9) {
            for (int i = 0; i < s / 9; i++) {
                otvetArr.add(9);
            }
            if (s % 9 != 0)
                otvetArr.add(s % 9);
        } else
            otvetArr.add(s);
        int firstSize=otvetArr.size();
        int SGSGFSHDH=0;
        for (int i = 0; i <  otvetArr.size(); i++)
            SGSGFSHDH+=otvetArr.get(i)*10^i;



        int a, b, temp = 0;


        signDivArr.add(1);

        while (signDivArr.size() <= otvetArr.size()) {
            int r = 10 % d;
            int r2 = r;
            //    System.out.printf("%s ", 1);
            if (r2 != 0) {
                signDivArr.add(r2);
            } else {
                r = 0;
                signDivArr.add(0);
            }
            //     System.out.printf("%s ", r2);
            do {
                r2 = (10 * r2) % d;
                //         System.out.printf("%s ", r2);
                if (r2 == 0 || r == 0) {
                    while ( signDivArr.size() <= otvetArr.size()*2)
                        signDivArr.add(0);
                    break;
                }
                if (r2 != r)
                    signDivArr.add(r2);
            } while (r2 != r);
        }

        boolean newdigit = false;
        while (signDivArr.size() >= otvetArr.size()) {
            temp = 0;
            for (int i = 0; i < otvetArr.size(); i++) {
                a = otvetArr.get(i);
                b = signDivArr.get(i);
                temp += a * b;
            }
            if (temp % d == 0) {
                for (int j = otvetArr.size() - 1; j > -1; j--)
                    System.out.print(otvetArr.get(j));
                newdigit = true;
                break;
            }
            newdigit = false;
            if (s > 9)
                for (int i = 1; i < otvetArr.size(); i++) {
                    if (otvetArr.get(i) < 9) {
                        for (int j = i - 1; j > -1; j--) {
                            if(otvetArr.get(j)!=9){
                                nine=false;
                                break;
                            }
                            nine=true;
                        }
                        if (nine) {
                            otvetArr.set(i, otvetArr.get(i) + 1);
                            otvetArr.set(i-1, otvetArr.get(i-1) - 1);
                            newdigit = true;
                            break;
                        }
                        else{
                            int tmp=0;
                            for(int g=0;g<=i-1;++g)
                                tmp+=otvetArr.get(g);
                            otvetArr.set(i,otvetArr.get(i)+1);
                            for (int v = 0; v <= i - 2; v++)
                                otvetArr.set(v, 9);
                            otvetArr.set(i - 1, (tmp - 1)%9);
                            newdigit=true;
                        }
                        if (newdigit)
                            break;
                    }
                }
            else
                for (int i = 1; i < otvetArr.size(); i++) {
                    if (otvetArr.get(i) <= s) {
                        for (int j = i - 1; j > -1; j--)
                            if (otvetArr.get(j) > 0) {
                                otvetArr.set(i, otvetArr.get(i) + 1);
                                otvetArr.set(j, otvetArr.get(j) - 1);
                                newdigit = true;
                                break;
                            }
                        if (newdigit)
                            break;
                    }
                }
            if (!newdigit) {

//                for (int j = otvetArr.size() - 1; j > -1; j--)
                if (s > 9 || otvetArr.size() == 1) {
                    for (int j = 0; j < otvetArr.size(); j++) {
                        if (otvetArr.get(j) > 0) {
                            int k;
                            for (k = 0; k < firstSize - 1; k++) {
                                otvetArr.set(k, 9);
                            }
                            k = firstSize - 1;
                            if (s % 9 != 0) {
                                otvetArr.set(k, s % 9 - 1);

                            } else
                                otvetArr.set(k, otvetArr.get(j) - 1);

                            for (int l = k + 1; l < otvetArr.size(); l++)
                                otvetArr.set(l, 0);
//                            otvetArr.get(j) - 9
//                            otvetArr.set(0, otvetArr.get(0) + s - 1);
                            otvetArr.add(1);
                            newdigit = true;
                            break;
                        }
                    }
                } else {
                    otvetArr.set(otvetArr.size() - 1, 0);
                    otvetArr.add(1);
                    otvetArr.set(0, otvetArr.get(0) + s - 1);
                    newdigit = true;
                }
            }
            newdigit = false;

//            for (int l = 0; l < otvetArr.size(); l++)
//                System.out.print(otvetArr.get(l));
//            System.out.println();

        }
        if (!newdigit)
            System.out.println(-1);

    }
}
