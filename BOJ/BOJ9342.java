package BOJ;

import java.io.*;

/* 
    염색체 
*/

public class BOJ9342 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String regex = "^[A-F]?A+F+C+[A-F]?$";

      
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();

            if (s.matches(regex)) {
                sb.append("Infected!\n");
            }else {
                sb.append("Good\n");
            }
        }

        System.out.println(sb.toString());
    }

    
}
