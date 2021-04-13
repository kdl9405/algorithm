package BOJ;

import java.io.*;
import java.util.*;

/* 
    찾기

    시간초과
*/
public class BOJ1786_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String t = br.readLine();
        String p = br.readLine();

        int count = 0;
        StringBuilder sb = new StringBuilder();

        if (p.length() == 1) {
            for(int i = 0; i<t.length(); i++){
                if (t.charAt(i) == p.charAt(0)) {
                    count++;
                    sb.append(i+1).append(" ");
                }
            }
        }else {
            for(int i = 0; i<t.length(); i++){
                if (t.charAt(i) == p.charAt(0)) {
                    int index = i+1;
                    int j = 1;
                    Queue<Integer> queue = new LinkedList<>();
                    while (j < p.length() && index< t.length()) {
                        if (t.charAt(index) == p.charAt(0)) {
                            queue.offer(index);
                        }
                        if (t.charAt(index) != p.charAt(j)) {
                            break;
                        }
                        index++;
                        j++;

                        if (j == p.length()) {
                            count++;
                            sb.append(i+1).append(" ");
                        }
                    }
                    if (!queue.isEmpty()) {
                        i = queue.poll()-1;
                    }else{
                        i = index;
                    }

                }
            }
        }

        System.out.println(count);
        System.out.println(sb.toString());

       
    }
}
