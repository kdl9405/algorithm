package BJ;

import java.io.*;
import java.util.*;

/* 
    크게 만들기
    
*/
public class BJ2812 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String num = br.readLine();

        Deque<Integer> deque = new ArrayDeque<>();

        int count = 0;

        for(int i = 0; i<num.length(); i++){
       
            int x = Integer.parseInt(Character.toString(num.charAt(i)));
            if (deque.isEmpty()) {
                deque.addLast(x);
            }else{

                if (count == k) {
                    deque.addLast(x);
                }else{
                    int y = deque.peekLast();
                    
                    if (y<x) {
                        deque.pollLast();
                        count++;
                    }
                    deque.addLast(x);
                }
            }
        }

       while (deque.size()>n-k){
           deque.pollLast();
       }

        StringBuffer sb = new StringBuffer();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }

        System.out.println(sb.toString());

    }   
}
