package boj;

import java.io.*;
import java.util.*;

/*
 * 우주신과의 교감
 * 
 * 884ms
 */

public class BOJ1774_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] point = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }

        List<link> distance = new LinkedList<>();

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {

                double d = Math.sqrt(Math.pow(point[i][0] - point[j][0], 2)
                        + Math.pow(point[i][1] - point[j][1], 2));

                distance.add(new link(i, j, d));
            }
        }

        double total = 0;

        group = new int[n + 1];

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = findGroup(Integer.parseInt(st.nextToken()));
            int b = findGroup(Integer.parseInt(st.nextToken()));

            if (a != b) {
                group[b] = a;
            }
        }

        Collections.sort(distance, (a, b) -> {
            return Double.compare(a.d, b.d);
        });

        for (link now : distance) {
            int a = findGroup(now.x);
            int b = findGroup(now.y);

            if (a == b) {
                continue;
            }

            total += now.d;

            group[b] = a;
        }

        System.out.printf("%.2f", total);

    }

    static int[] group;

    static int findGroup(int n) {

        if (group[n] == 0) {
            return group[n] = n;
        }
        if (group[n] == n) {
            return n;
        }

        return group[n] = findGroup(group[n]);
    }

}


class link {
    int x;
    int y;
    double d;

    public link(int x, int y, double d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}
