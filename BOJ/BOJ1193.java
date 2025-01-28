package boj;


import java.util.Scanner;

public class BOJ1193 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        sc.close();

        int n = 1;
        while (true) {

            if ((n * (n - 1) / 2 < x) && (x <= (n * (n + 1) / 2))) {

                break;
            }

            n += 1;
        }

        int[] a = new int[n];
        int[] b = new int[n];

        int temp = n;
        switch (temp % 2) {
            case 0:

                for (int i = 0; i < n; i++) {
                    a[i] = i + 1;
                    b[i] = temp;

                    temp = temp - 1;
                }

                break;

            case 1:

                for (int i = 0; i < n; i++) {
                    a[i] = temp;
                    b[i] = i + 1;

                    temp = temp - 1;
                }

                break;
        }

        int count = 0;
        for (int j = ((n * (n - 1) / 2) + 1); j <= (n * (n + 1) / 2); j++) {

            if (j == x) {
                break;
            }
            count += 1;
        }

        System.out.println(a[count] + "/" + b[count]);

    }
}
