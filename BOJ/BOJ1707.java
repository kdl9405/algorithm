package BOJ;

/* 
    이분 그래프

   최적화 필요
*/

import java.io.*;
import java.util.*;

public class BOJ1707 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            line = new ArrayList<>();
            for (int i = 0; i <= v; i++) {
                line.add(new ArrayList<>());
            }

            while (e-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                line.get(a).add(b);
                line.get(b).add(a);
            }

            color = new int[v + 1];

            Queue<Integer> queue = new LinkedList<>();
            boolean check = true;

            for (int i = 1; i <= v; i++) {
                if (color[i] != 0) {
                    continue;
                }
                color[i] = 1;
                queue.add(i);

                loop: while (!queue.isEmpty()) {
                    int now = queue.poll();

                    for (int next : line.get(now)) {
                        if (color[next] == 0) {
                            queue.add(next);
                        }

                        if (color[now] == color[next]) {
                            check = false;
                            break loop;
                        }

                        if (color[next] == 0) {
                            if (color[now] == 1) {
                                color[next] = 2;
                            } else {
                                color[next] = 1;
                            }
                        }
                    }
                }

            }

            if (check) {
                sb.append("YES" + "\n");
            }else{
                sb.append("NO" + "\n");
            }

        }

        System.out.println(sb.toString().trim());

    }

    static List<List<Integer>> line;
    static int[] color;

}
