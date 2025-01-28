package boj;

import java.util.Scanner;

/*
 * 거스름돈
 */
public class BOJ14916 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int min = n;


        for (int i = n / 5; i >= 0; i--) {
            int r = n - (i * 5);
            if (r % 2 == 0) {
                min = Math.min(min, (r / 2) + i);
            }
        }

        for (int i = n / 2; i >= 0; i--) {
            int r = n - (i * 2);
            if (r % 5 == 0) {
                min = Math.min(min, (r / 5) + i);
            }
        }

        if (min == n) {
            min = -1;
        }

        System.out.println(min);


    }
}
