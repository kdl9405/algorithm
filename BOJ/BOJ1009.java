package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
    분산처리
*/
public class BOJ1009 {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int x = 1;

            for(int i = 0; i<b; i++){
                x = x*a%10;
            }

            if (x == 0) {
                x = 10;
            }

            sb.append(x+"\n");
        }

        System.out.println(sb.toString().trim());
    }
}
