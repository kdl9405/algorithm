package BOJ;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11047 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];

        for(int i = 0; i<n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        int x = 0;
        for(int i = n-1; i>=0; i--){
            if (coin[i] <= k) {
                x = i;
                break;
            }
        }

        int count = 0;

        while (k > 0) {
            
            count += k/coin[x];
            k = k%coin[x];

            x--;
            
        }

        System.out.println(count);
    }
}
