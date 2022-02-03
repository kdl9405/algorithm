package BOJ;

/* 
    1998년생인 내가 태국에서는 2541년생?!
*/

import java.io.*;

public class BOJ18108 {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int year = Integer.parseInt(br.readLine());

        System.out.println(year-543);
    }
}
