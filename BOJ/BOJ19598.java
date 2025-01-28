package boj;

import java.io.*;
import java.util.*;

public class BOJ19598 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] times = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, (t1, t2) -> {
            if (t1[0] == t2[0]) {
                return t1[1] - t2[1];
            } else {
                return t1[0] - t2[0];
            }
        });

        PriorityQueue<Integer> room = new PriorityQueue<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (room.isEmpty()) {
                count++;
                room.add(times[i][1]);
            } else {
                if (room.peek() <= times[i][0]) {
                    room.poll();
                } else {
                    count++;
                }
                room.add(times[i][1]);

            }
        }

        System.out.println(count);



    }
}
