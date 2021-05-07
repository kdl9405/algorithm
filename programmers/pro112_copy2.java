
/**
 * [카카오 인턴] 보석 쇼핑  
 */

import java.util.*;

public class pro112_copy2 {

    public static void main(String[] args) {
        String[] gems = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };
        solution(gems);
    }
  

    public static int[] solution(String[] gems) {
        
        int[] answer = new int[2];
       
        HashSet<String> gem = new HashSet<>();
        for(String g : gems){
            gem.add(g);
        }
        
        HashMap<String, Integer> cart = new HashMap<>();
        
        int min = Integer.MAX_VALUE;
        int from = 0;
        int to = 0;
        
        for(; to<gems.length; to++){

            cart.put(gems[to], cart.getOrDefault(gems[to],0)+1);

            if (gems[to].equals(gems[from])) {
                while (cart.get(gems[from]) > 1) {
                    cart.put(gems[from], cart.get(gems[from])-1);
                    from++;
                }
            }

            
            if(cart.size() == gem.size() && (to-from) < min){
                min = to-from;
                answer[0] = from+1;
                answer[1] = to+1;
            }
        }   
            
        return answer;
    }
}