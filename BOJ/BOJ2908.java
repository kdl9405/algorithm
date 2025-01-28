package boj;

import java.util.*;

public class BOJ2908 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String B = sc.next();

        sc.close();

        StringBuilder Ra = new StringBuilder(A);
        StringBuilder Rb = new StringBuilder(B);

        int a = Integer.parseInt(Ra.reverse().toString());
        int b = Integer.parseInt(Rb.reverse().toString());

        if (a > b) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }
}
