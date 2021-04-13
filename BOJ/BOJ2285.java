package BOJ;

import java.util.*;
import java.io.*;

/* 
    우제국
*/
public class BOJ2285 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        long[][] arr = new long[n][2];
        long total = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());

            total += arr[i][1];
        }

        Arrays.sort(arr, (a1, a2) -> {
            if (a1[0] == a2[0]) {
                return (int) (a1[1] - a2[1]);
            }
            return (int) (a1[0] - a2[0]);
        });

        long count = 0;
        for (int i = 0; i < n; i++) {
            count += arr[i][1];
            if (count > total/2) {
                System.out.println(arr[i][0]);
                break;
            }
        }

    }
}
