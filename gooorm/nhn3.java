package gooorm;

import java.util.*;

/**
 * nhn3
 */
public class nhn3 {

    private static void solution(int numOfOrder, String[] orderArr) {

        StringBuilder sb = new StringBuilder();


        int count = 0;
        while (count < numOfOrder) {

            Deque<Character> deque = new LinkedList<>();
            for (int i = 0; i < orderArr[i].length(); i++) {
                deque.offer(orderArr[i].charAt(i));
            }

            String temp = "";
            while (!deque.isEmpty()) {
                if (deque.pollLast() == ')' && temp == "") {
                    continue;
                }    

                if (deque.peekLast() == '(') {
                    
                }
            }

            count++;
        }

    }

    private static class InputData {
        int numOfOrder;
        String[] orderArr;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.numOfOrder = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.orderArr = new String[inputData.numOfOrder];
            for (int i = 0; i < inputData.numOfOrder; i++) {
                inputData.orderArr[i] = scanner.nextLine().replaceAll("\\s+", "");
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.numOfOrder, inputData.orderArr);
    }
}