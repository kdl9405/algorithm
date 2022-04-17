package BOJ;

/* 
    수학숙제
*/

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class BOJ2870 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<BigInteger> numbers = new ArrayList<>();

        while (N-- > 0) {

            String input = br.readLine();

            StringBuilder sb = new StringBuilder();
            for(char c : input.toCharArray()){
                if (Character.isLowerCase(c)) {
                    if (sb.length()>0) {
                        numbers.add(new BigInteger(sb.toString()));
                        sb = new StringBuilder();
                    }
                }else{
                    sb.append(c);
                }
            }
            if (sb.length()>0) {
                numbers.add(new BigInteger(sb.toString()));
            }
        }

        Collections.sort(numbers);

        StringBuilder answer = new StringBuilder();

        for (BigInteger number : numbers) {
            answer.append(number).append("\n");
        }

        System.out.println(answer.toString().trim());
    }

}