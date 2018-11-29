package com.company.OldShit;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class antiCAPS {
    antiCAPS() {
        StringBuilder str =new StringBuilder();
        try (InputStreamReader input = new InputStreamReader(System.in);
             BufferedReader buffer = new BufferedReader(input)) {
            String cr;
            char chr;
            while ((cr =buffer.readLine())!=null ) {
                if((cr.isEmpty())) break;
                str.append(cr);
                str.append("\r\n");
            }
            buffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringBuilder ans=new StringBuilder();
        int j=0;
        boolean ch=true;
        for(int i=0; i<str.length();i++)
        {
            j=(int) str.charAt(i);
            if(j==33||j==46||j==63)
                ch=true;



            if((j<65 || j>90))
                ans.append((char) j);

            else if (!ch)
                ans.append((char) (j+32));
            else {
                ans.append((char) j);
                ch=false;
            }
        }
        System.out.println(ans.toString());
    }}