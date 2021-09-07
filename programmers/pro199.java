package programmers;

import java.util.*;

/* 
    [1차] 추석 트래픽

    1. 시작시간과 종료시간을 구함  => 시간 / (시작인지 종료인지)
    2. 순회조회하면서 동시간에 수행되는 메시지의 개수의 최대값을 갱신

*/

public class pro199 {

    public static void main(String[] args) {

        String[] lines = { "2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s" };

        System.out.println(solution(lines));

    }

    public static int solution(String[] lines) {
        int answer = 1;

        double[][] timeTabe = maekTable(lines);

        Arrays.sort(timeTabe, (t1,t2) ->{

            if (t1[0] == t2[0] ) {
                return (t1[1] - t2[1] > 0)? 1 : -1;
            }

            return (t1[0] - t2[0] > 0)? 1 : -1;
        });


        for(double[] time : timeTabe){
            System.out.println(time[0] + " ~ "+ time[1]);
        }


        int count = 0;

        for(int i = 0; i<timeTabe.length; i++){

            double start = timeTabe[i][1];
            double end = start+1;
            count = 0;

            System.out.println("time = " +start +" ~ "+ end);

            for(int j = 0; j<timeTabe.length; j++){

                if (timeTabe[j][0] >= end) {
                    break;
                }

                if (timeTabe[j][0] < end && timeTabe[j][1] >= start) {

                    System.out.println("+++ " + j);
                    count++;
                }

            }

            answer =Math.max(answer, count);
        }
       
        return answer;
    }

    static double[][] maekTable(String[] lines) {
        double[][] table = new double[lines.length][2];

        for (int i = 0; i < lines.length; i++) {
            String[] line = lines[i].split(" ");

            String[] time = line[1].split(":");
            double end = Double.parseDouble(time[0]) * 60;
            end = (end + Double.parseDouble(time[1])) * 60;
            end += Double.parseDouble(time[2]);

            double start = end - (Double.parseDouble(line[2].replaceAll("s", "")));

            table[i][0] = (start*1000+1)/1000;
            table[i][1] = end;
        }

        return table;
    }

}
