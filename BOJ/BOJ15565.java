package BOJ;

import java.io.*;
import java.util.*;

/* 
    귀여운 라이언
*/

public class BOJ15565 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int min = n + 1;
        int sum = 0;

        while (true) {
            if (sum >= k && left <= right) {
                min = Math.min(min, right - left);
                if (arr[left] == 1) {
                    sum--;
                }
                left++;
            } else if (right == n) {
                break;
            } else {
                if (arr[right] == 1) {
                    sum++;
                }
                right++;
            }
        }

        if (min == n + 1) {
            min = -1;
        }
        System.out.println(min);

    }
}
