package BJ;

import java.io.*;


/* 
    양팔저울     
*/

public class BJ2629 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] weight = new int[Integer.parseInt(br.readLine())];
        String[] weights = br.readLine().split(" ");
        for(int i = 0; i<weight.length; i++){
            weight[i] = Integer.parseInt(weights[i]);
        }

        int t = Integer.parseInt(br.readLine());
        

        

    }

    
}
