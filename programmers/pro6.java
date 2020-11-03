
import java.util.*;

public class pro6 {
    
    public static void main(String[] args) {

        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};


        System.out.println(solution(clothes));
        
    }
    public static int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();

              
        for(int i = 0; i<clothes.length; i++){

            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
            
        }

        for(String i : map.keySet()){ //저장된 key값 확인

            answer = answer*(map.get(i)+1);
        }

        answer -=1;
 
        return answer;
    }
}
