package boj;

import java.util.*;
import java.io.*;

public class BOJ1654 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] line = new int[k];
        long sum = 0;
        for (int i = 0; i < k; i++) {
            line[i] = Integer.parseInt(br.readLine());
            sum += line[i];
        }

        System.out.println(cut(line, n, 1, sum / n));

    }

    static long cut(int[] line, int n, long min, long max) {

        long result = 1;

        while (min <= max) {

            long mid = (min + max) / 2;
            long count = 0;

            for (int i = 0; i < line.length; i++) {
                count += line[i] / mid;
            }

            if (count >= n) {
                result = Math.max(result, mid);
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return result;

    }
}
