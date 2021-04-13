package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11053 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());

        int[] A = new int[l];
        int[] dp = new int[l];


        StringTokenizer st = new StringTokenizer(br.readLine());

        if (l == 1) {
            System.out.println(1);
            System.out.close();
        }

        for (int i = 0; i < l; i++) {
            A[i] = Integer.parseInt(st.nextToken());          
        }

        for(int i = 0; i< l; i++){
            dp[i] = 1;
            for(int j = 0; j<i; j++){
                if (A[j] < A[i] && dp[i] < dp[j]+1) {
                    dp[i] = dp[j]+1;
                }
            }
        }

        int max = 0;

        for(int d : dp){
            if (max < d) {
                max = d;
            }
        }       
        System.out.println(max);

    }
}
