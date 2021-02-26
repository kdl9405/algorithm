package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
    블로그2
*/

public class BJ20365 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String q = br.readLine();

        int blue = 0;
        int red = 0;
        
        if (n>1) {

            if (q.charAt(0) == 'B') {
                blue++;
            }else{
                red++;
            }

            for(int i = 1; i<n; i++){
                if (q.charAt(i) != q.charAt(i-1)) {
                    if (q.charAt(i) == 'B') {
                        blue++;
                    }else{
                        red++;
                    }
                }
            }
        }

        System.out.println(Math.min(blue, red)+1);

    }
}
