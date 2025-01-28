package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 암호 만들기
 * 
 */
public class BOJ1759 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        c = br.readLine().replaceAll(" ", "").toCharArray();
        Arrays.sort(c);

        password = new char[L];
        sb = new StringBuilder();

        dfs(0, 0);

        System.out.println(sb.toString().trim());

    }

    static int L, C;
    static char[] c;
    static char[] password;
    static StringBuilder sb;

    static void dfs(int index, int depth) {

        if (depth == L) {
            String p = new String(password);
            if (p.replaceAll("[^aeiou]", "").length() > 0
                    && p.replaceAll("[aeiou]", "").length() > 1) {
                sb.append(p + "\n");
            }

            return;
        }

        if (index >= C) {
            return;
        }

        password[depth] = c[index];
        dfs(index + 1, depth + 1);
        dfs(index + 1, depth);


    }
}
