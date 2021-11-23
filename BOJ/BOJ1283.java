package BOJ;

/* 
    단축키
*/

import java.io.*;
import java.util.*;

public class BOJ1283 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashSet<Character> keys = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            String s = br.readLine();
            String[] arr = s.split(" ");
            boolean done = false;

            int i = 0;
            for (; i < arr.length; i++) {
                if (!keys.contains(Character.toLowerCase(arr[i].charAt(0)))) {
                    keys.add(Character.toLowerCase(arr[i].charAt(0)));
                    done = true;
                    break;
                }
            }

            if (done) {
                arr[i] = "["+arr[i].charAt(0)+"]"+arr[i].substring(1);

                for(String a : arr){
                    sb.append(a+" ");
                }
                sb.append("\n");
                continue;
            }

            i = 0;
            for (; i < s.length(); i++) {
                if (s.charAt(i) != ' ' && !keys.contains(Character.toLowerCase(s.charAt(i)))) {
                    keys.add(Character.toLowerCase(s.charAt(i)));
                    done = true;
                    break;
                }
            }

            if (done){
                for(int j = 0; j<s.length(); j++){
                    if (j == i) {
                        sb.append("["+s.charAt(j)+"]");
                    }else{
                        sb.append(s.charAt(j));
                    }
                }
                sb.append("\n");
            }else{
                sb.append(s+"\n");
            }

        }

        System.out.println(sb.toString().trim());
    }
}
