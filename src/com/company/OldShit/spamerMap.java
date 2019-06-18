package com.company.OldShit;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

public class spamerMap {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        Map<String,Integer> mp=new HashMap<>();
        int a = scanner.nextInt();
        String str;
        long hash = 0;
        boolean yest = false;
        StringBuffer bs = new StringBuffer();

        str = scanner.nextLine();
        mp.put(str,1);
        for (int i = 1; i <= a; ++i) {
            str = scanner.nextLine();
            if (mp.containsKey(str))
                mp.put(str, mp.get(str) + 1);
            else
                mp.put(str, 1);
        }
        for(Map.Entry<String, Integer> key : mp.entrySet()){
            if(key.getValue()>1)
                System.out.println(key.getKey());
        }
    }
}
