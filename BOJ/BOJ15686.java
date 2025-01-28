package boj;

import java.io.*;
import java.util.*;

/*
 * 치킨 배달
 */
public class BOJ15686 {

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

        distance = new int[house.size()][chicken.size()];
        findDistance();

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
    static int[][] distance; // 집 to 치킨집 거리

    static void findDistance() {

        for (int i = 0; i < house.size(); i++) {
            for (int j = 0; j < chicken.size(); j++) {
                distance[i][j] = (Math.abs(house.get(i)[0] - chicken.get(j)[0])
                        + Math.abs(house.get(i)[1] - chicken.get(j)[1]));
            }
        }
        return;
    }

    static void nCr(int m, int depth, int x) {

        if (depth == m) {

            int totalDistance = 0;

            for (int i = 0; i < house.size(); i++) {
                int temp = Integer.MAX_VALUE;
                for (int c : candidate) {
                    temp = Math.min(temp, distance[i][c]);
                }
                totalDistance += temp;
            }
            min = Math.min(min, totalDistance);
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
