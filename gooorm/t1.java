package gooorm;

import java.io.*;
import java.util.*;

public class t1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i < k - 1) {
                arr[i][0] = i + 1 + n;
            } else {
                arr[i][0] = i + 1;
            }

            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        StringBuilder sb = new StringBuilder();
        for(int[] a : arr){
            if (a[0] > n) {
                sb.append((a[0]-n)+" ");
            }else{
                sb.append(a[0]+" ");
            }
        }

        System.out.println(sb.toString().trim());

    }

}
