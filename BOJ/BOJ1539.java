package BOJ;

/* 
    중량제한
*/

import java.io.*;
import java.util.*;

public class BOJ1539 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<int[]> bridge = new ArrayList<>();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            bridge.add(new int[] { A, B, C });

        }

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        Collections.sort(bridge, (a, b) -> {
            return b[2] - a[2];
        });

        root = new int[N+1];

        for (int[] b : bridge) {

            int x = findRoot(b[0]);
            int y = findRoot(b[1]);
            if (x== y) {
                continue;
            }

            root[y] = x;

            if(findRoot(from) == findRoot(to)){
                System.out.println(b[2]);
                break;
            }
        }
    }

    static int[] root;

    static int findRoot(int x) {
        if (root[x] == 0) {
            return x;
        }

        return root[x] = findRoot(root[x]);
    }

}
