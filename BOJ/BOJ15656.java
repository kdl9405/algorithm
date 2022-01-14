package BOJ;

/* 
    N과 M (7)
*/

import java.io.*;
import java.util.*;

public class BOJ15656 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        answer = new StringBuilder();
        backTracking(new StringBuilder(), 0);
        System.out.println(answer.toString().trim());

    }

    static int N, M;
    static int[] arr;
    static StringBuilder answer;

    static void backTracking(StringBuilder sequence, int count) {
        if (count == M) {
            answer.append(sequence).append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            backTracking(new StringBuilder(sequence).append(arr[i]).append(" "), count + 1);
        }

    }
}
