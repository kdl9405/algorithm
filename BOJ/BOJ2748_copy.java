package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2748_copy {

    static Long[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new Long[n + 1];

        arr[0] = 0L;
        arr[1] = 1L;

        System.out.println(fibonacci(n));

    }

    static long fibonacci(int n) {
        if (arr[n] == null) {
            arr[n] = fibonacci(n - 2) + fibonacci(n - 1);
        }

        return arr[n];

    }
}
