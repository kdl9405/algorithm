package kakao.test2copy;

import java.util.*;

/**
 * Solution
 */
public class Solution {

    public static void main(String[] args) {

        String expression = "100-200*300-500+20";

        String temp = expression.replaceAll("[-+*]", " ");
        number = temp.split(" ");

        temp = expression.replaceAll("[\\d]", " ");

        operator = new LinkedList<>();
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) != ' ') {
                operator.add(Character.toString(temp.charAt(i)));
            }

        }

        LinkedList<String> rePerArr = new LinkedList<String>();
        int[] perCheck = new int[operator.size()];
        rePermutation(operator.size(), operator.size(), rePerArr, perCheck);

    }

    public static String[] number;
    public static LinkedList<String> operator;
    public static Long max;

    public static long solution(String expression) {
        long answer = 0;

        HashSet<Long> result = new HashSet<>();

        String temp = expression.replaceAll("[-+*]", " ");
        number = temp.split(" ");
        operator = new LinkedList<>();
        temp = expression.replaceAll("[\\d]", " ");

        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) != ' ') {
                operator.add(Character.toString(temp.charAt(i)));
            }

        }

        for (int i = 0; i < number.length - 1; i++) {

        }

        return answer;
    }

    public static void calculator(HashSet<Long> result, int idx, int n) {

        if (idx == number.length - 1) {

            HashSet<Long> temp = new HashSet<>();
            temp.addAll(result);

            max = Collections.max(temp);

            return;
        }

        for (int i = 1; i < number.length; i++) {

            switch (operator.get(i - 1)) {
                case "-":
                    n = n - Integer.parseInt(number[i]);
                    break;

                case "+":
                    n = n + Integer.parseInt(number[i]);
                    break;

                case "*":
                    n = n * Integer.parseInt(number[i]);
                    break;
            }

            // if (!list.contains(user[i])) {

            // if (user[i].matches(banned[idx])) {

            // list.add(user[i]);
            // bann(list, idx + 1);
            // list.remove(user[i]);

            // }

            // }

        }

        return;
    }

    public static void rePermutation(int n, int r, LinkedList<String> rePerArr, int[] perCheck) {
        if (rePerArr.size() == r) {
            int num = Integer.parseInt(number[0]);
            for (int i = 0; i < rePerArr.size(); i++) {

                switch (rePerArr.get(i)) {
                    case "-":
                        num = num - Integer.parseInt(number[i + 1]);
                        break;

                    case "+":
                        num = num + Integer.parseInt(number[i + 1]);
                        break;

                    case "*":
                        num = num * Integer.parseInt(number[i + 1]);
                        break;
                }
                System.out.print(number[i] + rePerArr.get(i));

            }
            System.out.println();
            return;
        }

        for (int i = 0; i < operator.size(); i++) {

            if (perCheck[i] == 0) {
                rePerArr.add(operator.get(i));
                perCheck[i] = 1;
                rePermutation(n, r, rePerArr, perCheck);
                perCheck[i] = 0;
                rePerArr.removeLast();
            }

        }

    }

}
