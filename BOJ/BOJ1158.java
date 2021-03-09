package BJ;

import java.util.*;

/* 
    요세푸스 문제
*/

public class BJ1158 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i<=n; i++){
            queue.offer(i);
        }

        StringBuilder sb= new StringBuilder();
        while (!queue.isEmpty()) {

            for(int i = 1; i<k; i++){
                queue.offer(queue.poll());
            }
            sb.append(queue.poll()).append(", ");

        }

        String result = sb.toString();
        result = result.substring(0, result.length()-2);
        result = "<"+result+">";
        System.out.println(result);
    }
}
