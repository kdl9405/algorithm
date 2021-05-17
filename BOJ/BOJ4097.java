package BOJ;

import java.io.*;

/* 
    수익 
*/
public class BOJ4097 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int max,sum;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            max = Integer.MIN_VALUE;
            sum = 0;

            while (n-- > 0) {
                int num = Integer.parseInt(br.readLine());
                sum+= num;
                max = Math.max(max, sum);
                if (sum<0) {
                    sum = 0;
                }
            }

            sb.append(max+"\n");
           
        }

        System.out.println(sb.toString());
    } 
    
}
