package BJ;

import java.io.*;
import java.util.*;

/* 
    강의실 배정
*/
public class BJ11000 {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] classes = new int[n][2];
        
        for(int i = 0; i<n ;i++){
            st = new StringTokenizer(br.readLine());
            classes[i][0] = Integer.parseInt(st.nextToken());
            classes[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(classes, (c1, c2)->{
            if (c1[0] == c2[0]) {
                return c1[1]-c2[1];
            }else{
                return c1[0] - c2[0];
            }
        });

        PriorityQueue<Integer> room = new PriorityQueue<>();

        int count =0;

        for(int i = 0; i<n; i++){
            if (room.isEmpty()){
                count++;
                room.add(classes[i][1]);
            }else {
                if (room.peek() <= classes[i][0]) {
                    room.poll();
                }else{
                    count++;
                }
                room.add(classes[i][1]);
            }
        }

        System.out.println(count);
    }
}
