package programmers;

import java.util.Arrays;

/* 
    광고 삽입
*/

public class pro133 {
    public static void main(String[] args) {
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:25:50-00:48:29", "00:40:31-01:00:00", "01:37:44-02:02:30", "01:30:59-01:53:29"};

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

        int count = 1;
        int before = logTime[0][1];
        /*
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
*/
        for(i = 1; i<logTime.length; i++){            
            logTime[i][2] = count;
            logTime[i][3] = logTime[i-1][3]+((logTime[i][1]-before) * count);
            if (logTime[i][0] == 0) {
                count++;
            }else{
                count--;
            }
            before = logTime[i][1];
        }

        for(int[] log : logTime){
            System.out.println(log[0] +" > "+ timeToString(log[1])+" > "+ log[2]+" > "+timeToString(log[3]));
        }

        int play = stringToTime(play_time);
        int adv = stringToTime(adv_time);
        int start = 0;
        int end = adv;
        int max_time = 0;
        for(i = 0; i<logTime.length; i++){
            if (logTime[i][1] == end ) {
                max_time = logTime[i][3];
                break;
            }else if(logTime[i][1] > end){
                max_time = logTime[i][3] - ((logTime[i][1]-end)*logTime[i][2]);
                break;
            }
        }

        int answerTime = 0;
        for(i = 0; i<logTime.length-1; i++){
            start = logTime[i][1];
            end = start+adv;
            if (end > play) {
                end = play;
            }
            for(int j = i+1; j<logTime.length; j++){
                if (logTime[j][1] == end) {
                    int time = logTime[j][3] - logTime[i][3];
                    if (time > max_time) {
                        max_time = time;
                        answerTime = start;
                    }
                    break;
                }else if (logTime[j][1] > end) {
                    int time = logTime[j][3] - logTime[i][3] - ((logTime[j][1]-end)*logTime[j][2]);
                    if (time > max_time) {
                        max_time = time;
                        answerTime = start;
                    }
                    break;
                }
            }
        }

        System.out.println(timeToString(max_time));

        return timeToString(answerTime);

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

        String h = time + "";
        if (h.length() == 1) {
            h = "0" + h;
        }

        return h + ":" + m + ":" + s;
    }

}
