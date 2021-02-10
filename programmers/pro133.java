package programmers;

import java.util.Arrays;

/* 
    광고 삽입

    정리 필요
*/

public class pro133 {
    public static void main(String[] args) {
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:25:50-00:48:29", "00:40:31-01:00:00", "01:37:44-02:02:30", "01:30:59-01:53:29"};

        System.out.println(solution(play_time, adv_time, logs));


    }

    static long[][] logTime;

    public static String solution(String play_time, String adv_time, String[] logs) {

        logTime = new long[logs.length * 2][4]; // index: 0=시작,끝 1=시간 2=before~시간까지 구간의 시청자 수 3 =before~시간까지 구간의 시청시간

        int i = 0;
        for (String log : logs) {
            String[] str = log.split("-");
            // logTime[i][0] = 0;
            logTime[i][1] = stringToTime(str[0]);
            i++;

            logTime[i][0] = 1;
            logTime[i][1] = stringToTime(str[1]);
            i++;
        }

        Arrays.sort(logTime, (l1, l2) -> {
            if (l1[1] == l2[1]) {
                return (int)(l1[0] - l2[0]);
            } else {
                return (int)(l1[1] - l2[1]);
            }
        });

        int count = 1;
        long before = logTime[0][1];
        logTime[0][2] = 1;
       
        for(i = 1; i<logTime.length; i++){   
            logTime[i][3] = logTime[i-1][3]+((logTime[i][1]-before) * count);

            if (logTime[i][0] == 0) {
                count++;
            }else{
                count--;
            }         
            logTime[i][2] = count;
            
            before = logTime[i][1];
        }

        // for(long[] log : logTime){
        //     System.out.println(log[0] +" > "+ timeToString(log[1])+" > "+ log[2]+" > "+timeToString(log[3]));
        // }

        long[] viewer = new long[(int)stringToTime(play_time)+1];

        for(i = 0; i<logTime.length-1; i++){
            for(int j = (int)logTime[i][1]; j<(int)logTime[i+1][1]; j++){
                viewer[j] = (int)logTime[i][2];
            }
        }



        for(int j = 1; j<viewer.length; j++){
           viewer[j] +=viewer[j-1];
            
        }
      
        // System.out.println("------------------------------");
        // for(long[] log : logTime){
        //     System.out.println(timeToString(viewer[(int)log[1]]) +"  "+ timeToString((int)log[1]));

        // }

        // System.out.println(viewer[(int)stringToTime("00:25:49")]);

        long play = stringToTime(play_time);
        long adv = stringToTime(adv_time);
        long max_time = viewer[(int)adv];
        long answer_time = 0;
        // for(long[] log : logTime){
        //     if(log[0] == 1 || log[1] == 0){
        //         continue;
        //     }

        //     int end = (int)(log[1]+adv);
        //     if (end> (int)play) {
        //         end = (int)play;
        //     }
        //     if (max_time < viewer[(int)end-1] - viewer[(int)log[1]-1]) {
        //         max_time = viewer[(int)end-1] - viewer[(int)log[1]-1];
        //         answer_time = log[1];
        //     }
        // }

        max_time = viewer[(int)adv-1];
        for(int j = 1; j+adv<viewer.length; j++){
            long end = j+adv;
            if (end > play) {
                end = play;
            }
            long time = viewer[(int)end-1] - viewer[j-1];
            if (time > max_time) {
                max_time = time;
                answer_time = j;
            }
        }

        // long temp = viewer[(int)stringToTime("01:37:44")-1] - viewer[(int)stringToTime("01:30:59")-1];
        // System.out.println( timeToString(temp));

        return timeToString(answer_time);

    }

    static long stringToTime(String s) {
        String[] str = s.split(":");

        long time = ((Integer.parseInt(str[0])) * 3600) + ((Integer.parseInt(str[1])) * 60) + Integer.parseInt(str[2]);

        return time;
    }

    static String timeToString(long time) {

        String s = time % 60 + "";
        if (s.length() == 1) {
            s = "0" + s;
        }
        time /= 60;

        String m = time % 60 + "";
        if (m.length() == 1) {
            m = "0" + m;
        }
        time /= 60;

        String h = time + "";
        if (h.length() == 1) {
            h = "0" + h;
        }

        return h + ":" + m + ":" + s;
    }

}
