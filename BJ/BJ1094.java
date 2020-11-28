package BJ;

import java.util.*;

public class BJ1094 {
    
    public static void main(String[] args){
        
        int[] stick = new int[7];
        stick[0] = 64;
        for(int i = 1; i<7; i++){
            stick[i] = stick[i-1]/2;
        }
        
        Scanner sc = new Scanner(System.in);
        
        int x = sc.nextInt();
        
        int answer = 0;
        
        for(int i = 0; i<7; i++){
            if(x>=stick[i]){
                x-=stick[i];
                answer++;

                if(x == 0){
                    break;
                }
            }            
        }        
        
        System.out.println(answer);
    }
}