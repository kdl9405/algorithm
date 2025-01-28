package boj;


/*
 * 숫자 카드
 * 
 */


import java.io.*;
import java.util.*;

public class BOJ10815 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        BitSet card = new BitSet();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            card.set(Integer.parseInt(st.nextToken()) + 10000000);
        }

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            if (card.get(Integer.parseInt(st.nextToken()) + 10000000)) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
