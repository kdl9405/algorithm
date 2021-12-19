package BOJ;

/*

    키로거 

*/

import java.io.*;
import java.util.*;

public class BOJ5397_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();

        while (T-- > 0) {
            String input = br.readLine();
            List<Character> inputList = new LinkedList<>();
            ListIterator<Character> inputIter = inputList.listIterator();

            for (int i = 0; i < input.length(); i++) {
                switch (input.charAt(i)) {
                    case '<':
                        if (inputIter.hasPrevious()) {
                            inputIter.previous();
                        }

                        break;
                    case '>':
                        if (inputIter.hasNext()) {
                            inputIter.next();
                        }

                        break;
                    case '-':

                        if (inputIter.hasPrevious()) {
                            inputIter.previous();
                            inputIter.remove();
                        }
                        break;

                    default:

                        inputIter.add(input.charAt(i));
                        break;
                }
            }

            for (char c : inputList) {
                result.append(c);
            }
            result.append("\n");
        }

        System.out.println(result.toString().trim());
    }
}
