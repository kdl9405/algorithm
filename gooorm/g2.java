package gooorm;

import java.io.*;
import java.util.*;

/* 
    고장난 컴퓨터
*/

public class g2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int count = 0;
        int next = 0;
        while (n-- > 0) {
            int now = Integer.parseInt(st.nextToken());
            if (now > next) {
                count = 0;
            }
            count++;
            next = now + c;
        }

        System.out.println(count);
    }

}
