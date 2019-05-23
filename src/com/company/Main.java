package com.company;


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {


        Scanner scanner = new Scanner(new FileInputStream("input.txt"));
        Scanner scanner2 = new Scanner(new FileInputStream("input.txt"));
        Scanner scanner3 = new Scanner(new FileInputStream("input.txt"));
        char c;
        int zero = 0, one = 0, two = 0;


        int aga=0;
for (int x=1000;x<10000;x++) {
    //  int x = 660;
    double sqrt = Math.sqrt(x);
    int currentValue = x;
    int multiplier = 2;
    int NumberOfMnojitel = 0;
    while (currentValue > 1 && multiplier <= sqrt) {
        if (currentValue % multiplier == 0) {
          //  System.out.print(multiplier + " ");
            currentValue /= multiplier;
            NumberOfMnojitel++;
        } else if (multiplier == 2) {
            multiplier++;
        } else {
            multiplier += 2;
        }
    }
    if (currentValue != 1) {
      //  System.out.println(currentValue);
        NumberOfMnojitel++;
    }
   // System.out.println();
   // System.out.println(NumberOfMnojitel);
    if(NumberOfMnojitel!=1 && NumberOfMnojitel%2==1) {
        System.out.print(x + " ");
        System.out.println(aga);
        aga++;
    }
}




        StringBuilder sb = new StringBuilder();

        // BufferedWriter writer = new BufferedWriter(new FileWriter("text.txt"));
        // writer.write("6 1 3\n012022");
        //  writer.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        //   BufferedReader buffer = new BufferedReader(new FileReader("input.txt"));

        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        String str = scanner.next();
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c == '0')
                zero++;
            if (c == '1')
                one++;
            if (c == '2')
                two++;
            sb.append(c);
        }
        if (n < a + b) {
            writer.write("-1");
            writer.close();
        } else {
            int mustOne;
            int mustZero;
            int mustTwo;
            int answer = 0;
            mustZero = a - zero;
            mustOne = b - one;
            mustTwo = (n - a - b)- two;

//            System.out.println(sb.toString());
//            System.out.println("mustZero " + mustZero);
//            System.out.println("mustOne " + mustOne);
//            System.out.printf("mustTwo %d%n%n", mustTwo);


            for (int i = 0; i < sb.length(); ++i) {
                c = sb.charAt(i);
                if (c == '0') {
                    if (mustZero < 0) {
                        if (mustOne > 0) {
                            sb.replace(i, i + 1, "1");
                            mustOne--;
                            mustZero++;
                            answer++;
                        } else if (mustTwo > 0) {
                            sb.replace(i, i + 1, "2");
                            mustZero++;
                            mustTwo--;
                            answer++;
                        }
                    }
                }
                if (c == '1') {
                    if (mustOne < 0) {
                        if (mustZero > 0) {
                            sb.replace(i, i + 1, "0");
                            mustZero--;
                            mustOne++;
                            answer++;
                        } else if (mustTwo > 0) {
                            sb.replace(i, i + 1, "2");
                            mustTwo--;
                            mustOne++;
                            answer++;
                        }
                    }
                }
                if (c == '2') {
                    if (mustTwo < 0) {
                        if (mustZero > 0) {
                            sb.replace(i, i + 1, "0");
                            mustZero--;
                            mustTwo++;
                            answer++;
                        } else if (mustOne > 0) {
                            sb.replace(i, i + 1, "1");
                            mustOne--;
                            mustTwo++;
                            answer++;
                        }
                    }
                }
//                if(i==sb.length()-1&&mustZero!=0&&mustOne!=0&&mustTwo!=0)
//                    i=-1;

            }

            writer.write(answer + "\n" + sb.toString());
            writer.close();
//            System.out.println(answer);
//            System.out.println(sb.toString());
//            System.out.println("mustZero " + mustZero);
//            System.out.println("mustOne " + mustOne);
//
//            System.out.println("mustTwo " + mustTwo);
//
//            System.out.println("Zero " + zero);
//            System.out.println("one " + one);
//            System.out.println("two " + two);
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
