package programmers;

import java.util.HashMap;
import java.util.Map;

public class pro253 {

    public int solution(String[] want, int[] number, String[] discount) {

        int answer = 0;

        Map<String, Integer> wantMap = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        Map<String, Integer> discountMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
        }

        if (wantMap.equals(discountMap)) {
            answer++;
        }

        for (int i = 10; i < discount.length; i++) {

            if (discountMap.get(discount[i - 10]) == 1) {
                discountMap.remove(discount[i - 10]);
            } else {
                discountMap.put(discount[i - 10], discountMap.get(discount[i - 10]) - 1);
            }

            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);

            if (wantMap.equals(discountMap)) {
                answer++;
            }
        }

        return answer;
    }
}
