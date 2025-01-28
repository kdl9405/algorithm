package boj;

/*
 * 기타줄
 * 
 */

import java.io.*;
import java.util.*;

public class BOJ1049 {

    public static void main(String[] args) throws IOException {

        new BOJ1049().solution();
    }

    void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int packPrice = 1000;
        int unitPrice = 1000;

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            packPrice = Math.min(packPrice, Integer.parseInt(st.nextToken()));
            unitPrice = Math.min(unitPrice, Integer.parseInt(st.nextToken()));
        }

        int totalPrice = 0;
        if (unitPrice * 6 <= packPrice) {
            totalPrice = unitPrice * N;
        } else {
            totalPrice = (N / 6) * packPrice;
            int r = N % 6;
            if (r * unitPrice > packPrice) {
                totalPrice += packPrice;
            } else {
                totalPrice += (r * unitPrice);
            }
        }

        System.out.println(totalPrice);
    }
}
