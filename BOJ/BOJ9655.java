package BOJ;

import java.util.*;
import java.io.*;

/* 
    돌 게임
*/

public class BOJ9655 {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n % 2== 1) {
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }
}
