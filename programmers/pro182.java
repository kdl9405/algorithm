package programmers;

import java.util.*;

/* 
    지형 편집

    정확성 2개, 효율성 XXX
*/
public class pro182 {
    static HashMap<Integer, Integer> amount;

    public long solution(int[][] land, int P, int Q) {
       
        amount = new HashMap<>();
        int max = 0;
        int min = Integer.MAX_VALUE;
        int len = land.length;
        len *= len;
        long total = 0;
        
        for(int i[] : land){
            for(int j : i){
                max = Math.max(max, j);
                min = Math.min(min, j);
                amount.put(j, amount.getOrDefault(j, 0)+1);
                total += j;
            }
        }
        
        long count = (len*max)-total;
        long cost = (count)*P;  
        
     //   System.out.println(max +" " + min);
        
        for(max-- > min){            
            
            long temp = cost;
            if(amount.containsKey(max+1)){
                temp += amount.get(max+1)*Q;
                temp -= (len-amount.get(max+1))*P;
                
                amount.put(max, amount.getOrDefault(max,0)+amount.get(max+1));
                
                if(temp < 0){
                    temp = cost-temp;
                }
            }
           
          //  System.out.println(max +" " +cost);
            
        //    if(cost > min){
          //     break;
          //  }
            
            if(temp<cost){
              cost = temp;
            }
            
        }
        
        return cost;      
        
    }
}