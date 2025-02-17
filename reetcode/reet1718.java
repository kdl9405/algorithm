package reetcode;

import java.io.*;
import java.util.*;

public class reet1718 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] ans = constructDistancedSequence(n);

        System.out.println(Arrays.toString(ans));

    }

    public static boolean isFinished;
    public static int[] answer;


    public static int[] constructDistancedSequence(int n) {

        isFinished = false;
        answer = new int[n * 2 - 1];

        boolean[] usedNumbers = new boolean[n + 1];

        findSequence(usedNumbers, n, 0);

        return answer;
    }

    public static void findSequence(boolean[] usedNumber, int n, int index) {

        if (index == answer.length) {
            isFinished = true;
            return;
        }

        if (answer[index] != 0) {
            findSequence(usedNumber, n, index + 1);
            return;
        }

        for (int i = n; i > 0; i--) {

            if (usedNumber[i])
                continue;
            if (i != 1 && (index + i >= answer.length || answer[index + i] != 0))
                continue;

            usedNumber[i] = true;
            answer[index] = i;
            if (i != 1)
                answer[index + i] = i;

            findSequence(usedNumber, n, index + 1);
            if (isFinished)
                return;

            usedNumber[i] = false;
            answer[index] = 0;
            if (i != 1)
                answer[index + i] = 0;
        }
    }
}
