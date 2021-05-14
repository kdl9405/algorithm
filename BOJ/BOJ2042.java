package BOJ;

import java.io.*;
import java.util.*;

/* 
    구간 합 구하기

    // 배열로 구현한 세그먼트 트리
*/
public class BOJ2042 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int size = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
        size = (int) Math.pow(2, size);

        arr = new long[n + 1];
        tree = new long[size];

        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init(1, n, 1);


        for(int i = 0; i<m+k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                long d = c-arr[b];
                update(1, n, 1, b, d);
            }else{
                sb.append(sum(1, n, 1, b, (int)c)+"\n");
            }
        }

        System.out.println(sb.toString());

    }

    static long[] arr;
    static long[] tree;

    static long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;

        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    static void update(int start, int end, int node, int idx, long dif) {

        if (idx < start || idx > end) {
            return;
        }

        tree[node] += dif;

        if (start == end) {
            arr[idx] = tree[node];
            return;
        }

        int mid = (start + end) / 2;
        update(start, mid, node * 2, idx, dif);
        update(mid + 1, end, node * 2 + 1, idx, dif);
    }

    static long sum(int start, int end, int node, int left, int right) {
        if (right < start || left > end) {
            return 0;
        }

        if (left <= start && right >= end) {
            return tree[node];
        }

        int mid = (start+end)/2;
        return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
    }
}
