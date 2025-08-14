package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class pro258 {

class Solution {
    public static int[] solution(int[] fees, String[] records) {

        HashMap<Integer, Integer> totalTime = new HashMap<>();
        HashMap<Integer, Integer> start = new HashMap<>();

        for (String record : records) {

            String[] r = record.split(" ");

            int car = Integer.parseInt(r[1]);
            int atTime = Integer.parseInt(r[0].substring(0, 2)) * 60 + Integer.parseInt(r[0].substring(3, 5));

            if (r[2].equals("IN")) {
                start.put(car, atTime);
            } else {

                int t = atTime - start.get(car);
                totalTime.put(car, totalTime.getOrDefault(car, 0) + t);
                start.remove(car);
            }
        }

        int end = 23 * 60 + 59;

        for (Integer k : start.keySet()) {
            totalTime.put(k, totalTime.getOrDefault(k, 0) + (end - start.get(k)));
        }

        int[] cars = Arrays.stream(totalTime.keySet().toArray()).mapToInt(i -> (int) i).toArray();
        Arrays.sort(cars);

        int[] answer = new int[cars.length];

        for (int i = 0; i < cars.length; i++) {

            int time = totalTime.get(cars[i]);
            int money = fees[1];

            time -= fees[0];

            if (time > 0) {
                money += (time / fees[2]) * fees[3];
                if (time % fees[2] > 0) {
                    money += fees[3];
                }
            }

            answer[i] = money;

        }

        return answer;
    }

}
