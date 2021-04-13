package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 
    A → B
*/
public class BOJ16953 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        HashSet<Integer> visit = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();

        int count = 1;
        queue.offer(a);

        loop:
        while (true) {
            count++;

            Queue<Integer> temp = new LinkedList<>();

            while (!queue.isEmpty()) {
                int now = queue.poll();

                if (now > b) {
                    continue;
                }

                int oper1 = now*2;
                int oper2 = now*10+1;

                if (oper1 == b || oper2 == b) {
                    break loop;
                }

                if (oper1 < b && !visit.contains(oper1)) {
                    visit.add(oper1);
                    temp.offer(oper1);
                }

                if (oper2 < b && !visit.contains(oper2)) {
                    visit.add(oper2);
                    temp.offer(oper2);
                }                
            }

            System.out.println(count + " "+ temp);

            if (temp.isEmpty()) {
                count = -1;
                break;
            }

            queue.addAll(temp);
        }

        System.out.println(count);
    }
}
