package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 
 * 두 개의 탑
 * 
 */
public class BOJ2118 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];

        int sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        int left = 0;
        int right = 0;

        int now = arr[0];
        int max = 0;

        while (left <= right && right < N) {
            int t = Integer.min(now, sum - now);

            max = Math.max(max, t);

            if (t == now) {
                right++;
                now += arr[right];
            } else {
                now -= arr[left];
                left++;
            }

        }

        System.out.println(max);
    }
}
