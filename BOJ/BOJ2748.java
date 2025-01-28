package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;


// 시간초과
public class BOJ2748 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int result = fibonacci(n);

        System.out.println(result);

    }

    static int fibonacci(int n) {
        if (n > 1) {
            return fibonacci(n - 2) + fibonacci(n - 1);
        } else {
            return n;
        }

    }
}
