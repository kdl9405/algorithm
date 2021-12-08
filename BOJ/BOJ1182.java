package BOJ;

import java.io.*;
import java.util.*;

/* 
    부분수열의 합

*/
public class BOJ1182 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        find(0, 0, false);

        System.out.println(count);

    }

    static int N, S;
    static int[] arr;
    static int count;

    static void find(int idx, int sum, boolean zero) {

        if (idx == N) {
            if (zero && sum == S) {
                count++;
            }
            return;
        }

        find(idx+1, sum, zero);
        find(idx+1, sum+arr[idx], true);

    }
}
