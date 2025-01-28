package boj;

import java.io.*;
import java.util.*;

/*
 * 카드 정렬하기
 */
public class BOJ1715 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        while (n-- > 0) {
            pq.add(Long.parseLong(br.readLine()));
        }

        long count = 0;

        while (pq.size() > 1) {
            long a = pq.poll();
            long b = pq.poll();

            count += (a + b);

            pq.add(a + b);
        }

        System.out.println(count);

    }
}
