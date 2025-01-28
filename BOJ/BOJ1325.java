package boj;

/*
 * 효율적인 해킹
 * 
 */

import java.io.*;
import java.util.*;

public class BOJ1325 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        link = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            link.add(new HashSet<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            link.get(B).add(A);
        }

        StringBuilder sb = new StringBuilder();
        check = new boolean[N + 1][N + 1];
        count = new int[N + 1];
        int max = 0;
        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            temp = 0;
            findCount(i);
            if (max == temp) {
                sb.append(i + " ");
            } else if (max < temp) {
                max = temp;
                sb = new StringBuilder();
                sb.append(i + " ");
            }
            count[i] = temp;
            check[i] = visit;
            // System.out.println(i+ " = "+ count[i]);
        }

        System.out.println(sb.toString().trim());

    }

    static List<HashSet<Integer>> link;
    static boolean[] visit;
    static boolean[][] check;
    static int[] count;
    static int max;
    static int temp;

    static void findCount(int x) {

        // System.out.println(x);

        visit[x] = true;

        for (int slave : link.get(x)) {
            if (visit[slave]) {
                continue;
            }

            // temp++;
            // findCount(slave);

            // System.out.println("!!! "+ slave + " "+ count[slave]);
            if (count[slave] == 0) {
                temp++;
                findCount(slave);
            } else {
                int t = 0;
                for (int i = 1; i < visit.length; i++) {
                    if (check[slave][i] && !visit[i]) {
                        visit[i] = true;
                        t++;
                    }
                }
                System.out.println(x + " " + temp + " " + t);
                temp += t;
            }
        }

    }

}
