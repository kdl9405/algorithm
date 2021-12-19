package BOJ;

/* 
    히스토그램 
*/

import java.io.*;
import java.util.*;

public class BOJ1725 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] height = new int[N];
        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();

        int max = 0;

        for (int i = 0; i < N; i++) {
            
            while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                
                int h = height[stack.pop()];
                int w = i;

                if (!stack.isEmpty()) {
                    System.out.println("stack "+ stack.peek()+" h "+ h);
                    w = i-stack.peek()-1;
                }

                max = Math.max(max, h*w);
            }

            stack.push(i);

        }

        System.out.println(stack);

        while(!stack.isEmpty()){
            int h = height[stack.pop()];
            int w = N;

            if (!stack.isEmpty()) {
                w = N-stack.peek()-1;
            }

            max = Math.max(max, h*w);

        }

        System.out.println(max);

    }
}
