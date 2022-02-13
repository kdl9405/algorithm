package BOJ;

/* 
    Contact
*/

import java.io.*;

public class BOJ1013 {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String pattern = "(100+1+|01)+";

        int T = Integer.parseInt(br.readLine());
       
        StringBuilder answer = new StringBuilder();
        while (T-- > 0) {
            
            if (br.readLine().matches(pattern)) {
                answer.append("YES\n");
            }else{
                answer.append("NO\n");
            }
        }

        System.out.println(answer.toString().trim());
    }



}
