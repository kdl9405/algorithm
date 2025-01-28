package boj;

/*
 * 저울
 */

import java.io.*;
import java.util.*;

public class BOJ2437_copy {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        dfs(0, 0);

        int answer = 1;
        while (true) {

            if (!weight.get(answer)) {
                break;
            }
            answer++;
        }

        System.out.println(answer);

    }

    static int N;
    static int[] num;
    static BitSet weight = new BitSet();

    static void dfs(int index, int sum) {

        weight.set(sum);

        if (index == N) {
            return;
        }

        dfs(index + 1, sum);
        dfs(index + 1, sum + num[index]);

    }
}
