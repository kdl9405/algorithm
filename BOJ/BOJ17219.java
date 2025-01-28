package boj;

import java.io.*;
import java.util.*;

/*
 * 비밀번호 찾기
 */
public class BOJ17219 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> password = new HashMap<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            password.put(st.nextToken(), st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            sb.append(password.get(br.readLine()) + "\n");
        }

        System.out.println(sb.toString());
    }
}
