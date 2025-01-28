package boj;

/*
 * 최솟값
 */

import java.io.*;
import java.util.*;

public class BOJ10868 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        number = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            number[i] = Integer.parseInt(br.readLine());
        }

        int height = (int) Math.ceil(Math.log(N) / Math.log(2));
        segmentTree = new int[1 << (height + 1)];

        setSegmentTree(1, N, 1);

        StringBuilder answer = new StringBuilder();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a < b) {
                answer.append(findMinNumber(1, N, 1, a, b)).append("\n");
            } else {
                answer.append(findMinNumber(1, N, 1, b, a)).append("\n");
            }
        }

        System.out.println(answer.toString().trim());

    }

    static int[] number;
    static int[] segmentTree;

    static int setSegmentTree(int left, int right, int node) {
        if (left == right) {
            return segmentTree[node] = number[left];
        }

        int mid = (left + right) / 2;

        return segmentTree[node] = Math.min(setSegmentTree(left, mid, node * 2),
                setSegmentTree(mid + 1, right, node * 2 + 1));
    }

    static int findMinNumber(int left, int right, int node, int a, int b) {

        if (b < left || right < a) {
            return Integer.MAX_VALUE;
        }

        if (a <= left && right <= b) {
            return segmentTree[node];
        }

        int mid = (left + right) / 2;

        return Math.min(findMinNumber(left, mid, node * 2, a, b),
                findMinNumber(mid + 1, right, node * 2 + 1, a, b));
    }

}
