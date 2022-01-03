package BOJ;

/* 
    트리
*/

import java.io.*;
import java.util.*;

public class BOJ4803 {

    public static void main(String[] args) throws IOException {

     
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = 1;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            tree = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                tree[i] = i;
            }

            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                a = findTree(a);
                b = findTree(b);

                if (a > b) {
                    union(b, a);
                } else {
                    union(a, b);
                }
            }

            int count = 0;
            for (int i = 1; i <= n; i++) {

                int x = findTree(i);

                if (tree[x] == i) {
                    count++;
                }
            }

            sb.append("Case ").append(T++);
            switch (count) {
                case 0:
                    sb.append(": No trees.\n");
                    break;

                case 1:
                    sb.append(": There is one tree.\n");
                    break;
                default:
                    sb.append(": A forest of ").append(count).append(" trees.\n");
                    break;
            }

        }
        System.out.println(sb.toString().trim());
    }

    static int[] tree;

    static int findTree(int x) {
        if (tree[x] == x) {
            return x;
        }

        return tree[x] = findTree(tree[x]);
    }

    static void union(int a, int b) {

        if (a == b) {
            tree[a] = 0;
            return;
        }

        tree[b] = a;

    }
}
