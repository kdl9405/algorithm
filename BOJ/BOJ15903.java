package boj;

/**
 * 카드 합체 놀이
 * 
 */

import java.io.*;
import java.util.*;

public class BOJ15903 {

    public static void main(String[] args) throws IOException {

        new BOJ15903().solution();

    }

    void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        while (m-- > 0) {
            long newNum = pq.poll() + pq.poll();
            pq.add(newNum);
            pq.add(newNum);
        }

        long sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        System.out.println(sum);

    }

}
