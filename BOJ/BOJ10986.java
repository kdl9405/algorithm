package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    나머지 합 
*/

public class BOJ10986 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] num = new int[n + 1];
        int[] remain = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            num[i] = (num[i - 1] + Integer.parseInt(st.nextToken())) % m;
            remain[num[i]]++;
        }

        long answer = remain[0];
        for (int i = 0; i < m; i++) {
            if (remain[i] > 1) {
                answer += (long) remain[i] * ((long) remain[i] - 1) / 2;
            }
        }

        System.out.println(answer);

    }
}
