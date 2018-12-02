package com.company;

import java.io.IOException;
import java.util.Scanner;

public class prolitieKraski {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextInt();

        long n;
        long m;
        long rez;

        long AAAAAAALLLEEE;
        AAAAAAALLLEEE=0L;
        System.out.print(AAAAAAALLLEEE);

        long bl, wt;
        long x1, x2, x3, x4, y1, y2, y3, y4;
        for (int i = 0; i < t; i++) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            x1 = scanner.nextInt();
            y1 = scanner.nextInt();
            x2 = scanner.nextInt();
            y2 = scanner.nextInt();

            x3 = scanner.nextInt();
            y3 = scanner.nextInt();
            x4 = scanner.nextInt();
            y4 = scanner.nextInt();

            if ((n * m) % 2 == 0) {
                wt = n * m / 2;
                bl = wt;
            } else {
                bl = n * m / 2;
                wt = bl + 1;
            }


            rez = (x2 - x1 + 1) * (y2 - y1 + 1);
            if (rez % 2 == 0) {
                rez /= 2;
                wt += rez;
                bl -= rez;
            } else if (x1 + y1 % 2 == 0) {
                rez /= 2;
                wt += rez;
                bl -= rez;
            } else {
                rez /= 2;
                wt += (rez + 1);
                bl -= (rez + 1);
            }

            rez = (x4 - x3 + 1) * (y4 - y3 + 1);

            if (rez % 2 == 0) {
                rez /= 2;
                bl += rez;
                wt -= rez;
            } else if (x1 + y1 % 2 == 0) {
                rez /= 2;
                bl += rez;
                wt -= rez;
            } else {
                rez /= 2;
                bl += (rez + 1);
                wt -= (rez + 1);
            }
//ghfgh

            if (x4 <= x1 && y4 <= y1 || x3 <= x2 && y3 <= y2) {
                if (x2 < x4)
                    x4 = x2;
                if (x1 > x3)
                    x3 = x1;
                if (y2 < y4)
                    y4 = y2;
                if (y1 > y3)
                    y3 = y1;
                rez = ((x4) - (x3) + 1) * ((y4) - (y3) + 1);
                if (rez % 2 == 0) {
                    rez /= 2;
                    bl += rez;
                    wt -= rez;
                } else if (x1 + y1 % 2 == 0) {
                    rez /= 2;
                    bl += rez;
                    wt -= rez;
                } else {
                    rez /= 2;
                    bl += (rez + 1);
                    wt -= (rez + 1);
                }


            }
            System.out.println(wt + " " + bl);
        }


    }
}
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//        InputStreamReader input = new InputStreamReader(System.in);
//        BufferedReader buffer = new BufferedReader(input);
//        // FileInputStream fstream = new FileInputStream("text.txt");
//        // BufferedReader buffer = new BufferedReader(new InputStreamReader(fstream));
//        Scanner scanner = new Scanner(System.in);
//        int n = Integer.parseInt(buffer.readLine());
//
//        String str;
//        long hash, p_pow, p = 79;
//        long[][] hashes = new long[n][36];
//        String[] strings = new String[n];
//
//
//        int eighth;
//        int index;
//        for (int i = 0; i < n; ++i) {
//            str = buffer.readLine();
//            strings[i] = str;
//            index = 0;
//            for (int j = 0; j < str.length(); ++j){
//                eighth = str.length()-1;
//
//                while (eighth > 0){
//                    hash = 0;
//                    p_pow = 1;
//                    for (int k = j; k < str.length()-eighth; ++k){
//                        hash += (str.charAt(k) - '.' + 1) * p_pow;
//                        p_pow *= p;
//                    }
//                    hashes[i][index] = hash;
//                    index++;
//                    eighth--;
//                }
//            }


//            while (eighth <= str.length()) {
//                for (int j = 0; j <= str.length() - eighth; ++j) {
//                    hash = 0;
//                    p_pow = 1;
//                    for (int k = j, t = 0; k < j + eighth; ++k, ++t) {
//                        //   if ((str.charAt(k) - '\n') == 0) break;
//                        hash += (str.charAt(k) - '.' + 1) * p_pow;
//                        p_pow *= p;
//
//                    }
//                    hashes[i][index] = hash;
//                    index++;
//                }
//                eighth++;
//            }
//        }
//
//         System.out.println(Arrays.deepToString(hashes));
//        int q = Integer.parseInt(buffer.readLine());
//
//        int[] digits = new int[q];
//        String[] strngs = new String[q];
//
//        int tempstring;
//        for (int i = 0; i < q; ++i) {
//            str = buffer.readLine();
//            hash = 0;
//            p_pow = 1;
//            tempstring = -1;
//            for (int j = 0; j < str.length(); ++j) {
//                hash += (str.charAt(j) - '.' + 1) * p_pow;
//                p_pow *= p;
//            }
//
//            //  System.out.println(str+" " +hash);
//            for (int x = 0; x < n; ++x) {
//                for (int y = 0; y < 36; ++y) {
//                    if (hash == hashes[x][y]) {
//                        digits[i]++;
//                        tempstring = x;
//                        break;
//                    }
//                }
//            }
//
//            if (tempstring != -1)
//                strngs[i] = strings[tempstring];
//            else
//                strngs[i] = "-";
//        }
//
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < q; i++) {
//            sb=new StringBuilder();
//            sb.append(digits[i]);
//            sb.append(" ");
//            sb.append(strngs[i]);
//            sb.append("\n");
//            writer.write(sb.toString());
//            writer.flush();
//        }
//
//    }
//}


//  Arrays.sort(chisla, new Comparator<int[]>() {
//@Override
//public int compare(int[] o1, int[] o2) {
//        return Integer.compare(o2[0], o1[0]);
//        }
//        });
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
