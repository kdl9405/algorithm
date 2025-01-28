package boj;


import java.util.Scanner;

public class BOJ10870 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sc.close();

        int result = pibN(n);

        System.out.println(result);

    }

    public static int pibN(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        return pibN(n - 1) + pibN(n - 2);
    }
}
