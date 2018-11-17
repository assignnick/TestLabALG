package oldsht;

import java.util.Scanner;

 class ExamineStrings {
    ExamineStrings(){
        Scanner scanner = new Scanner(System.in);
         //String str = scanner.next();
        String str = "CodeforceaBAabatourzXZCodeforceaBAabatourzXZCodeforceaBAabatourzXZCodeforceaBAabatourzXZCodeforceaBAabatourzXZCodeforceaBAabatourzXZCodeforceaBAabatourzXZCodeforceaBAabatourzXZCodeforceaBAabatourzXZCodeforceaBAabatourzXZCodeforceaBAabatourzXZCodeforceaBAabatourzXZCodeforceaBAabatourzXZCodeforceaBAabatourzXZCodeforceaBAabatourzXZCodeforceaBAabatourzXZCodeforceaBAabatourzXZ";
        StringBuilder Answer= new StringBuilder();
         int bkv;

        for (int i = 0; i < str.length(); i++) {
            bkv = (int) str.charAt(i);
            //System.out.println("bkv="+bkv+"   str="+str.charAt(i));
            if (bkv == (65) || bkv == (79) || bkv == (89) || bkv == (69) || bkv == (85) || bkv == (73) ||
            bkv-32 == (65) || bkv-32 == (79) || bkv-32 == (89) || bkv-32 == (69) || bkv-32 == (85) || bkv-32 == (73))
            {}
               else {
                Answer.append('.');
                if (bkv>96)
                    Answer.append((char) bkv);
                else
                    Answer.append((char) (bkv + 32));
            }
        }
        System.out.println(Answer.toString());
    }
}
