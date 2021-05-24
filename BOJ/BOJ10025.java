package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    게으른 백곰
*/

public class BOJ10025 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] ice = new long[1000001];

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            ice[x] = g;
        }

        long max = 0;

        if (K * 2 >= 1000000) {

            for(long i : ice){
                max += i;
            }
            System.out.println(max);
        } else {
            long sum = 0;

            int from = 0;
            int to = 0;

            for (; to <= K * 2; to++) {
                sum += ice[to];
            }
            max = sum;

            for (; to <= 1000000; to++) {
                sum-=ice[from];
                sum+=ice[to];
                max = Math.max(max, sum);
                from++;
            }

            System.out.println(max);

        }

    }
}
