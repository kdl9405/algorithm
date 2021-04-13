package BOJ;

import java.util.*;
import java.io.*;

public class BOJ1927 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (pq.isEmpty()) {
                    sb.append(0 + "\n");
                }else{
                    sb.append(pq.poll()+"\n");
                }
            }else{
                pq.offer(x);
            }
        }

        System.out.println(sb);
    }
}
