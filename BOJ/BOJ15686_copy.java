package boj;

import java.io.*;
import java.util.*;

/*
 * 치킨 배달
 */
public class BOJ15686_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {

                String x = st.nextToken();

                if (x.equals("1")) {
                    house.add(new int[] {i, j});
                } else if (x.equals("2")) {
                    chicken.add(new int[] {i, j});
                }
            }
        }

        visit = new boolean[chicken.size()];
        candidate = new int[M];
        min = Integer.MAX_VALUE;

        nCr(M, 0, 0);

        System.out.println(min);

    }

    static List<int[]> house;
    static List<int[]> chicken;
    static boolean[] visit;
    static int[] candidate;
    static int min;

    static void nCr(int m, int depth, int x) {

        if (depth == m) {
            int distance = 0;
            for (int[] h : house) {
                int temp = Integer.MAX_VALUE;
                for (int c : candidate) {
                    temp = Math.min(temp, Math.abs(h[0] - chicken.get(c)[0])
                            + Math.abs(h[1] - chicken.get(c)[1]));
                }
                distance += temp;
            }
            min = Math.min(min, distance);
            return;
        }

        for (int i = x; i < chicken.size(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                candidate[depth] = i;
                nCr(m, depth + 1, i + 1);
                visit[i] = false;
            }
        }
        return;
    }
}
