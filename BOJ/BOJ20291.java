package boj;

/*
 * 파일 정리
 */

import java.io.*;
import java.util.*;

public class BOJ20291 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> extensionMap = new TreeMap<>();

        StringTokenizer st;
        while (N-- > 0) {
            // st = new StringTokenizer(br.readLine(), ".", false);
            // st.nextToken();

            // String extension = st.nextToken();
            String input = br.readLine();
            String extension = input.substring(input.indexOf(".") + 1);

            extensionMap.put(extension, extensionMap.getOrDefault(extension, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (String extension : extensionMap.keySet()) {
            sb.append(extension).append(" ").append(extensionMap.get(extension)).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
