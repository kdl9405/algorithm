package programmers;

import java.util.*;

/* 
    무지의 먹방 라이브
*/

public class pro216 {

    public static void main(String[] args) {

        int[] food_times = { 1, 1, 1, 1 };
        long k = 4;

        System.out.println(solution(food_times, k));

    }

    public static int solution(int[] food_times, long k) {
        int answer = -1;

        HashMap<Integer, TreeSet<Integer>> foods = new HashMap<>();

        for (int i = 0; i < food_times.length; i++) {
            if (!foods.containsKey(food_times[i])) {
                foods.put(food_times[i], new TreeSet<>());
            }
            foods.get(food_times[i]).add(i);
        }

        int[] times = Arrays.stream(foods.keySet().toArray()).mapToInt(i -> (int) i).toArray();
        Arrays.sort(times);

        long remain = food_times.length;
        int before = 0;

        for (int time : times) {

            if (k > remain * (time - before)) {
                k -= (remain * (time - before));
                remain -= foods.get(time).size();
            } else if(k < remain * (time - before)){

                k %= remain;

                List<Integer> f = new LinkedList<>();

                for (int t : times) {
                    if (t < time) {
                        continue;
                    }

                    f.addAll(foods.get(t));
                }

                Collections.sort(f);

                answer = f.get((int) k) + 1;
                break;

            }else {
                k = 0;
                continue;
            }

            before = time;

        }

        return answer;
    }
}
