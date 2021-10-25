package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16937_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        int[][] paper = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            paper[i][0] = Integer.parseInt(st.nextToken());
            paper[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(paper, (p1, p2) -> {
            int a = p1[0] * p1[1];
            int b = p2[0] * p2[1];

            return b - a;
        });

        int max = 0;

        for (int i = 0; i < paper.length - 1; i++) {

            int x = 0; // 1번 그대로

            if (H - paper[i][0] >= 0 && W - paper[i][1] >= 0) {
                x = paper[i][0] * paper[i][1];
            }

            int y = 0; // 1번 회전

            if (H - paper[i][1] >= 0 && W - paper[i][0] >= 0) {
                y = paper[i][0] * paper[i][1];
            }

            if (x <= max / 2 && y <= max / 2) {
                continue;
            }

            for (int j = i + 1; j < paper.length; j++) {

                if (x != 0) {

                    if ((H >= paper[j][0] && W >= paper[i][1] + paper[j][1])
                            || (H >= paper[j][1] && W >= paper[i][1] + paper[j][0])
                            || (H >= paper[i][0] + paper[j][0] && W >= paper[j][1])
                            || (H >= paper[i][0] + paper[j][1] && W >= paper[j][0])) {

                        max = Math.max(max, x + paper[j][0] * paper[j][1]);

                    }

                }

                if (y != 0) {

                    if ((H >= paper[j][0] && W >= paper[i][0] + paper[j][1])
                            || (H >= paper[j][1] && W >= paper[i][0] + paper[j][0])
                            || (H >= paper[i][1] + paper[j][0] && W >= paper[j][1])
                            || (H >= paper[i][1] + paper[j][1] && W >= paper[j][0])) {
                        max = Math.max(max, y + paper[j][0] * paper[j][1]);
                    }

                }

            }
        }

        System.out.println(max);
    }
}
