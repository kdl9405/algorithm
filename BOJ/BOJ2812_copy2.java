package boj;

import java.io.*;
import java.util.*;

/*
 * 크게 만들기 메모리초과
 */
public class BOJ2812_copy2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String num = br.readLine();

        ArrayList<ArrayList<Integer>> numIndex = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numIndex.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(Character.toString(num.charAt(i)));
            numIndex.get(x).add(i);
        }

        char[] chN = num.toCharArray();
        int count = 0;

        loop: for (int i = 0; i < 10; i++) {
            ArrayList<Integer> temp = numIndex.get(i);
            Collections.sort(temp);

            for (Integer e : temp) {
                if (deleteCheck(chN, e)) {
                    chN[e] = 'D';
                    count++;
                    if (count == k) {
                        break loop;
                    }
                }

            }
        }

        String temp = new String(chN);
        temp = temp.replaceAll("D", "");

        System.out.println(temp);

    }

    static boolean deleteCheck(char[] chN, int index) {
        chN[index] = 'D';
        String temp = new String(chN);
        temp = temp.replaceAll("D", "");

        if (temp.charAt(0) == '0') {
            return false;
        }

        return true;
    }
}
