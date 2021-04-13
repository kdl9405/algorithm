package BOJ;

import java.io.*;
import java.util.*;

/*
    이중 우선순위 큐
    시간초과
*/

public class BOJ7662_copy {
    public static void main(String[] args) throws NumberFormatException, IOException {
        

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());


        for(int i = 0; i<t; i++){

            PriorityQueue<Integer> queue = new PriorityQueue<>();
            PriorityQueue<Integer> reversequeue = new PriorityQueue<>(Collections.reverseOrder());

            int count = Integer.parseInt(br.readLine());

            for(int j = 0; j<count; j++){
                String[] operation = br.readLine().split(" ");
                if (operation[0].equals("I")) {
                    queue.add(Integer.parseInt(operation[1]));
                    reversequeue.add(Integer.parseInt(operation[1]));
                    
                }else if(!queue.isEmpty()){
                    if (operation[1].equals("1")) {
                        int max = reversequeue.poll();
                        queue.remove(max);
                    }else{
                        int min = queue.poll();
                        reversequeue.remove(min);
                    }
                }
            }

            if (queue.isEmpty()) {
                sb.append("EMPTY");
            }else {
                sb.append(reversequeue.poll()+" "+queue.poll());
            }
            sb.append("\n");            
        }


        System.out.println(sb.toString());
    }
}
