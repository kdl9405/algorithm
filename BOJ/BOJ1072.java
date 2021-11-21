package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
    게임
*/
public class BOJ1072 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());

        long Z = Y * 100 / X;

        if (Z >= 99) {
            System.out.println(-1);
        }

        System.out.println(Z);

        long min = 1;
        long max = 1000000000L;

        long answer = -1;

        while (min <= max) {
            long mid = (min + max) / 2;

            long z = ((Y + mid) * 100) / (X + mid);

            if (z > Z) {
                max = mid - 1;
                answer = mid;
            } else {
                min = mid + 1;
            }

        }

        System.out.println((int)answer);

    }
}
