package BJ;

import java.util.*;
import java.io.*;

/* 
    파일 합치기 3
*/
public class BJ13975 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for(int i = 0; i<k; i++){
                pq.offer(Integer.parseInt(st.nextToken()));              
            }

            int cost = 0;

            while (true) {
                PriorityQueue<Integer> temp = new PriorityQueue<>();

                while (!pq.isEmpty()) {
                    int x = pq.poll();
                    if (pq.isEmpty()) {
                        temp.add(x);
                    }else {
                        int y = pq.poll();
                        cost += (x+y);
                        temp.add(x+y);
                    }
                }

                if (temp.size() <= 1) {
                    sb.append(cost).append("\n");
                    break;
                }else{
                    pq.addAll(temp);
                }
            }            
        }

        System.out.println(sb.toString().trim());
    }

}
