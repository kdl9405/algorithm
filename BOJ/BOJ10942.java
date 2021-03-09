package BJ;

import java.io.*;
import java.util.StringTokenizer;

public class BJ10942 {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st= new StringTokenizer(br.readLine());

        int[] num = new int[n+1];

        for(int i = 1; i<=n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (m-- >0) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            boolean check = true;
        
            while (s<=e) {


                if (num[s] != num[e] ) {
                    check = false;
                    break;
                }
                s++;
                e--;
            }

            if (check) {
                sb.append(1+"\n");
            }else{
                sb.append(0+"\n");
            }
        }

        System.out.println(sb);
    }
}
