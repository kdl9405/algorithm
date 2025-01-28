package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * 나는야 포켓몬 마스터 이다솜
 */

public class BOJ1620 {

    public static void main(String[] args) throws IOException {

        HashMap<String, Integer> forNum = new HashMap<>();
        HashMap<Integer, String> forName = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int input = Integer.parseInt(st.nextToken());
        int question = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= input; i++) {
            String name = br.readLine();
            forNum.put(name, i);
            forName.put(i, name);
        }

        for (int i = 1; i <= question; i++) {
            String ques = br.readLine();
            if (Character.isDigit(ques.charAt(0))) {
                sb.append(forName.get(Integer.parseInt(ques)));
            } else {
                sb.append(forNum.get(ques));
            }

            if (i != question) {
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());

    }


}
