package programmers;

import java.util.*;

/* 
    [1차] 추석 트래픽

    1. 시작시간과 종료시간을 구함  => 시간 / (시작인지 종료인지)
    2. 순회조회하면서 동시간에 수행되는 메시지의 개수의 최대값을 갱신

*/

public class pro199 {

    public static void main(String[] args) {

        String[] lines = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};

        System.out.println(solution(lines));

    }

    public static int solution(String[] lines) {
        int answer = 1;

        timeTable = new ArrayList<>();

        for (String line : lines) {
            toTimeTable(line);
        }

        Collections.sort(timeTable, (t1, t2) -> {

            if (t1[0] == t2[0]) {
                return (int) (t1[1] - t2[1]);
            }

            return (int) (t1[0] * 100 - t2[0] * 100);
        });


        for(double[] t : timeTable){
            System.out.println(t[0] + " ~ " + t[1]);
        }

        double start = 0;
        double end = 0;
        for (int i = 0; i < timeTable.size(); i++) {
            int count = 0;

            if (timeTable.get(i)[1] == 1) {

                start = timeTable.get(i)[0];
                end = start + 1;

                System.out.println(start + " " + end);

                count++;

                for (int j = i + 1; j < timeTable.size(); j++) {
                    if (timeTable.get(j)[0] >= end) {
                        break;
                    }

                    System.out.println(timeTable.get(j)[0] +" > "+ end);

                    if (timeTable.get(j)[1] == 0) {
                        count++;
                    }
                }
                answer = Math.max(answer, count);

            }

        }

        return answer;
    }

    static List<double[]> timeTable;

    static void toTimeTable(String line) {

        String[] l = line.split(" ");

        String[] time = l[1].split(":");

        double end = (Integer.parseInt(time[0]) * 360) + (Integer.parseInt(time[1]) * 60) + Double.parseDouble(time[2]);

       // double start = end - Double.parseDouble(l[2].substring(0, l[2].length() - 1)) * 1000 +1;

        double start = ((end - Double.parseDouble(l[2].substring(0, l[2].length() - 1)))*1000+1)/1000.0;

        timeTable.add(new double[] { start, 0 });
        timeTable.add(new double[] { end, 1 });

        return;
    }

}
