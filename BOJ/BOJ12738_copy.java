package boj;

/*
 * 가장 긴 증가하는 부분 수열 3
 */

import java.io.*;
import java.util.*;

public class BOJ12738_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] arr = new long[n + 1];
        arr[0] = -1000000001;

        int answer = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            long a = Long.parseLong(st.nextToken());
            if (arr[index] < a) {
                if (answer >= index && arr[answer] < a) {
                    index = answer + 1;
                } else {
                    index = serchIndex(arr, answer, a);
                }
            } else {
                answer = Math.max(answer, index);
                index = serchIndex(arr, answer, a);
            }
            answer = Math.max(answer, index);
            arr[index] = a;
        }

        answer = Math.max(answer, index);

        System.out.println(answer);
    }

    static int serchIndex(long[] arr, int now, long a) {
        int min = 0;
        int max = now;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (arr[mid] == a) {
                return mid;
            } else if (arr[mid] > a) {
                now = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return now;
    }

}
