import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class cupang3 {

    public static void main(String[] args) {
        int[] score ={2000000000,22,20,10,5,3,2,1};

        System.out.println(solution(3, score));

    }

    

    static int solution(int k, int[] score){
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> wrong = new HashSet<>();
         
        for(int i = 0; i<score.length-1; i++){
            int dif = score[i] - score[i+1];
            map.put(dif, map.getOrDefault(dif, 0)+1);
        }

        for(int d : map.keySet()){
            if (map.get(d) >= k) {
                wrong.add(d);
            }
        }


        boolean[] right = new boolean[score.length];
        Arrays.fill(right, true);

        for(int i = 0; i<score.length-1; i++){
            int dif = score[i] - score[i+1];
           if (wrong.contains(dif)) {
               right[i] = false;
               right[i+1] = false;
           }
        }

        for(int i = 0; i<score.length; i++){
            if(right[i] == true){
                answer++;
            }
        }


        return answer;
    }
    
}
