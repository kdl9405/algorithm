package boj;


/*
 * 숫자 카드
 * 
 * 
 * java 11 - 896ms java 8 - 864ms
 * 
 */


import java.io.*;
import java.util.*;

public class BOJ10815_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashSet<Integer> card = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            card.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            if (card.contains(Integer.parseInt(st.nextToken()))) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
