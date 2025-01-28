package boj;

/*
 * 입국심사
 * 
 * 메모리 초과
 */

import java.io.*;
import java.util.*;

public class BOJ3079_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });

        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(br.readLine());
            queue.add(new int[] {t, t});
        }

        int time = 0;
        for (int i = 0; i < M; i++) {
            int[] now = queue.poll();
            time = now[1];
            queue.add(new int[] {now[0], now[0] + now[1]});
        }

        System.out.println(time);
    }
}
