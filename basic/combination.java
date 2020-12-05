package basic;

import java.util.*;

public class combination {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

        System.out.println(nCr(n, r));

        int[] num = { 1, 2, 3, 4, 5 };

        nCrGroup(num, r);
        System.out.println(sb);

    }

    static int nCr(int n, int r) {

        if (r == 1) {
            return n;
        }
        if (r == 0 || r == n) {
            return 1;
        }

        return nCr(n - 1, r - 1) + nCr(n - 1, r);

    }

    static boolean[] visit;
    static StringBuilder sb;
    static int[] arr;

    static void nCrGroup(int[] n, int r) {
        visit = new boolean[n.length];
        sb = new StringBuilder();
        arr = new int[r];

        dfs(n, r, 0, 0);

    }

    static void dfs(int[] n, int r, int depth, int x) {
        if (depth == r) {
            for (int i : arr) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = x; i < n.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = n[i];
                dfs(n, r, depth + 1, i + 1);
                visit[i] = false;
            }
        }

    }

}
