package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ArrayCutting {
            public static void main(String[] args) {


//        InputStreamReader input = new InputStreamReader(System.in);
//        BufferedReader buffer = new BufferedReader(input);
            // FileInputStream fstream = new FileInputStream("text.txt");
            // BufferedReader buffer = new BufferedReader(new InputStreamReader(fstream));

            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int[][] chisla = new int[200005][2];
            for (int i = 0; i < chisla.length; i++) {
                chisla[i][1]=i;
            }
            ArrayList<Integer> list = new ArrayList<>();

            int tmp;

            for (int i = 0; i < n; i++) {
                tmp = scanner.nextInt();
                chisla[tmp][0]++;
            }


            Arrays.sort(chisla, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o2[0], o1[0]);
                }
            });

            int[][] chisla2= new int[k][2];

            for (int i = 0; i < k; i++) {
                chisla2[i][0]=chisla[i][0];
                chisla2[i][1]=chisla[i][1];
            }


            int maxI=0;

            list.add(chisla2[maxI][1]);
            chisla2[0][0]/=2;

            int max=chisla2[maxI][0];
            int tomax;
            int tempK=k-1;

            for (int i = 1; i < k-1; i++) {
                if(tempK==0)
                    break;
                tomax= chisla2[i][0];
                if ((max) >= tomax) {
                    tempK--;
                    list.add(chisla2[maxI][1]);
                    chisla2[maxI][0]/=2;
                    i--;
                    max=chisla2[maxI][0];
                }
                else{
                    max=tomax;
                    maxI++;
                }
            }



            for (int i = 0; i < list.size(); i++)
                System.out.print(list.get(i)+" ");


        }

    }

//        int x1,x2,y;
//        for(int i=0;i<n;i++){
//            x1=scanner.nextInt();
//            for(int j=0;j<raz;j++)
//                mas[j][x1]=1;
//        }
//        for(int i=0;i<m;i++){
//            x1=scanner.nextInt();
//            x2=scanner.nextInt();
//            y=scanner.nextInt();
//            for(int j=x1-1;j<x2;j++)
//                mas[y][j]=1;
//        }
//
//        otvet[0][0]=mas[0][0];
//        for(int i=0;i<raz;i++)
//            if(mas[i][0]==1)
//                otvet[0][i]++;
//
//        for(int i=0;i<raz;i++){
//            for(int j=0;j<raz;j++)
//                if(mas[i][j]==1)
//                    otvet[i][j]++;
//
//        }
//
//
//        for(int i=0;i<10;i++) {
//            for (int j = 0; j < 10; j++)
//                System.out.print(mas[i][j]);
//            System.out.println();
//        }


//        int[] one=new int[n+m];
//        int[] nMas=new int[n];
//        int[] mMas=new int[m];
//        int[] answer=new int[m];
//        for(int i=0;i<n+m;i++)
//            one[i]=scanner.nextInt();
//        int temp,nt=0,mt=0;
//        for(int i=0;i<n+m;i++) {
//            temp = scanner.nextInt();
//            if(temp==1) {
//                mMas[mt] = one[i];
//                mt++;
//            }
//            else {
//                nMas[nt] = one[i];
//                nt++;
//            }
//
//        }
//        int L = 0;
//        int R = m - 1;
//        int chislo,tempI=0;
//        for(int i=0;i<n;i++){
//                chislo=nMas[i];
//                L = 0;
//                R = m - 1;
//                temp=1000000000;
//                while (L <= R) {
//                    int k = (L + R) / 2;
//                    mt=mMas[k]-chislo;
//                    if(Math.abs(temp)>Math.abs(mt)) {
//                        temp = mt;
//                        tempI=k;
//                    }
//                    else if(Math.abs(temp)==Math.abs(mt)&&(tempI>k))
//                        tempI=k;
//                    if(mt>0)
//                        R=k-1;
//                    else
//                        L = k + 1;
//                }
//                answer[tempI]++;
//        }

//        System.out.println(Arrays.toString(one));
//        System.out.println(Arrays.toString(nMas));
//        System.out.println(Arrays.toString(mMas));
//
//        for(int i=0;i<m;i++)
//        System.out.print(answer[i]+" ");
