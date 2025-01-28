package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
 * ZOAC 3
 */
public class BOJ20436 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        setKeys();

        char[] init = br.readLine().toCharArray();

        int[] L, R;

        if (keyboardL.containsKey(init[0])) {
            L = keyboardL.get(init[0]).clone();
        } else {
            L = keyboardR.get(init[0]).clone();
        }

        if (keyboardL.containsKey(init[2])) {
            R = keyboardL.get(init[2]).clone();
        } else {
            R = keyboardR.get(init[2]).clone();
        }

        String input = br.readLine();

        int total = input.length();

        for (char c : input.toCharArray()) {

            if (keyboardL.containsKey(c)) {
                int[] p = keyboardL.get(c);
                total += Math.abs(L[0] - p[0]) + Math.abs(L[1] - p[1]);
                L[0] = p[0];
                L[1] = p[1];
            } else {
                int[] p = keyboardR.get(c);
                total += Math.abs(R[0] - p[0]) + Math.abs(R[1] - p[1]);
                R[0] = p[0];
                R[1] = p[1];
            }

        }

        System.out.println(total);
    }

    static HashMap<Character, int[]> keyboardL;
    static HashMap<Character, int[]> keyboardR;

    static void setKeys() {

        keyboardL = new HashMap<>();
        keyboardR = new HashMap<>();

        keyboardL.put('q', new int[] {0, 0});
        keyboardL.put('w', new int[] {0, 1});
        keyboardL.put('e', new int[] {0, 2});
        keyboardL.put('r', new int[] {0, 3});
        keyboardL.put('t', new int[] {0, 4});

        keyboardR.put('y', new int[] {0, 5});
        keyboardR.put('u', new int[] {0, 6});
        keyboardR.put('i', new int[] {0, 7});
        keyboardR.put('o', new int[] {0, 8});
        keyboardR.put('p', new int[] {0, 9});

        keyboardL.put('a', new int[] {1, 0});
        keyboardL.put('s', new int[] {1, 1});
        keyboardL.put('d', new int[] {1, 2});
        keyboardL.put('f', new int[] {1, 3});
        keyboardL.put('g', new int[] {1, 4});

        keyboardR.put('h', new int[] {1, 5});
        keyboardR.put('j', new int[] {1, 6});
        keyboardR.put('k', new int[] {1, 7});
        keyboardR.put('l', new int[] {1, 8});

        keyboardL.put('z', new int[] {2, 0});
        keyboardL.put('x', new int[] {2, 1});
        keyboardL.put('c', new int[] {2, 2});
        keyboardL.put('v', new int[] {2, 3});

        keyboardR.put('b', new int[] {2, 4});
        keyboardR.put('n', new int[] {2, 5});
        keyboardR.put('m', new int[] {2, 6});

        return;
    }
}
