package boj;


/*
 * 근손실
 */
import java.io.*;
import java.util.*;

public class BOJ18429 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        fitness = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fitness[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(fitness);

        used = new boolean[N];

        count = 0;
        exercise(0, 500);

        System.out.println(count);

    }

    static int N, K;
    static int[] fitness;
    static boolean[] used;
    static int count;

    static void exercise(int d, int m) {

        if (m < 500) {
            return;
        }

        if (d == N) {
            count++;
        }

        for (int i = 0; i < fitness.length; i++) {
            if (!used[i]) {
                used[i] = true;
                exercise(d + 1, m + fitness[i] - K);
                used[i] = false;
            }
        }

        return;
    }
}
