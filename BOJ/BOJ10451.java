package BOJ;

/* 
    순열 사이클
*/

import java.io.*;
import java.util.*;

public class BOJ10451 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            cycle = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int num = Integer.parseInt(st.nextToken());

                union(i, num);

            }

            int count = 0;
            for (int i = 1; i <= N; i++) {
                if (cycle[i] == 0) {
                    count++;
                }
            }

            answer.append(count).append("\n");
        }

        System.out.println(answer.toString().trim());
    }

    static int[] cycle;

    static int findRoot(int n) {
        if (cycle[n] == 0) {
            return n;
        }

        return cycle[n] = findRoot(cycle[n]);
    }

    static void union(int a, int b) {

        a = findRoot(a);
        b = findRoot(b);

        if (a != b) {
            cycle[b] = a;
        }
    }
}
