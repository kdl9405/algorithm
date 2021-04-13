package BOJ;

import java.util.*;
import java.io.*;

/* 
    1학년 
    시간초과
*/

public class BOJ5557_copy {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        num = new int[n - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n - 1; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        result = Integer.parseInt(st.nextToken());

        count = 0;

        calculate(num[0], 1);

        System.out.println(count);
    }

    static int[] num;
    static int result;
    static long count;

    static void calculate(int sum, int index) {
        if (index == num.length) {
            if (sum == result) {
                count++;
            }
            return;
        }

        if (sum < 0) {
            return;
        }

        if (sum > 20) {
            return;
        }

        calculate(sum + num[index], index+1);
        calculate(sum - num[index], index+1);

    }
}
