package BOJ;

import java.util.*;
import java.io.*;

/* 
    가장 긴 증가하는 부분 수열 4
*/
public class BOJ14002 {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[N];

        int count = 0;
        for(int i = 1; i<N; i++){
            for(int j = 0; j<i; j++){
                if (A[i]>A[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    count = Math.max(count, dp[i]);
                }
            }
        }        
        
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        sb.append((count+1)+"\n");

        for(int i = N-1; i>=0; i--){
            if (dp[i] == count) {
                stack.push(A[i]);
                count--;
                if(count < 0){
                    break;
                }
            }
        }


        while (!stack.isEmpty()) {
            sb.append(stack.pop()+" ");
        }

        System.out.println(sb.toString());

    }
}
