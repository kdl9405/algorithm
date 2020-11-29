package BJ;


import java.util.*;

public class BJ1731 {
    
    public static void main(String[] args){
        int answer = 0;
        
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        int[] arr = new int[t];
        
        for(int i= 0; i<t; i++){
            arr[i] = sc.nextInt();            
        }
        
        if(arr[1] - arr[0] == arr[t-1] - arr[t-2]){
            answer = arr[t-1] + (arr[1] - arr[0]);
        }else{
            answer =arr[t-1] * (arr[1] / arr[0]);
        }         
        
        System.out.println(answer);
    }
}
