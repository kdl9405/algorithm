package BOJ;

import java.io.*;
import java.util.*;

/*
    두 용액
*/

public class BOJ2470 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int l = 0;
        int r = n - 1;

        long[] result = new long[2];
        long min = Long.MAX_VALUE;
        long sum = 0;
        while (l < r) {

            sum = arr[l] + arr[r];

            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                result[0] = arr[l];
                result[1] = arr[r];
            }

            if (sum > 0) {
                r--;
            }else if(sum < 0){
                l++;
            }else {
                break;
            }
        }

        System.out.println(result[0]+" "+ result[1]);
    }
}
