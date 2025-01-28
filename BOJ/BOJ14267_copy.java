package boj;

import java.io.*;
import java.util.*;

/*
 * 회사 문화 1
 * 
 * 시간초과
 */
public class BOJ14267_copy {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> junior = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            junior.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            int b = Integer.parseInt(st.nextToken());
            if (i == 1) {
                continue;
            }
            junior.get(b).add(i);
        }

        int[] point = new int[n + 1];

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            point[i] += w;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);

            while (!queue.isEmpty()) {
                int boss = queue.poll();
                for (Integer j : junior.get(boss)) {
                    queue.add(j);
                    point[j] += w;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(point[i] + " ");
        }

        System.out.println(sb.toString());

    }

}
