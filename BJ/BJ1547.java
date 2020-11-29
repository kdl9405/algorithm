package BJ;
import java.util.*;

public class BJ1547 {
    public static void main(String[] args){
     
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        int p = 1;
        
        for(int i = 0; i<t; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            if(x == p){
                p = y;                
            }else if(y == p){
                p = x;
            }
        }
        
        System.out.println(p);
        
    }
}
