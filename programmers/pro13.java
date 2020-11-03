
import java.util.*;

public class pro13 {

    public static void main(String[] args) {
        int[][] jobs = { { 0,10 }, { 2,3 }, { 9, 3 } };

        System.out.println(solution(jobs));

    }

    static int solution(int[][] jobs) {
        int answer = 0;

        

        Arrays.sort(jobs, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }

        });

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        boolean[] input = new boolean[jobs.length];

        int time = 0;
        int out = 0;
        int in = 0;
        int count = 0;

        while (count < jobs.length) {

            for (int i = 0; i < jobs.length; i++) {
                if (jobs[i][0] <= time && input[i] == false) {
                    heap.offer(jobs[i][1]);
                    input[i] = true;
                }

            }

            if (heap.isEmpty()) {
                for (int i = 0; i < jobs.length; i++) {
                    if (input[i] == false) {
                        time = jobs[i][0];
                        break;
                    }
                }
            } else {
                out = heap.poll();
                time += out;

                for (int i = 0; i < jobs.length; i++) {
                    if (jobs[i][1] == out && input[i] == true && jobs[i][0] != Integer.MAX_VALUE) {

                        in = jobs[i][0];

                        jobs[i][0] = Integer.MAX_VALUE;
                        break;
                    }
                }
                answer = time - in + answer;
                count++;

            }
        }
        return answer / count;
    }
}
