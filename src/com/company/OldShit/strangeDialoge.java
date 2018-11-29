package com.company.OldShit;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class strangeDialoge {

    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(input);
        // FileInputStream fstream = new FileInputStream("text.txt");
        // BufferedReader buffer = new BufferedReader(new InputStreamReader(fstream));

        int n = Integer.parseInt(buffer.readLine());
        long a;
        long h;
        byte[] bytes=new byte[10000000];
        long c;
        int it,r;
        StringBuilder ans = new StringBuilder();
        for (int i=0;i<n;++i)
        {
            it=0;
            while ((c = buffer.read()) != -1) {
                if(c==10) break;
                bytes[it] = (byte) c;
                it++;
            }
            if(bytes[it-1]==13)
                it--;
            r=it-1;
            while (r >= 0) {
                a = 0;
                if (r > 0) {
                    h = (bytes[r-1] - 'a' + 1) * 31 + (bytes[r] - 'a' + 1);
                } else break;
                if (h == 293)
                    a = 2;
                else {
                    if (r > 1) {
                        h += (bytes[r-2] - 'a' + 1) * 961;
                    } else break;
                    if (h == 14854 || h == 15086)
                        a = 3;
                    else {
                        if (r > 3) {
                            h += (bytes[r-4] - 'a' + 1) * 923521 + (bytes[r-3] - 'a' + 1) * 29791;
                        } else break;
                        if (h == 15421646 || h == 8744810)
                            a = 5;
                        else {
                            if (r > 4) {
                                h+= (bytes[r-5] - 'a' + 1) * 28629151;
                            } else break;
                            if (h == 449443073)
                                a = 6;
                            else break;
                        }
                    }
                }
                r -= a;
            }

            if (r == -1)
                ans.append("YES\n");
            else
                ans.append("NO\n");
        }
        buffer.close();
        //System.out.print((int)(ans.charAt(ans.length()-1)));
        ans.setLength(ans.length()-1);
        System.out.print(ans.toString());
    }
}