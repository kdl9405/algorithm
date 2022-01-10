package BOJ;

/* 
    최솟값과 최댓값
*/

import java.io.*;
import java.util.*;

public class BOJ2357 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        number = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            number[i] = Integer.parseInt(br.readLine());
        }

        int maxSize = 1 << ((int) Math.ceil(Math.log(N) / Math.log(2)) + 1);
        minSegmentTree = new int[maxSize];
        maxSegmentTree = new int[maxSize];

        setMinTree(1, N, 1);
        setMaxTree(1, N, 1);

        StringBuilder answer = new StringBuilder();
        while (M-- > 0) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            if (a <= b) {
                answer.append(findMin(1, N, 1, a, b)).append(" ").append(findMax(1, N, 1, a, b)).append("\n");
            } else {
                answer.append(findMin(1, N, 1, b, a)).append(" ").append(findMax(1, N, 1, b, a)).append("\n");
            }
        }

        System.out.println(answer.toString().trim());

    }

    static int[] number;
    static int[] minSegmentTree;
    static int[] maxSegmentTree;

    static int setMinTree(int left, int right, int node) {
        if (left == right) {
            return minSegmentTree[node] = number[left];
        }

        int mid = (left + right) / 2;

        return minSegmentTree[node] = Math.min(setMinTree(left, mid, node * 2), setMinTree(mid + 1, right, node*2+1));
    }

    static int setMaxTree(int left, int right, int node) {
        if (left == right) {
            return maxSegmentTree[node] = number[left];
        }

        int mid = (left + right) / 2;

        return maxSegmentTree[node] = Math.max(setMaxTree(left, mid, node * 2), setMaxTree(mid + 1, right, node*2+1));
    }

    static int findMin(int left, int right, int node, int a, int b) {

        if (b < left || right < a) {
            return Integer.MAX_VALUE;
        }

        if (a <= left && right <= b) {
            return minSegmentTree[node];
        }

        int mid = (left + right) / 2;

        return Math.min(findMin(left, mid, node * 2, a, b), findMin(mid + 1, right, node * 2 + 1, a, b));
    }

    static int findMax(int left, int right, int node, int a, int b) {

        if (b < left || right < a) {
            return 0;
        }

        if (a <= left && right <= b) {
            return maxSegmentTree[node];
        }

        int mid = (left + right) / 2;

        return Math.max(findMax(left, mid, node * 2, a, b), findMax(mid + 1, right, node * 2 + 1, a, b));
    }

}
