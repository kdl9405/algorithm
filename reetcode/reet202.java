package reetcode;

import java.util.*;

public class reet202 {

    public static void main(String[] args) {

    }

    public static boolean isHappy(int n) {

        Set<Integer> checkedNumber = new HashSet<>();

        while (n != 1) {

            if (checkedNumber.contains(n))
                return false;

            checkedNumber.add(n);

            int newNumber = 0;
            char[] numbers = Integer.toString(n).toCharArray();
            for (char number : numbers) {
                newNumber += Math.pow(number - '0', 2);
            }

            n = newNumber;
        }

        return true;
    }
}
