package com.company;

public class newclsss {
  /*

           InputStreamReader vvod = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(vvod);
        Scanner scanner = new Scanner(System.in);
         scanner = new Scanner(new File("E:/Users/assig/IdeaProjects/AnotherTestAlgLab/src/com/company/text.txt"));



    }*/





}
        /*try (InputStreamReader input = new InputStreamReader(System.in);
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
        }*/

        /*

        public class Main {
    public static void main(String[] args) {
        long start,finish,time;//время
        start = System.nanoTime();//время


        String asdad="aabaaab";
        System.out.println( Prefix.getPrefix(asdad).toString());




        int[] ppows=new int[10000000];
        int p=31;
        ppows[0]=1;
        for (int i=1;i<10000000;++i)
            ppows[i]=ppows[i-1]*p;

        String output="output";
        String input="input";
        String puton="puton";
        String one="one";
        String out="out";
        String in="in";
        String[] strs = new String[6];
        strs[5]=output;
        strs[4]=input;
        strs[3]=puton;
        strs[1]=one;
        strs[2]=out;
        strs[0]=in;

[14, 23]
[5, 19, 484]
[20, 41, 506]
[14, 29, 649, 20830, 497486]
[20, 41, 537, 13991, 282110]
[20, 41, 537, 19757, 645368, 14498183]

        for (int i=0;i<6;i++)
        System.out.println(Arrays.toString(hash(strs[i],ppows)));


        String str;
        int n=0;
        Scanner scanner =new Scanner(System.in);
        n=scanner.nextInt();
        String[] lines = new String[n];

        try (InputStreamReader vvod = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(vvod)) {
        int a=0,r,l=0;
        while ((str = buffer.readLine()) != null)
        //while ((c = buffer.read()) != -1)
        {
        if (str.isEmpty()) break;
        //s=buffer.readLine();
        //str.append((char) c);
        //str.append(s);
        //if (c=='\n') break;
        lines[l]=str;
        //int[] h=hash(lines[a],ppows);

        int[] h = new int[lines[l].length()];
        r = lines[l].length()-1;
        while (r >= 0) {
        a=0;
        if (r > 0) {
        h[0] = (str.charAt(r) - 'a' + 1) * ppows[0];
        h[1] = (str.charAt(r - 1) - 'a' + 1) * ppows[1] + h[0];
        } else break;
        if (h[1] == 293)
        a=2;
        else{
        if (r > 1) {
        h[2] = (str.charAt(r - 2) - 'a' + 1) * ppows[2] + h[1];
        } else break;
        if (h[2] == 14854 || h[2] == 15086)
        a=3;
        else{
        if (r > 3) {
        h[3] = (str.charAt(r - 3) - 'a' + 1) * ppows[3] + h[2];
        h[4] = (str.charAt(r - 4) - 'a' + 1) * ppows[4] + h[3];
        } else break;
        if (h[4] == 15421646 || h[4] == 8744810)
        a=5;
        else{
        if (r > 4) {
        h[5] = (str.charAt(r - 5) - 'a' + 1) * ppows[5] + h[4];
        } else break;
        if (h[5] == 449443073)
        a=6;
        else break;}}}

        r-=a;
        }


        if (r ==-1)
        System.out.println("YES");
        else
        System.out.println("NO");
        l++;
        }
        } catch (Exception e) {
        e.printStackTrace();
        }






       int hCode;
        hCode = str.hashCode();
        System.out.println(hCode+" hCode");

        finish = System.nanoTime();//время
        time=finish-start;//время
        System.out.println("cold start " + String.format("%,12d",time/1000000) + " ms");//время
        System.out.println("warmed jre time " + String.format("%,12d", time/1000000) + " ms");//время


        }
private static int[] hash(String str,int[] ppows){
        int[] h=new int[str.length()];


        h[0]=str.charAt(str.length()-1)-'a'+1;

        for (int i=str.length()-2,j=1;i>=0;--i,++j) {
        if ((str.charAt(i)-'\n')==0) break;
        h[j] = (str.charAt(i) - 'a' + 1) * ppows[j] + h[j - 1];
        }

        return h;
        }
        }
        */