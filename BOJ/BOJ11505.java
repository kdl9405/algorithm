package BOJ;

/* 
    구간 곱 구하기
*/

import java.io.*;
import java.util.*;

public class BOJ11505 {

    public static void main(String[] args) throws IOException {

        new BOJ11505().solution();
    }

    void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        num = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            num[i] = Long.parseLong(br.readLine());
        }

        tree = new long[N * 4];
        init(1, N, 1);

        answer = new StringBuilder();
        for (int i = M+K; i > 0; i--) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                num[b] = c;
                change(1, N, 1, b, c);
            }else{
                answer.append(getValue(1, N, 1, b, c)).append("\n");
            }
        }

        System.out.println(answer.toString().trim());
    }

    int N, M, K;
    long[] num, tree;

    long MOD = 1000000007;
    StringBuilder answer;

    long init(int start, int end, int now) {

        if (start == end) {
            return tree[now] = num[start];
        }

        int mid = (start + end) / 2;

        return tree[now] = (init(start, mid, now * 2) * init(mid + 1, end, now * 2 + 1)) % MOD;

    }

    long change(int start, int end, int now, int b, int c) {

        if (b < start || b > end) {
            return tree[now];
        }

        if (start == end) {
            return tree[now] = c;
        }

        int mid = (start + end) / 2;

        return tree[now] = (change(start, mid, now * 2, b, c) * change(mid + 1, end, now * 2 + 1, b, c)) % MOD;
    }

    long getValue(int start, int end, int now, int b, int c) {

        if (c < start || b > end) {
            return 1;
        }

        if (b <= start && end <= c) {
            return tree[now];
        }

        int mid = (start + end) / 2;

        return (getValue(start, mid, now * 2, b, c) * getValue(mid + 1, end, now * 2 + 1, b, c)) % MOD; 

    }
}
