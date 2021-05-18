package BOJ;

import java.io.*;
import java.util.*;

/* 
    통신망 분할
*/
public class BOJ17398 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[][] line = new int[M + 1][3];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());

        }

        int[] order = new int[Q];
        for (int i = 0; i < Q; i++) {
            order[i] = Integer.parseInt(br.readLine());
            line[order[i]][2] = 1;
        }

        group = new int[N + 1];
        groupCount = new int[N + 1];

        for (int i = 1; i <= M; i++) {
            if (line[i][2] == 1) {
                continue;
            }

            int a = findGroup(line[i][0]);
            int b = findGroup(line[i][1]);

            if (a == b) {
                continue;
            }

            groupCount[a] += groupCount[b];
            group[b] = a;
        }

        long sum = 0;

        for (int i = Q - 1; i >= 0; i--) {
            int a = findGroup(line[order[i]][0]);
            int b = findGroup(line[order[i]][1]);

            if (a == b) {
                continue;
            }

            sum += (groupCount[a] * groupCount[b]);

            groupCount[a] += groupCount[b];
            group[b] = a;

            System.out.println(sum);
        }

        System.out.println(sum);
    }

    static int[] group;
    static int[] groupCount;

    static int findGroup(int x) {
        if (group[x] == 0) {
            groupCount[x] = 1;
            return group[x] = x;

        }

        if (group[x] == x) {
            return x;
        }

        return group[x] = findGroup(group[x]);
    }
}
