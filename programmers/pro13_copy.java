
import java.util.*;

public class pro13_copy {

    public static void main(String[] args) {
        int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 }, { 1, 8 } };

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
        boolean[] visit = new boolean[jobs.length];

        int time = jobs[0][0];
        int count = 0;
        int in = 0;
        int out = 0;

        for(int i = 0; i<jobs.length; i++){
            if (jobs[i][0] > time) {
                break;
            }
            heap.offer(jobs[i][1]);
            visit[i] = true;

        }        

        while (true) {

            out = heap.poll();

            System.out.println("out = " +out);

            time += out;

            System.out.println("time = " +time);


            for (int i = 0; i < jobs.length; i++) {
                if (jobs[i][1] == out && visit[i] == true){

                    in = jobs[i][0];
                    answer = answer + time - in;

                    System.out.println("answer = " +answer);

                    break;
                }
            }

            count++;

            System.out.println("count = " +count);


            if (count == jobs.length) {
                break;
            }


            for (int i = 0; i < jobs.length; i++) {
                if (jobs[i][0] > time) {
                    break;
                }

                if (visit[i] == true) {
                    continue;
                }else{
                    heap.offer(jobs[i][1]);
                    System.out.println("offer = " +jobs[i][1]);
    
                    visit[i] = true;
                }              

            }

        }

         return answer/jobs.length;
    }

}
