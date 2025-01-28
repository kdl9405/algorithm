package boj;

import java.util.Scanner;

public class BOJ27866 {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            int sequence = scanner.nextInt();

            System.out.println(input.charAt(sequence - 1));
        }
    }
}
