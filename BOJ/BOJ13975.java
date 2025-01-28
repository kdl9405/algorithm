package boj;

import java.util.*;
import java.io.*;

/*
 * 파일 합치기 3
 * 
 * 3324ms
 */
public class BOJ13975 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();

            for (int i = 0; i < k; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long cost = 0;

            while (pq.size() > 1) {
                long x = pq.poll();
                long y = pq.poll();

                cost += (x + y);
                pq.add(x + y);
            }

            sb.append(cost).append("\n");

        }

        System.out.println(sb.toString().trim());
    }

}
