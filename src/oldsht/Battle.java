package oldsht;

import java.util.Scanner;
import java.util.Random;
public class Battle {
    Battle(){
        Random rnd = new Random();
        Scanner scanner = new Scanner(System.in);
       // int n =scanner.nextInt();
       // int k =scanner.nextInt();
        int j;
        long A=0,B=0;
        int n =10;
        int k =10;
        for (int i=0;i<n;i++) {
            //j =scanner.nextInt();
            j=rnd.nextInt(20);
            System.out.println(j);
            if(j>k) A+=j-k;
            if(j<k) B+=k-j;
        }
        System.out.println(A);
        System.out.println(B);
        }
    }
