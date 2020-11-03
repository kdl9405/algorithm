import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// 입국심사

public class pro35 {

    public static void main(String[] args) {

        int[] times = { 7, 10 };

        System.out.println(solution(6, times));

    }

    static long solution(int n, int[] times) {
        Arrays.sort(times);

        long min = times[0];
        long max = times[times.length-1] * n;
        long t = 0;
        long sum;

        long answer = max;


        while (min<=max) {
            sum = 0;
            t = (min+max)/2;

            for(int time : times){
                sum += t/time;
            }

            if(sum >= n){
                if (t < answer) {   
                    answer = t;
                }
                max = t -1;
            }
            else{
                min = t + 1;
            }

        }
        return answer;
    }
}
