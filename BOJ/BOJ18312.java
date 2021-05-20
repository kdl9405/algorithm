package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
    시각 
*/

public class BOJ18312 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int s = 0;

        for (int i = 0; i < 60; i++) {
            if (i % 10 == k || i / 10 == k) {
                s++;
            }
        }

        int count = 0;

        for (int i = 0; i <= n; i++) {
            if (i % 10 == k || i / 10 == k) {
                count += (3600);
            } else {
                for (int j = 0; j < 60; j++) {
                    if (j % 10 == k || j / 10 == k) {
                        count += 60;
                    } else {
                        count += s;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
