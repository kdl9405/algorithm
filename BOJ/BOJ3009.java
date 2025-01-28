package boj;

import java.util.Scanner;

public class BOJ3009 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int squ[][] = new int[2][2];
        int x = 0, y = 0;

        int n = 0;
        while (n < 3) {

            x = sc.nextInt();
            y = sc.nextInt();

            for (int i = 0; i < 2; i++) {
                if (squ[i][0] == 0) {
                    squ[i][0] = x;
                    break;
                } else if (squ[i][0] == x) {
                    squ[i][0] = -1;
                    break;
                }
            }

            for (int i = 0; i < 2; i++) {
                if (squ[i][1] == 0) {
                    squ[i][1] = y;
                    break;
                } else if (squ[i][1] == y) {
                    squ[i][1] = -1;
                    break;
                }
            }

            n++;

        }

        sc.close();

        for (int i = 0; i < 2; i++) {

            if (squ[i][0] != -1) {
                x = squ[i][0];
            }

            if (squ[i][1] != -1) {
                y = squ[i][1];
            }
        }

        System.out.println(x + " " + y);
    }

}
