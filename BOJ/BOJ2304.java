package boj;

/*
 * 창고 다각형
 */

import java.io.*;
import java.util.*;

public class BOJ2304 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ2304().soultion();

    }

    public void soultion() throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> polygon = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            polygon.add(
                    new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        Collections.sort(polygon, (a, b) -> {
            return a[0] - b[0];
        });

        int sum = 0;
        int max = 0;

        int[] now = polygon.get(0);
        for (int i = 1; i < N; i++) {
            if (now[1] <= polygon.get(i)[1]) {
                sum += (polygon.get(i)[0] - now[0]) * now[1];
                now = polygon.get(i);
                max = i;
            }
        }

        now = polygon.get(N - 1);
        for (int i = 0; i < N - max; i++) {
            if (now[1] <= polygon.get(N - i - 1)[1]) {
                sum += (now[0] - polygon.get(N - i - 1)[0]) * now[1];
                now = polygon.get(N - i - 1);
            }
        }

        sum += now[1];

        System.out.println(sum);
    }
}
