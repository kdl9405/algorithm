package kakao.test2;

import java.util.*;

/**
 * Solution
 */
public class Solution {

    public static String express;
    public static String[] number;
    public static String[] operator;

    public static void main(String[] args) {

        String expression = "100-200*300-500+20";

        // System.out.println(solution(expression));

        express = expression;

        LinkedList<String> perArr = new LinkedList<String>();
        int[] perCheck = new int[3];
        permutation(3, 3, perArr, perCheck);

    }

    public static long solution(String expression) {
        long answer = 0;

        return answer;
    }

    private static void permutation(int n, int r, LinkedList<String> perArr, int[] perCheck) {
        if (perArr.size() == r) {
            for (String i : perArr) {

                String temp = express.replaceAll("[\\d]", " ");
                operator = temp.split(" ");
                temp = express.replaceAll("[-+*]", "  ");
                number = temp.split(" ");

                switch (i) {
                    case "+":

                        for (int x = 0; x < operator.length; x++) {
                            if (number[x] == "+") {
                                int z = 1;
                                while (true) {
                                    if (number[x - z] != null) {
                                        break;
                                    }
                                    z++;
                                }
                                number[x - z] = String
                                        .valueOf(Integer.parseInt(number[x - 1]) + Integer.parseInt(number[x + 1]));

                            }

                        }
                        break;

                    case "-":
                        for (int x = 0; x < operator.length; x++) {
                            if (number[x] == "-") {
                                int z = 1;
                                while (true) {
                                    if (number[x - z] != null) {
                                        break;
                                    }
                                    z++;
                                }
                                number[x - z] = String
                                        .valueOf(Integer.parseInt(number[x - 1]) - Integer.parseInt(number[x + 1]));

                            }

                        }
                        break;

                    case "*":
                        for (int x = 0; x < operator.length; x++) {
                            if (number[x] == "-") {
                                int z = 1;
                                while (true) {
                                    if (number[x - z] != null) {
                                        break;
                                    }
                                    z++;
                                }
                                number[x - z] = String
                                        .valueOf(Integer.parseInt(number[x - 1]) * Integer.parseInt(number[x + 1]));

                            }

                        }
                        break;
                }
            }

            System.out.println();
            return;
        }

        String[] operator = { "+", "-", "*" };

        for (int i = 0; i < n; i++) {
            if (perCheck[i] == 0) {
                perArr.add(operator[i]);
                perCheck[i] = 1;
                permutation(n, r, perArr, perCheck);
                perCheck[i] = 0;
                perArr.removeLast();
            }
        }

    }
}
