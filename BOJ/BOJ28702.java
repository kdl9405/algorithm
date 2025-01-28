package boj;

import java.io.*;

public class BOJ28702 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = new String[3];

        input[0] = br.readLine();
        input[1] = br.readLine();
        input[2] = br.readLine();

        int start = 1;

        for (int index = 0; index < 3; index++) {
            if (isNumeric(input[index])) {
                start = Integer.parseInt(input[index]) - index;
                break;
            }
        }

        while (true) {

            if (getFizzBuzzString(start).equals(input[0])
                    && getFizzBuzzString(start + 1).equals(input[1])
                    && getFizzBuzzString(start + 2).equals(input[2])) {
                System.out.println(getFizzBuzzString(start + 3));
                return;
            }

            start++;
        }

    }

    public static String getFizzBuzzString(int i) {

        if (i % 3 == 0 && i % 5 == 0) {
            return "FizzBuzz";
        } else if (i % 3 == 0) {
            return "Fizz";
        } else if (i % 5 == 0) {
            return "Buzz";
        } else {
            return Integer.toString(i);
        }
    }

    public static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
