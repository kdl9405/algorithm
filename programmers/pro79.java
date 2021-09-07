package programmers;


/**
 * N으로 표현

 */

 import java.util.*;

public class pro79 {

    public static void main(String[] args) {
        
    }
    
    public static int solution(int N, int number) {
        int answer = -1;
        
        int[] num = new int[9];
        for(int i = 1; i<9 ;i++){
            num[i] = num[i-1]*10+N;
        }
        
        List<HashSet<Integer>> dp = new ArrayList<>(); // i개의 n으로 만들 수 있는 수 집합
        dp.add(new HashSet<>());
      
        
        
            loop:
            for(int i = 1; i<9; i++){ 
                dp.add(new HashSet<>());                
                dp.get(i).add(num[i]);
                
                for(int j = 1; j<i; j++){
                    for(int x : dp.get(j)){ 
                        for(int y : dp.get(i-j)){
                            if(y == 0){
                                continue;
                            }
                            dp.get(i).add(x+y);
                            dp.get(i).add(x-y);
                            dp.get(i).add(x*y);
                            dp.get(i).add(x/y);    
                        }
                        
                                               
                    }
                }               
                
                if(dp.get(i).contains(number)){
                    answer = i;
                   break loop; 
                }
                
            }
      
        
       
        
        return answer;
    }
    
    
}   