
/**
 * [카카오 인턴] 보석 쇼핑  
 * 
 */

import java.util.*;

public class pro112 {

    public static void main(String[] args) {
        String[] gems = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };
        solution(gems);
    }

    static int[] solution(String[] gems) {
        int[] answer = new int[2];
        answer[0] = 1;
        answer[1] = gems.length;

        HashSet<String> set = new HashSet<>();
        for (String s : gems) {
            set.add(s);
        }

        int x = 1;
        HashMap<String, Integer> hash = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < gems.length; i++) {
            hash.put(gems[i], hash.getOrDefault(gems[i], 0) + 1);
            queue.add(gems[i]);

            while (true) {
                if (hash.get(queue.peek()) > 1) {
                    hash.put(queue.peek(), hash.get(queue.peek()) - 1);
                    queue.poll();
                    x++;
                } else {
                    break;
                }
            }

            if (hash.size() == set.size() && queue.size() < answer[1]) {
                answer[1] = queue.size();
                answer[0] = x;
            }
        }

        answer[1] += answer[0] - 1;

        return answer;
    }
}