package programmers;

/**
 * pro231
 */

import java.util.*;

public class pro231 {

    public static void main(String[] args) {

        new pro231().test();

    }

    void test() {
        int[] fees = { 180, 5000, 10, 600 };
        String[] records = { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
                "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };

        int[] answer = solution(fees, records);

        for (int a : answer) {
            System.out.println(a);
        }
    }

    public int[] solution(int[] fees, String[] records) {

        estimateAllTime(records);

        estimateAllFee(fees);

        int[] answer = new int[feeList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = feeList.get(i)[1];
        }

        return answer;
    }

    Map<Integer, Integer> totalTime;
    List<int[]> feeList;

    void estimateAllTime(String[] records) {

        Map<Integer, Integer> inTime = new HashMap<>();
        totalTime = new HashMap<>();

        for (String record : records) {

            String[] r = record.split(" ");

            int car = Integer.parseInt(r[1]);

            if (r[2].equals("IN")) {
                inTime.put(car, getTime(r[0]));
            } else {
                totalTime.put(car, totalTime.getOrDefault(car, 0)+(getTime(r[0]) - inTime.get(car)));
                inTime.remove(car);
            }
        }

        int maxTime = 23 * 60 + 59;
        for (int car : inTime.keySet()) {
            totalTime.put(car, totalTime.getOrDefault(car, 0) + (maxTime - inTime.get(car)));
        }

    }

    int getTime(String time) {

        String[] t = time.split(":");

        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

    void estimateAllFee(int[] fees) {

        feeList = new ArrayList<>();

        for (int car : totalTime.keySet()) {

            feeList.add(new int[] { car, getFee(totalTime.get(car), fees) });
        }

        Collections.sort(feeList, (f1, f2) -> {
            return f1[0] - f2[0];
        });
    }

    int getFee(int time, int[] fees) {
        int fee = fees[1];

        if (time > fees[0]) {
            time -= fees[0];
            fee += ((time / fees[2]) * fees[3]);
            if (time % fees[2] != 0) {
                fee += fees[3];
            }
        }

        return fee;
    }

}