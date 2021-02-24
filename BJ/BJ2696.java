package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/* 
    중앙값 구하기
*/
public class BJ2696 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int m = Integer.parseInt(br.readLine());

            int c = (m/10)+1;

            int index = 0;

            sb.append((m/2)+(m%2)).append("\n");
            int sbCount = 0;

            ArrayList<Integer> list = new ArrayList<>();
            while (c > 0) {
                
                String[] str = br.readLine().split(" ");

                for(int i = 0; i<str.length; i++){
                    list.add(Integer.parseInt(str[i]));
                    if (i%2 == 0) {                        
                        Collections.sort(list);
                        sb.append(list.get(index)).append(" ");
                        sbCount++;
                        if (sbCount % 10 == 0) {
                            sb.append("\n");
                        }
                        index++;
                    }
                }
                c--;               
            }
            if (sbCount % 10 != 0) {
                sb.append("\n");
            }
        }

       System.out.println(sb.toString());
    }

}
