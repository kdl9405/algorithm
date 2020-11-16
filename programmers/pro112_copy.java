
/**
 * [카카오 인턴] 보석 쇼핑  
 * 시간초과
 */

import java.util.*;

public class pro112_copy {

    public static void main(String[] args) {
        String[] gems = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };
        solution(gems);
    }
  

    static int[] solution(String[] gems) {
        int[] answer = new int[2];
        answer[0] = 1;
        answer[1] = gems.length;

        HashMap<String, Integer> hash = new HashMap<>();
        for (int i = 0; i < gems.length; i++) {
            hash.put(gems[i], hash.getOrDefault(gems[i], 0) + 1);
        }
        HashSet<String> set = new HashSet<>();
        set.addAll(hash.keySet());

        for (int i = 0; i < gems.length - set.size(); i++) {
            HashSet<String> temp = new HashSet<>();
            for (int j = i; j < gems.length; j++) {
                temp.add(gems[j]);
                if (temp.size() == set.size()) {
                    if (answer[1] - answer[0] > j - i) {
                        answer[0] = i + 1;
                        answer[1] = j + 1;
                    }
                }
            }
        }

        System.out.println(answer[0] +" " + answer[1]);

        return answer;
    }
}