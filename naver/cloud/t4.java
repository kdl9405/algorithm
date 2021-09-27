package naver.cloud;

import java.util.*;

public class t4 {

    public static void main(String[] args) {

        int[][] info = { { 1, 5 }, { 3, 5 }, { 7, 8 }};

        System.out.println(solution(info));

    }

    public static int[] solution(int[][] info) {
        List<Integer> answer = new ArrayList<>();

        Arrays.sort(info, (a, b) -> {
            return a[0] - b[0];
        });

        int[][] time = new int[86400][2];
        for (int i = 0; i < 86400; i++) {
            time[i][0] = i;
        }

        int count = 0;
        int s = 0;
        int t = info[0][0];

        while (t < 86400) {

            for (; s < info.length; s++) {
                if (info[s][0] == t) {
                    count++;
                } else {
                    break;
                }
            }

            time[t][1] = count;
            t++;
        }

        Arrays.sort(info, (a, b) -> {
            return a[1] - b[1];
        });

        count = 0;
        s = 0;
        t = info[0][1];

        while (t < 86400) {

            for (; s < info.length; s++) {
                if (info[s][1] < t) {
                    count++;
                } else {
                    break;
                }
            }
            time[t][1] -= count;
            t++;
        }

        Arrays.sort(time, (a,b)->{
            if(a[1] == b[1]){
                return a[0]-b[0];
            }
            return b[1] - a[1];
        });

        answer.add(time[0][0]);
        for(int i = 1; i<time.length; i++){
            if (time[i-1][1] > time[i][1]) {
                break;
            }
            answer.add(time[i][0]);
        }

        System.out.println(answer);
        

        return Arrays.stream(answer.toArray()).mapToInt(i -> (int)i).toArray();
    }
}
