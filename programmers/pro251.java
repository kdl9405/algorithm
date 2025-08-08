package programmers;

import java.util.*;

public class pro251 {

    public int solution(int k, int[] tangerine) {

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int t : tangerine) {
            countMap.put(t, countMap.getOrDefault(t, 0) + 1);
        }

        List<Integer> sizeList = new ArrayList<>();

        for (Integer key : countMap.keySet()) {
            sizeList.add(countMap.get(key));
        }

        Collections.sort(sizeList, (x, y) -> {
            return y - x;
        });

        int answer = 0;

        int count = 0;
        for (Integer size : sizeList) {
            count += size;
            answer++;
            if (count >= k)
                break;
        }

        return answer;
    }
}
