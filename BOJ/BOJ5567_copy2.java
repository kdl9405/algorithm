package BOJ;

/* 
    결혼식 
*/

import java.io.*;
import java.util.*;

public class BOJ5567_copy2 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ5567_copy2().solution();
    }

    private void solution() throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[][] friends = new boolean[n + 1][n + 1];

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friends[a][b] = true;
            friends[b][a] = true;
        }

        int count = 0;
        boolean[] isChecked = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {

            if (!friends[1][i]) {
                continue;
            }

            if (!isChecked[i]) {
                isChecked[i] = true;
                count++;
            }

            for (int j = 2; j <= n; j++) {
                if (!friends[i][j] || isChecked[j]) {
                    continue;
                }
                isChecked[j] = true;
                count++;
            }
        }

        System.out.println(count);

    }

}
