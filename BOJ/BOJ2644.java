package boj;

/*
 * 촌수계산
 */

import java.io.*;
import java.util.*;

public class BOJ2644 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());

        root = new int[N + 1];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            root[child] = parent;
        }

        distance = -1;
        parents = new HashMap<>();

        setRoot(a, 0);
        findDistance(b, 0);

        System.out.println(distance);

    }

    static int distance;
    static int[] root;
    static HashMap<Integer, Integer> parents;

    static void setRoot(int child, int d) {

        parents.put(child, d);

        if (root[child] == 0) {
            return;
        }

        setRoot(root[child], d + 1);

    }

    static void findDistance(int child, int d) {

        if (parents.containsKey(child)) {
            distance = parents.get(child) + d;
            return;
        }

        if (root[child] == 0) {
            return;
        }

        findDistance(root[child], d + 1);
    }
}
