package com.company.OldShit;

        import java.io.*;
        import java.util.*;

public class BEROSmap {
    public static void main(String[] args) throws IOException {

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(input);
        // FileInputStream fstream = new FileInputStream("text.txt");
        // BufferedReader buffer = new BufferedReader(new InputStreamReader(fstream));
        int n = Integer.parseInt(buffer.readLine());

        HashMap<Long, Integer> mp = new HashMap<>();
        HashSet<Long> minimp=new HashSet<>();
        HashMap<Long, String> mpstr = new HashMap<>();

        String str;
        long hash=0, p_pow, p = 79;
        int eighth;

        for (int i = 0; i < n; ++i) {
            str = buffer.readLine();
            minimp.clear();
            for (int j = 0; j <= str.length(); ++j) {
                eighth = 1;
                hash = 0;
                p_pow = 1;
                while (eighth <= 8 && (j + eighth) <= str.length()) {
                    hash += (str.charAt(j + eighth - 1) - '.' + 1) * p_pow;
                    p_pow *= p;
                    if (!minimp.contains(hash)) {
                        minimp.add(hash);
                    }
                    eighth++;
                }
            }
            for(Long key : minimp){
                if (mp.containsKey(key))
                    mp.put(key, mp.get(key)+1);
                else{
                    mp.put(key, 1);
                    mpstr.put(key, str);
                }
            }
//            System.out.println(minimp);
//            System.out.println(mp);
        }

        //    System.out.println(Arrays.deepToString(hashes));
        int q = Integer.parseInt(buffer.readLine());

        int onedigit;
        String onestrng;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; ++i) {
            sb.setLength(0);
            str = buffer.readLine();
            hash = 0;
            p_pow = 1;

            onedigit = 0;
            for (int j = 0; j < str.length(); ++j) {
                hash += (str.charAt(j) - '.' + 1) * p_pow;
                p_pow *= p;
            }

            if (mp.containsKey(hash)) {
                onedigit = mp.get(hash);
                onestrng = mpstr.get(hash);
            } else {
                onestrng = "-";
            }

            sb.append(onedigit);
            sb.append(" ");
            sb.append(onestrng);
            sb.append("\n");
            writer.write(sb.toString());
            writer.flush();
        }
    }
}
