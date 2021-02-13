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
        for (int i = 0; i < weight.length; i++) {
            weight[i] = Integer.parseInt(weights[i]);
        }

        int[] test = new int[Integer.parseInt(br.readLine())];
        String[] tests = br.readLine().split(" ");
        for (int i = 0; i < test.length; i++) {
            test[i] = Integer.parseInt(tests[i]);
        }

        boolean[] possible = new boolean[15001];
        boolean[] temp = new boolean[15001];
        
        possible[0] = true;
        for(int w : weight){
            for(int i = 0; i<=15000; i++){
                if (possible[i]) {
                    int left = Math.abs(w-i);
                    int right = Math.abs(w+i);
                    
                    temp[left] = true;
                    temp[right] = true;
                    temp[w] = true;
                }
            }

            for(int i = 0; i<=15000; i++){
                possible[i] = temp[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int t : test){
           
            if (t<=15000 && possible[t]) {
                sb.append("Y ");
            }else{
                sb.append("N ");
            }
        }


        System.out.println(sb.toString().trim());

    }

   
}
