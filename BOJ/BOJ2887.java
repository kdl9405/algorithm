package BOJ;

import java.io.*;
import java.util.*;

/* 
    행성 터널
*/

public class BOJ2887 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<int[]> point = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            point.add(new int[] { i, x, y, z });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });

        for (int i = 1; i <= 3; i++) {
            int x = i;
            Collections.sort(point, (a, b) -> {
                return a[x] - b[x];
            });

            for (int j = 0; j < n - 1; j++) {
                pq.add(new int[] { point.get(j)[0], point.get(j+1)[0], Math.abs(point.get(j)[x] - point.get(j+1)[x]) });
            }
        }

        group = new int[n + 1];

        long sum = 0;
        int count = 0;

        while (!pq.isEmpty()) {
            int[] d = pq.poll();

            int a = findGroup(d[0]);
            int b = findGroup(d[1]);

            if (a != b) {
                group[b] = a;
                sum += d[2];
                count++;
                if (count == n - 1) {
                    break;
                }
            }
        }

        System.out.println(sum);
    }

    static int[] group;

    static int findGroup(int x) {

        if (group[x] == 0) {
            return group[x] = x;
        }
        if (group[x] == x) {
            return x;
        }

        return group[x] = findGroup(group[x]);
    }
}
