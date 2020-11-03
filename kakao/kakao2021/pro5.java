package kakao.kakao2021;

import java.util.Arrays;

public class pro5 {
    
    public static void main(String[] args) {

        String play_time = "99:59:59";
        String adv_time =  "25:00:00";
        String[] logs = {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};

        System.out.println(solution(play_time, adv_time, logs));
        
    }
    static String solution(String play_time, String adv_time, String[] logs) {

        if (play_time.equals(adv_time)) {
            return "00:00:00";             
        }

        int advtime = Integer.parseInt(adv_time.replaceAll(":",""));

        String answer = "";

        Arrays.sort(logs, (l1,l2)->{
            return Integer.parseInt((l1.substring(0, 7).replaceAll(":", ""))) - Integer.parseInt((l2.substring(0, 7).replaceAll(":", "")));
        });

        int[][] logtime = new int[logs.length][2];
        for(int i= 0; i<logs.length; i++){
            logtime[i][0] = Integer.parseInt(logs[i].substring(0, 8).replaceAll(":", ""));
            logtime[i][1] = Integer.parseInt(logs[i].substring(9, 17).replaceAll(":", ""));
        }        

        int starttime = logtime[0][0];
        int outtime = logtime[0][1];

        int[] time = new int[3];

        int timeCount = 0;
        
        for(int i = 1; i<logtime.length; i++){
            if (logtime[i][0] < outtime) {

                if (timerP(starttime, advtime) < timerM(starttime, outtime)) {
                    timeCount+= timerP(advtime, timerM(logtime[i][0], outtime));
                    starttime = timerM(advtime, outtime)/3600 + ((timerM(advtime, outtime)%3600)/60) + ((timerM(advtime, outtime)%3600)%60) ;
                }

                timeCount+= timerP(advtime, timerM(logtime[i][0], outtime));
            }else{

                if (timeCount > time[2]) {
                    time[0] = starttime;
                    time[1] = outtime;
                    time[2] = timeCount;
                }
                outtime = logtime[i][1];
                timeCount = 0;
            }
        }

        // if (time[2] == 1) {
        //     return "00:00:00";             
        // }else{

            String temp = Integer.toString(time[2]);
            
            answer = temp.substring(0,2)+":"+temp.substring(2,4)+":"+temp.substring(4,6);
        
    

        return answer;
    }

    static int timerM(int starttime , int outtime){

        int start = (starttime/10000*3600) + ((starttime%10000)/100*60) + (starttime%100);
        int out = (outtime/10000*3600) + ((outtime%10000)/100*60) + (outtime%100);

        return out - start;
    }
    static int timerP(int starttime , int outtime){

        int start = (starttime/10000*3600) + ((starttime%10000)/100*60) + (starttime%100);
        int out = (outtime/10000*3600) + ((outtime%10000)/100*60) + (outtime%100);

        return out + start;
    }
}
