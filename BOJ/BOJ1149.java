package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {

    static int[][] house;
    static int[][] color;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        house = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        color = new int[n][3];

        color[0][0] = house[0][0];
        color[0][1] = house[0][1];
        color[0][2] = house[0][2];

        int min = Math.min(dp(n - 1, 0), (Math.min(dp(n - 1, 1), dp(n - 1, 2))));

        System.out.println(min);
    }

    static int dp(int n, int colorN) {

        if (color[n][colorN] == 0) {

            if (colorN == 0) {
                color[n][0] = Math.min(dp(n - 1, 1), dp(n - 1, 2)) + house[n][0];
            } else if (colorN == 1) {
                color[n][1] = Math.min(dp(n - 1, 0), dp(n - 1, 2)) + house[n][1];
            } else {
                color[n][2] = Math.min(dp(n - 1, 0), dp(n - 1, 1)) + house[n][2];

            }
        }

        return color[n][colorN];

    }

}
