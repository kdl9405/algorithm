package boj;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class BOJ18110 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(scores);

        int x = (int) Math.round(n * 0.15);
        int sum = IntStream.rangeClosed(x, n - x - 1).map(i -> scores[i]).sum();
        int average = (int) Math.round(sum / (double) (n - 2 * x));

        System.out.println(average);
    }
}
