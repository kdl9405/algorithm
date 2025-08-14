package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class pro259 {
    public int solution(int[] topping) {

        Map<Integer, Integer> toppingMap = new HashMap<>();

        for (int t : topping) {
            toppingMap.put(t, toppingMap.getOrDefault(t, 0) + 1);
        }

        int answer = 0;
        Set<Integer> chulsoo = new HashSet<>();
        for (int t : topping) {
            chulsoo.add(t);

            if (toppingMap.get(t) == 1) {
                toppingMap.remove(t);
            } else {
                toppingMap.put(t, toppingMap.get(t) - 1);
            }

            if (chulsoo.size() == toppingMap.keySet().size()) {
                answer++;
            }
        }

        return answer;
    }
}
