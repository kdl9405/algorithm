package boj;

import java.util.*;
import java.io.*;


/*
 * 성냥개비
 * 
 * 언제 풀었는지 기억안남..
 */
public class BOJ3687_copy {

    static StringBuilder sb, result = new StringBuilder();
    static int min;
    static int max;
    static int[] minarr;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = new int[] {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
        minarr = new int[101];

        Arrays.fill(minarr, -1);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            sb = new StringBuilder();

            findMin(n);

            result.append(sb + " ");

            sb = new StringBuilder();

            findMax(n);

            result.append(sb + "\n");

        }

        System.out.println(result);
    }

    static void findMax(int n) {
        if (n == 0) {
            return;
        }
        int temp = 0;
        int temp_max = 0;
        max = 0;

        for (int i = 0; i < 10; i++) {
            if (n < num[i]) {
                continue;
            }
            if (sb.length() == 0 && i == 0) {
                continue;
            }
            temp_max = (n - num[i]) / 2;
            if (max <= temp_max) {
                max = temp_max;
                temp = i;
            }
        }

        sb.append(temp);
        findMax(n - num[temp]);

    }

    static void findMin(int n) {
        if (n == 0) {
            return;
        }

        int temp = 0;
        int temp_min = 0;
        min = Integer.MAX_VALUE;

        for (int i = 0; i < 10; i++) {
            if (sb.length() == 0 && i == 0) {
                continue;
            }
            if (n < num[i]) {
                continue;
            }

            temp_min = getMin(n - num[i]);

            if (temp_min == 0) {
                continue;
            }
            if (min > temp_min) {
                min = temp_min;
                temp = i;
            }
        }
        sb.append(temp);
        findMin(n - num[temp]);
    }



    static int getMin(int i) {
        if (i == 0) {
            return -1;
        }
        if (i == 1) {
            return 0;
        }
        if (i <= 7) {
            return 1;
        }

        if (minarr[i] != -1) {
            return minarr[i];
        }

        minarr[i] = Integer.MAX_VALUE;
        for (int j = 0; j < 10; j++) {
            if (i - num[j] < 2) {
                continue;
            }
            minarr[i] = Math.min(minarr[i], getMin(i - num[j]) + 1);
        }
        return minarr[i];

    }



}
