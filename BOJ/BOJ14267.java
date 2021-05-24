package BOJ;

import java.io.*;
import java.util.*;

/*
    회사 문화 1

    java 11: 612ms
*/
public class BOJ14267 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] boss = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            boss[i] = Integer.parseInt(st.nextToken());
        }

        int[] point = new int[n + 1];

        int i, w;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            i = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            point[i] += w;

        }

        StringBuilder sb = new StringBuilder();
        sb.append("0 ");

        for(i = 2; i<=n; i++){
            point[i] += point[boss[i]];
            sb.append(point[i]+" ");
        }

        System.out.println(sb.toString());
    }

}
