package BOJ;

/**
 * 서로 다른 부분 문자열의 개수
 */

import java.io.*;
import java.util.*;

public class BOJ11478 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Set<String> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                sb.append(s.charAt(j));
                set.add(sb.toString());
            }
        }
        System.out.println(set.size());
    }
}