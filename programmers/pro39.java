package programmers;

import java.util.*;

public class pro39 {
    
    public static void main(String[] args) {

        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        System.out.println(solution(participant, completion));
        
    }

    static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();
        for(String s : completion){
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        
        for(String s :  participant){
            if (!map.containsKey(s)) {
                answer = s;
                break;
            }else{
                if (map.get(s) >0) {
                    map.replace(s, map.get(s)-1);
                }else{
                    answer = s;
                    break;
                }
            }
        }

        return answer;
    }
}

