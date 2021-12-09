package BOJ;

/* 
    수들의 합 2

*/

import java.io.*;
import java.util.*;

public class BOJ2003 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        br.close();

        long sum = 0;
        int l = 0;

        int count = 0;
        for (int i = 0; i < N; i++) {

            A[i] = Integer.parseInt(st.nextToken());

            while (sum > M && l < i) {
                sum -= A[l];
                l++;

                if (sum == M) {
                    count++;
                }
            }

            sum += A[i];

            if (sum == M) {
                count++;
            }
        }

        for(; l<N; l++){
            sum-= A[l];
            if (sum == M) {
                count++;
            }else if(sum < M){
                break;
            }
        }

        System.out.println(count);

    }
}
