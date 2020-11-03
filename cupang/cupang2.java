import java.util.*;

public class cupang2 {

    public static void main(String[] args) {

        String[] customers = { "10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24",
                "10/01 23:50:25 13", "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10" };

        System.out.println(solution(3, customers));

    }

    static int solution(int n, String[] customers) {
        int answer = 0;

        monToday();

        int[][] time = new int[n][2];
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < n; i++) {
            time[i][0] = i;
            time[i][1] = 0;
            count.put(i, 0);
        }

        for (String customer : customers) {
            Arrays.sort(time, (t1, t2) -> {

                if (t1[1] == t2[1]) {
                    return t1[0] - t2[0];
                }
                return t1[1] - t2[1];
            });

          
            int[] cusTime = toSeconds(customer);

            int i = 0;

            for (i = 0; i < n; i++) {

                if (time[i][1] <= cusTime[0]) {
                    time[i][1] = cusTime[1];
                    count.put(time[i][0], count.get(time[i][0]) + 1);
                    break;
                }
            }
            if (i == n) {
                time[0][1] = cusTime[1];
                count.put(time[0][0], count.get(time[0][0]) + 1);
            }

        }

        for(int i = 0 ; i<n; i++){
            answer = Math.max(answer, count.get(i));
        }

        return answer;

    }

    static int[] month_day = new int[13];

    static void monToday() {
        month_day[1] = 0;
        month_day[2] = 31;
        month_day[3] = 60;
        for (int i = 4; i <= 7; i++) {
            if (i % 2 == 0) {
                month_day[i] += month_day[i - 1] + 31;
            } else {
                month_day[i] += month_day[i - 1] + 30;
            }
        }
        month_day[8] = month_day[7] + 31;
        for (int i = 9; i <= 12; i++) {
            if (i % 2 == 0) {
                month_day[i] += month_day[i - 1] + 30;
            } else {
                month_day[i] += month_day[i - 1] + 31;
            }
        }
    }

    static int[] toSeconds(String customer) {

        int second[] = new int[2];

        String[] str = customer.split(" ");

        int month = Integer.parseInt(str[0].substring(0, 2));
        int day = Integer.parseInt(str[0].substring(3, 5));

        second[0] = (month_day[month] + day) * 60;

        String[] time = str[1].split(":");

        second[0] += (Integer.parseInt(time[0]) * 60) + Integer.parseInt(time[1]);
        second[0] = second[0] * 60 + Integer.parseInt(time[2]);
        second[1] = second[0] + (Integer.parseInt(str[2]) * 60);

        return second;
    }
}
