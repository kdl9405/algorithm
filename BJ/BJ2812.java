package BJ;

import java.io.*;
import java.math.BigInteger;
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

        Deque<Character> deque = new ArrayDeque<>();

        int count = 0;

        for(int i = 0; i<num.length(); i++){
       
            char x = num.charAt(i);
            
            while (k>0 && !deque.isEmpty() && deque.peekLast() < x) {
                deque.removeLast();
                k--;
            }
            deque.add(x);
            
        }

    //    while (deque.size()>n-k){
    //        deque.pollLast();
    //    }

        StringBuffer sb = new StringBuffer();
        while (deque.size()>k) {
            sb.append(deque.pollFirst());
        }

        // int result1 = Integer.parseInt(sb.toString());

        // String num2 = num.substring(k, n);
        // int result2 = 0;
        // if (num2.length() > 0) {
        //     result2 = Integer.parseInt(num.substring(k, n));
        // }

        System.out.println(sb.toString().trim());

    }   
}
