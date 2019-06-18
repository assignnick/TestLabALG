package com.company.useless;

import java.util.ArrayList;
import java.util.Scanner;

public class binary {
    public binary() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> asd = new ArrayList<>();
        asd.add(1);
        int search = scanner.nextInt();
        int numb = -1;
        int L = 0;
        int R = asd.size() - 1;

        while (L <= R) {
            int k = (L + R) / 2;
            if (asd.get(k) == search) {
                numb = asd.get(k);
                break;
            } else if (asd.get(k) > search) {
                R = k - 1;
            } else if (asd.get(k) < search) {
                L = k + 1;
            }
        }
        if (numb == -1) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}
