package BOJ;

import java.io.*;
import java.util.*;

/* 
    집합의 표현
*/
public class BOJ1717 {

    static int[] group;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        group = new int[n + 1];
        // for(int i = 1; i<=n; i++){
        // group[i] = i;
        // }
        Arrays.fill(group, -1);

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            String test = st.nextToken();

            int a = findGroup(Integer.parseInt(st.nextToken()));
            int b = findGroup(Integer.parseInt(st.nextToken()));

            if (test.equals("0")) {
                group[b] = a;
            } else {
                if (a == b) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }
        }

        System.out.println(sb.toString());

    }

    static int findGroup(int n) {

        if (group[n] == -1) {
            return group[n] = n;
        } else if (group[n] == n) {
            return n;
        } else {
            return group[n] = findGroup(group[n]);
        }
    }
}
