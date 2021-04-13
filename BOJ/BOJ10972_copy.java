package BOJ;

import java.io.*;
import java.util.*;

/* 
    다음 순열

    시간초과
*/
public class BOJ10972_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            stack.push(Integer.parseInt(st.nextToken()));
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(stack.pop());
        while (!stack.isEmpty()) {

            int x = stack.pop();

            PriorityQueue<Integer> temp = new PriorityQueue<>();
            temp.addAll(pq);
            int min = -1;
            while (!temp.isEmpty()) {
                if (temp.peek() > x) {
                    min = temp.poll();
                    break;
                } else {
                    temp.poll();
                }
            }

            pq.add(x);

            if (min != -1) {
                pq.remove(min);
                stack.add(min);
                break;
            }
        }

        if (stack.isEmpty())

        {
            System.out.println(-1);
        } else {
            // String s = stack.toString().replaceAll(", ", "0").replaceAll("[^0-9]", "").replaceAll("0", " ");

            String s = "";
            while (!stack.isEmpty()) {
            s = stack.pop()+" "+s;
            }

            StringBuffer sb = new StringBuffer();
            sb.append(s);

            while (!pq.isEmpty()) {
                sb.append(pq.poll()).append(" ");
            }

            System.out.println(sb.toString().trim());
        }

    }
}
