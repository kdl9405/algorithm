package BOJ;

/* 
    준오는 최종인재야!!

*/

import java.io.*;
import java.util.*;

public class BOJ14657 {

    static int N, T;
    static List<List<int[]>> links;
    static boolean[] solved;
    static int cnt, day, root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        links = new ArrayList<>();
        links.add(new ArrayList<>());
        for (int i = 1; i <= N; i++) {
            links.add(new ArrayList<>());
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            links.get(a).add(new int[] { b, c });
            links.get(b).add(new int[] { a, c });
        }

        cnt = 1;
        root = 0;
        day = 0;

        solved = new boolean[N + 1];
        dfs(1, 1, 0);

        Arrays.fill(solved, false);
        dfs(root, 1, 0);

        day = day % T == 0 ? day / T : day / T + 1;
        System.out.println(day);

    }

    static void dfs(int now, int c, int t) {

        if (cnt < c) {
            root = now;
            cnt = c;
            day = t;
        } else if (cnt == c && day > t) {
            root = now;
            day = t;

        }

        solved[now] = true;

        for (int[] next : links.get(now)) {
            if (!solved[next[0]]) {
                dfs(next[0], c + 1, t + next[1]);
            }
        }

    }
}
