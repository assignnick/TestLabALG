package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long[] mas = new long[n];
        mas[0] = scanner.nextInt();
       // ArrayList<Long> listik = new ArrayList<>();
        HashMap<Long, Long> mapka = new HashMap<>();
                Long key;
        if (mas[0] % 3 == 0)
            mapka.put(mas[0] / 3, 1L);
        for (int j = 1; j < n; j++) {
            mas[j] = mas[j - 1] + scanner.nextInt();
            if (mas[j] % 3 == 0) {
                key=mas[j]/3;
                if (mapka.containsKey(key))
                    mapka.put(key, mapka.get(key) + 1);
                else {
                    mapka.put(key, 1L);

                }
            }
        }
        System.out.println(mapka.toString());

        if (mapka.size()%3==0)
            System.out.println(mapka.size() - 2);
        else
            System.out.println(0);
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
