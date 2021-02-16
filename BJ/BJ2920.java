package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
    음계

*/
public class BJ2920 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        String answer = "mixed";

        if (s.equals("1 2 3 4 5 6 7 8")) {
            answer = "ascending";
        }

        if (s.equals("8 7 6 5 4 3 2 1")) {
            answer = "descending";
        }

        System.out.println(answer);
    }
}
