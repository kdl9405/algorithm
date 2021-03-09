package BJ;

import java.io.*;

/**
 * BJ2108
 */
public class BJ2108 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] number = new int[8001];

        int sum = 0;
        int mid=0, mid_count=0;
        boolean mod_check = false;
        int mod=0, mod_count=0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;


        for (int i = 0; i < n; i++) {
            number[Integer.parseInt(br.readLine()) + 4000] += 1;
        }


        for(int i = 0; i< 8001; i++){

            if(number[i] != 0){

                if(mod_count < number[i]){
                   mod_count = number[i];
                   mod = i - 4000;
                   mod_check = true;
                } else if(mod_count == number[i] && mod_check==true){
                    mod = i - 4000;
                    mod_check= false;
                }

                if(i-4000>max){
                    max = i-4000;
                }

                if(i-4000<min){
                    min = i-4000;
                }
                
                while (number[i] != 0) {

                    mid_count +=1;

                    if(mid_count == (n/2)+1){
                        mid = i-4000;
                    }

                    sum = sum+i-4000;

                    number[i] --;                    
                }
            }
        }

        System.out.println((int)Math.round((double)sum/n));
        System.out.println(mid);
        System.out.println(mod);
        System.out.println(max-min);
    }
}