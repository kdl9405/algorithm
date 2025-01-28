package boj;

/*
 * 친구 네트워크
 */

import java.io.*;
import java.util.*;

public class BOJ4195 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int F = Integer.parseInt(br.readLine());

            HashMap<String, Integer> friendsId = new HashMap<>();
            int id = 1;
            root = new int[F * 2 + 1];
            group = new int[F * 2 + 1];
            Arrays.fill(group, 1);

            while (F-- > 0) {

                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                friendsId.putIfAbsent(a, id++);
                friendsId.putIfAbsent(b, id++);

                int aRoot = findRoot(friendsId.get(a));
                int bRoot = findRoot(friendsId.get(b));

                if (aRoot != bRoot) {
                    root[bRoot] = aRoot;
                    group[aRoot] += group[bRoot];

                }

                sb.append(group[aRoot]).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    static int[] root;
    static int[] group;

    static int findRoot(int a) {
        if (root[a] == 0) {
            return root[a] = a;
        }
        if (root[a] == a) {
            return a;
        }

        return root[a] = findRoot(root[a]);
    }

}
