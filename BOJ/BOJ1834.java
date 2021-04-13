package BOJ;

import java.util.*;

public class BOJ1834 {
    
    public static void main(String[] args){
        long answer = 0;
        
        Scanner sc = new Scanner(System.in);
        
        long n = sc.nextInt();       
       
        for(int i = 1; i<n; i++){
            answer += ((n+1)*i);
        }
        
        System.out.println(answer);        
    }
}
