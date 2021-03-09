package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ2164 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i<=n; i++){
            queue.offer(i);
        }

        while (queue.size() >1) {
            
            queue.poll();
            queue.offer(queue.poll());
            
        }

        System.out.println(queue.poll());
    }
}
