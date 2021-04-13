package BOJ;

import java.io.*;
import java.util.*;

/* 
    작업 

    작업이 선행순서에 뒤집히는 일 없이 입력됨!!!!
*/

public class BOJ2056 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1]; // 1번 작업을 완료한 최소시간
        int total = 0;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            int bCount = Integer.parseInt(st.nextToken());

            int max = 0;
            while (bCount-- > 0) {
                max = Math.max(max, dp[Integer.parseInt(st.nextToken())]);
            }
            dp[i] = time + max;

            total = Math.max(total, dp[i]);
        }

        System.out.println(total);

    }

}
