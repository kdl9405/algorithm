package BOJ;

import java.io.*;
import java.util.*;

/* 
    구간 합 구하기

    // 세그먼트 트리 + 비스마스킹
*/
public class BOJ2042_copy2 {

    static int N, M, K; // N: 수열 길이 , M : 업데이트 횟수 , K: 쿼리 횟수
    static long[] nums;
    static long[] tree;

    private static void update(int i, long diff) {
        while (i <= N) {
            tree[i] += diff;
            System.out.println(i+" "+-i+" "+(i&-i));
            i += (i & -i);
        }
    }

    private static long query(int i) {
        long sum = 0L;
        while (i > 0) {
            sum += tree[i];
            i -= (i & -i);
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new long[N + 1];
        tree = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            update(i, nums[i]);
        }

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (a == 1) {
                update(b, c - nums[b]);
                nums[b] = c;
            } else {
                long answer = query((int)c) - query(b - 1);
                bw.write(String.valueOf(answer) );
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
