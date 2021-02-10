package programmers;

import java.util.Arrays;

/* 
    광고 삽입

    41.9
*/

public class pro133_copy {
    public static void main(String[] args) {
        String play_time = "99:59:59";
        String adv_time = "25:00:00";
        String[] logs = { "69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00" };

        System.out.println(solution(play_time, adv_time, logs));
    }

    static int[][] logTime;

    public static String solution(String play_time, String adv_time, String[] logs) {

        logTime = new int[logs.length * 2][4]; // index: 0=시작,끝 1=시간 2=before~시간까지 구간의 시청자 수 3 =before~시간까지 구간의 시청시간

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
                return l1[0] - l2[0];
            } else {
                return l1[1] - l2[1];
            }
        });

        int count = 0;
        int before = 0;
        for (int[] log : logTime) {
            log[2] = count;
            log[3] = (log[1] - before) * count;
            if (log[0] == 0) {
                count++;
            } else {
                count--;
            }
            before = log[1];
        }

   

        int play = stringToTime(play_time);
        int adv = stringToTime(adv_time);
        int start = 0;
        int end = adv;

        int answerTime = 0;
        int answer = 0;
        i = -1;
        while (i < logTime.length - 1) {
            
            if(i != -1 && logTime[i][0] == 1){
                i++;
                continue;
            }

            int checkTime = 0;

            for (int j = i + 1; j < logTime.length; j++) {
                if (logTime[j][1] > end) {
                    checkTime += (end - before) * logTime[j][2];
                   
                    break;
                }
                checkTime += logTime[j][3];
                before = logTime[j][1];
            }

            if (checkTime > answerTime) {
                answerTime = checkTime;
                answer = start;
            }


            i++;
            start = logTime[i][1];
            end = start + adv;
            if(end > play){
                break;
            }
          //  end = Math.min(end, play);
            before = start;
        }

        

        return timeToString(answer);
    }

    static int stringToTime(String s) {
        String[] str = s.split(":");

        int time = ((Integer.parseInt(str[0])) * 3600) + ((Integer.parseInt(str[1])) * 60) + Integer.parseInt(str[2]);

        return time;
    }

    static String timeToString(int time) {

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

        String h = time+ "";
        if (h.length() == 1) {
            h = "0" + h;
        }

        return h + ":" + m + ":" + s;
    }

}
