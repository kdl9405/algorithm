package programmers;

import java.util.*;

/*
 * 코딩테스트 연습 연습문제 시소 짝꿍
 * 
 * https://school.programmers.co.kr/learn/courses/30/lessons/152996
 */
public class pro268 {

    public long solution(int[] weights) {

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int w : weights) {
            countMap.put(w, countMap.getOrDefault(w, 0) + 1);
        }

        int[] weightList = countMap.keySet().stream().mapToInt(i -> (int) i).toArray();

        weightMap = new HashMap<>();

        long answer = 0;

        for (int i = 0; i < weightList.length - 1; i++) {
            for (int j = i + 1; j < weightList.length; j++) {
                if (isExist(weightList[i], weightList[j])) {
                    answer += (1L * countMap.get(weightList[i]) * countMap.get(weightList[j]));
                }
            }
        }

        for (int w : weightList) {
            int c = countMap.get(w);
            if (c > 1) {
                answer += 1L * c * (c - 1) / 2;
            }

        }

        return answer;
    }

    private Map<Integer, Set<Integer>> weightMap;

    private boolean isExist(int a, int b) {

        if (!weightMap.containsKey(a)) {
            Set<Integer> weightSet = new HashSet<>();
            weightSet.add(a * 2);
            weightSet.add(a * 3);
            weightSet.add(a * 4);

            weightMap.put(a, weightSet);
        }

        if (!weightMap.containsKey(b)) {
            Set<Integer> weightSet = new HashSet<>();
            weightSet.add(b * 2);
            weightSet.add(b * 3);
            weightSet.add(b * 4);

            weightMap.put(b, weightSet);
        }

        for (Integer w : weightMap.get(a)) {
            if (weightMap.get(b).contains(w))
                return true;
        }

        return false;
    }

}
