package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/* 
    우체국

    틀림
*/
public class BOJ2141_copy {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][2];

        int left = 0;
        int right = 0;
        int total = 0;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

            right += (arr[i][0] * arr[i][1]);
            total += arr[i][1];
        }

        int min = right;
        int minPoint = 0;

        int rightP = total;
        int leftP = 0;
        int nowP = 0;

        for (int i = 1; i <= n; i++) {

            leftP += nowP;
            left += (arr[i][0] - arr[i - 1][0]) * leftP;

            nowP = arr[i][1];

            right -= (arr[i][0] - arr[i - 1][0]) * rightP;
            rightP -= arr[i][1];

            if (min > left + right) {
                min = left + right;
                minPoint = i;
            }
        }

        System.out.println(minPoint);

    }
}