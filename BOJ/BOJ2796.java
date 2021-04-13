package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2796 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int sum = 0;

        int[] num = new int[n];
        
        st = new StringTokenizer(br.readLine()," ");

        for(int i = 0; i<n; i++){
            num [i] = Integer.parseInt(st.nextToken());
        }


        for(int x = 0; x<n-2; x++){
            for(int y = x+1; y < n-1; y++){
                for(int z = y+1; z < n; z++){

                    if (num[x]+num[y]+num[z] >sum && num[x]+num[y]+num[z]<=m) {
                        
                        sum = num[x]+num[y]+num[z];
                    }
                }
            }
        }

        System.out.println(sum);

    }
}