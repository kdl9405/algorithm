package BOJ;

/* 
    효율적인 해킹

*/

import java.io.*;
import java.util.*;

public class BOJ1325 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        link = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            link.add(new HashSet<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            link.get(B).add(A);        }

        count = new int[N+1];
        int max = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {


            int c = findCount(i);
            if (c > max) {
                sb = new StringBuilder();
                sb.append(i + " ");
                max = c;
            } else if (c == max) {
                sb.append(i + " ");
            }

        }

        System.out.println(sb.toString().trim());

    }

    static List<HashSet<Integer>> link;
    static boolean[] visit;
    static int[] count;

    static int findCount(int x) {

        visit[x] = true;
        if (count[x] != 0) {
            return count[x];
        }

        int c = 1;

        for (int slave : link.get(x)) {
            if (!visit[slave]) {
                visit[slave] = true;
                c += findCount(slave);
            }
        }

        return count[x] = c;
    }

}
