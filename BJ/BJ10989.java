package BJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BJ10989 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] number = new int [10000];

        for(int i =0; i<n; i++){
            number[Integer.parseInt(br.readLine())-1] +=1;
        }

        for(int i = 0; i<10000; i++){
            if(number[i] != 0){
                while (number[i] != 0) {

                    sb.append(i+1).append("\n");

                    number[i] -=1;
                }
            }
        }

        System.out.println(sb);
    }
}