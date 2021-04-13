package BOJ;

import java.io.*;
import java.util.*;

/* 
    N과 M (9)
    284ms
*/
public class BOJ15663 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        num = new int[n];
        arr = new int[m];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        start = new boolean[10];

        Arrays.sort(num);
        set = new HashSet<>();
        result = new StringBuilder();

        nPr(0, m);

        System.out.println(result.toString().trim());

    }

    static int[] num;
    static int[] arr;
    static boolean[] visit;
    static boolean[] start;
    static HashSet<String> set;
    static StringBuilder result;

    static void nPr(int depth, int r) {
        if (depth == r) {
            StringBuffer sb = new StringBuffer();
            for (int a : arr) {
                sb.append(a).append(" ");
            }
            String s = sb.toString().trim();

            if (!set.contains(s)) {
                result.append(s).append("\n");
                set.add(s);
            }

            return;
        }

        for (int i = 0; i < num.length; i++) {

            if (depth == 0) {
                if (start[num[i]]) {
                    continue;
                } else {
                    start[num[i]] = true;
                }
            }

            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = num[i];
                nPr(depth + 1, r);
                visit[i] = false;
            }
        }
    }

}
