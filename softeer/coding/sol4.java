package softeer.coding;

import java.util.*;
import java.io.*;

public class sol4 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });

        root = new int[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {

            root[i] = i;

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {

                int d = Integer.parseInt(st.nextToken());
                if (i == j) {
                    continue;
                }

                pq.add(new int[] { i, j, d });
            }
        }

        int answer = 0;

        while (!pq.isEmpty()) {
            int[] line = pq.poll();

            int a = findRoot(line[0]);
            int b = findRoot(line[1]);

            if (a==b) {
                continue;
            }

            answer+=line[2];
            
            root[b] = a;

        }

        System.out.println(answer);

    }

    static int[] root;

    static int findRoot(int x) {

        if (root[x] == x) {
            return x;
        }

        return root[x] = findRoot(root[x]);
    }

}
