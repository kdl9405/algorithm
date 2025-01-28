package boj;

import java.io.*;
import java.util.*;

/*
 * ABCDE
 */
public class BOJ13023 {

    public static void main(String[] args) throws IOException {

        new BOJ13023().soluiotn();
    }

    void soluiotn() throws IOException {

        init();

        for (int i = 0; i < N; i++) {
            dfs(i, 0);
        }

        System.out.println(isExisted ? 1 : 0);
    }

    int N;
    List<List<Integer>> friends;
    boolean isExisted;
    boolean[] visited;

    void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        friends = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            friends.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friends.get(a).add(b);
            friends.get(b).add(a);
        }

        isExisted = false;
        visited = new boolean[N];

    }

    void dfs(int x, int cnt) {

        if (cnt == 4) {
            isExisted = true;
            return;
        }

        if (isExisted) {
            return;
        }

        visited[x] = true;

        for (int next : friends.get(x)) {
            if (!visited[next]) {
                dfs(next, cnt + 1);
            }
        }

        visited[x] = false;

    }
}
