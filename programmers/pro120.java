package programmers;

import java.util.Arrays;

/**
 * 
 * 
 * 셔틀버스
 */
public class pro120 {

    public static void main(String[] args) {

        String[] timetable = {"09:10", "09:09", "08:00"};

        System.out.println(solution(2, 10, 2, timetable));
    }

    static String solution(int n, int t, int m, String[] timetable) {
        int answerTime = 0;

        int[] realtimetable = new int[timetable.length];
        for(int i = 0; i<timetable.length; i++){
            String[] str = timetable[i].split(":");
            realtimetable[i] = (Integer.parseInt(str[0])*60) + Integer.parseInt(str[1]);
        }

        Arrays.sort(realtimetable);

        boolean[] boarding = new boolean[realtimetable.length];

        int startTime = -1;
        int endTime = 540;

        int x = 0;
        for(int i = 1; i<=n; i++){

            int count = 0;

            while (true) {
                if (count == m) {
                    break;
                }
                if (x >= realtimetable.length  || realtimetable[x] > endTime) {
                    break;
                }
                boarding[x] = true;
                x++;
                count++;   
            }

            if (i == n) {
                if (count < m) {
                    answerTime = endTime;
                }else{
                    answerTime = realtimetable[x-1]-1;
                }
            }

            startTime = endTime+1;
            endTime += t;
        }

        String hour = Integer.toString(answerTime/60);
        String min = Integer.toString(answerTime%60);

        if (hour.length() <2) {
            hour = "0"+hour;
        }
        if (min.length() <2) {
            min = "0"+min;
        }
            

        return hour+":"+min;

    }
}