package BOJ;

/* 
    나무 조각
*/

import java.io.*;
import java.util.*;

public class BOJ2947 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        wood = new int[6];
        for (int i = 1; i <= 5; i++) {
            wood[i] = Integer.parseInt(st.nextToken());
        }

        answer = new StringBuilder();

        while (!isFin()) {
            for (int i = 1; i <= 4; i++) {
                if (wood[i] > wood[i + 1]) {
                    changeWood(i, i + 1);
                    addWood();
                }
            }
        }

        System.out.println(answer.toString().trim());
    }

    static int[] wood;
    static StringBuilder answer;

    static void changeWood(int a, int b) {

        int t = wood[a];
        wood[a] = wood[b];
        wood[b] = t;
    }

    static void addWood() {
        for (int i = 1; i <= 5; i++) {
            answer.append(wood[i]).append(" ");
        }
        answer.append("\n");
    }

    static boolean isFin() {

        for (int i = 1; i <= 5; i++) {
            if (wood[i] != i) {
                return false;
            }
        }
        return true;
    }
}
