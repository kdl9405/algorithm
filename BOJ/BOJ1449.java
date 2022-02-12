package BOJ;

/* 
    수리공 항승

*/

import java.io.*;
import java.util.*;

public class BOJ1449 {

    public static void main(String[] args) throws IOException {

        new BOJ1449().solution();
    }

    void solution() throws IOException {

        init();

        System.out.println(findCount());

    }

    int N, L;
    int[] leakPoint;

    void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken()) * 2;

        leakPoint = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            leakPoint[i] = Integer.parseInt(st.nextToken()) * 2;
        }

        Arrays.sort(leakPoint);
    }

    int findCount() {

        boolean[] isCovered = new boolean[2002];
        int count = 0;

        for (int point : leakPoint) {

            if (isCovered[point - 1] && isCovered[point] && isCovered[point + 1]) {
                continue;
            }

            int start = point - 1;
            if (isCovered[point - 1]) {

                if (!isCovered[point]) {
                    start = point;
                } else {
                    start = point + 1;
                }
            }

            int tape = ((point + 1) - start) / L;
            if (((point + 1) - start) % L > 0) {
                tape++;
            }

            int fin = Math.min(start + (L * tape), 2002);
            for (int i = start; i < fin ; i++) {
                isCovered[i] = true;
            }

            count += tape;
        }

        return count;
    }

}
