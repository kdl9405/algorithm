package BOJ;
import java.util.*;

public class BOJ1568 {
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = 0;
        int c = 0;
        
        while(n>0){
            c++;
            k++;
           
            if(n<k){
                k=1;
            }            
            n-=k;            
        }
        
        System.out.println(c);
        
    }
}
