package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 
    우체국

    BigInteger 사용 = > 틀림
*/
public class BJ2141_copy2 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        long[][] arr = new long[n + 1][2];

        BigInteger left = BigInteger.valueOf(0);
        BigInteger right = BigInteger.valueOf(0);
        BigInteger total = BigInteger.valueOf(0);

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

            right = right.add(BigInteger.valueOf(arr[i][0] * arr[i][1]));
            total = total.add(BigInteger.valueOf(arr[i][1]));
        }

        arr[0][0] = 0;
        arr[0][1] = 0;

        Arrays.sort(arr, (a1,a2)->{
            return (int) (a1[0] - a2[0]);
        });

        BigInteger min = right;
        long minPoint = 0;

        BigInteger rightP = total;
        BigInteger leftP = BigInteger.valueOf(0);
        BigInteger nowP = BigInteger.valueOf(0);

        for (int i = 1; i <= n; i++) {

            leftP = leftP.add(nowP);
            left = left.add(BigInteger.valueOf(arr[i][0] - arr[i - 1][0]).multiply(leftP));

            nowP = BigInteger.valueOf(arr[i][1]);

            right = right.subtract(BigInteger.valueOf(arr[i][0] - arr[i - 1][0]).multiply(rightP));
            rightP = rightP.subtract(BigInteger.valueOf(arr[i][1]));

            if (min.compareTo(left.add(right)) > 0) {
                min = left.add(right);
                minPoint = arr[i][0];
            }
        }

        System.out.println(minPoint);

    }
}
