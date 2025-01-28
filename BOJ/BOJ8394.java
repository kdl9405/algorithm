package boj;

import java.io.*;

/**
 * InnerBOJ8394
 * 
 * 문제 n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.
 * 
 * 입력 첫째 줄에 n (1 ≤ n ≤ 10,000)이 주어진다.
 * 
 * 출력 1부터 n까지 합을 출력한다.
 */
public class BOJ8394 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 1; i < N + 1; i++) {
            result += i;
        }

        System.out.println(result);



    }


}
