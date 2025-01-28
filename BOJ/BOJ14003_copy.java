package boj;

/*
 * 가장 긴 증가하는 부분 수열 5
 * 
 * 1. 배열을 앞과 뒤부분으로 나눔. 2. 앞부분에서 증가하는 부분수열울 구함. (길이와 마지막 숫자) 3. 앞부분 부분수열의 마지막 숫자와 이어지는 부분수열을 뒷부분에서 구함
 * 
 * 시간초과 and 틀림
 * 
 */

import java.io.*;
import java.util.*;

public class BOJ14003_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        A = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        HashMap<Integer, Long> map = new HashMap<>();

        long min = Long.MAX_VALUE;

        for (int i = 1; i < N / 2; i++) {

            min = Math.min(min, A[i]);
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {

                    if (dp[i] <= dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        if (map.containsKey(dp[i])) {
                            map.put(dp[i], Math.min(A[i], map.get(dp[i])));
                        } else {
                            map.put(dp[i], A[i]);
                        }
                    }
                }
            }
        }

        map.put(1, Math.min(min, A[0]));

        int count = 0;

        for (int c : map.keySet()) {

            count = Math.max(count, c);

            for (int i = N / 2; i < N; i++) {
                if (A[i] <= map.get(c)) {
                    continue;
                }
                dp[i] = Math.max(dp[i], c + 1);

                for (int j = N / 2; j < i; j++) {

                    if (A[i] > A[j] && A[j] > map.get(c)) {

                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        count = Math.max(count, dp[i]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Stack<Long> stack = new Stack<>();

        sb.append(count + "\n");

        for (int i = N - 1; i >= 0; i--) {
            if (dp[i] == count) {
                stack.push(A[i]);
                count--;
                if (count < 0) {
                    break;
                }
            }
        }


        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb.toString());


    }

    static long[] A;

}
