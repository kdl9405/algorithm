package BOJ;

/* 
    중복 제거

*/

import java.io.*;
import java.util.*;

public class BOJ13701 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BitSet set = new BitSet();

        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            int a = Integer.parseInt(s);
            if (!set.get(a)) {
                set.set(a);
                sb.append(s).append(" ");
            }
        }

        bw.write(sb.toString().trim());
        bw.flush();

    }
}