package oldsht;

import java.util.Scanner;

public class ThreePieceSposob {
    public static void main(String[] args) {
        long sdfsf = 0;
        for (int i = 1; i < 500000 - 1; ++i)
            sdfsf += i;
        System.out.println(sdfsf);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] mas = new long[n];
        mas[0] = scanner.nextInt();
        long first = 0;
        Long key = 0L;
        for (int j = 1; j < n; j++) {
            mas[j] = mas[j - 1] + scanner.nextInt();
            key = mas[j];
        }
        long answer = 0;
        if (key % 3 == 0) {
            {
                for (int j = 0; j < n; j++) {
                    if (mas[j] == (key / 3))
                        first++;
                    else if (mas[j] == (key / 3) * 2)
                        answer += first;
                }
            }
            if (key == 0) {
                for (int i = 1; i < first - 1; i++)
                    answer += i;
            }
        }
        System.out.println(answer);
    }

}
