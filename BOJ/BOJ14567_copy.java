package boj;

import java.io.*;
import java.util.*;

/*
 * 선수과목 (Prerequisite)
 * 
 * 시간초과
 */

public class BOJ14567_copy {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        int dp[] = new int[n + 1];
        Arrays.fill(dp, 1);

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int before = Integer.parseInt(st.nextToken());
            int lecture = Integer.parseInt(st.nextToken());

            list.get(before).add(lecture);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (true) {

            HashSet<Integer> next = new HashSet<>();

            while (!queue.isEmpty()) {

                int before = queue.poll();

                ArrayList<Integer> lectures = list.get(before);
                for (Integer l : lectures) {
                    dp[l] = Math.max(dp[l], dp[before] + 1);
                    next.add(l);
                }

            }

            if (next.isEmpty()) {
                break;
            } else {
                queue.addAll(next);
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            sb.append(dp[i]).append(" ");
        }
        System.out.println(sb.toString().trim());

    }
}
