package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1966 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());
            int target_value = 0;
            Integer[] arr = new Integer[n];
            Queue<Integer> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i] = num;
                if (i==index) {
                    target_value = num;
                    queue.offer(0);
                }else{
                    queue.offer(num);
                }
            }
            Arrays.sort(arr, Collections.reverseOrder());

            int count = 0;
            for (int i = 0; i < n; i++) {

                while (true) {
                    if (queue.peek() == 0) {
                        if (arr[i] == target_value) {
                            queue.poll();
                            count ++;
                            sb.append(count+"\n");
                            break;
                        }else{
                            queue.offer(queue.poll());
                        }
                    }else{
                        if (queue.peek() == arr[i]) {
                            queue.poll();
                            count++;
                            break;
                        } else {
                            queue.offer(queue.poll());
                        }
                    }                   
                }
            }

        }
        System.out.println(sb);
    }
}
