package BOJ;

/* 
    숫자놀이
*/

import java.io.*;
import java.util.*;

public class BOJ1755 {

    public static void main(String[] args) throws IOException {
        new BOJ1755().solution();
    }

    void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        init();

        numbers = new ArrayList<>();
        for (int i = M; i <= N; i++) {
            numbers.add(new readAndNumber(readNumber(i), i));
        }

        Collections.sort(numbers, (a, b) -> {
            return a.read.compareTo(b.read);
        });

        StringBuilder answer = new StringBuilder();
        for(int i = 0; i<numbers.size(); i++){
            answer.append(numbers.get(i).num);
            if ((i+1)%10 == 0) {
                answer.append("\n");
            }else{
                answer.append(" ");
            }
        }

        System.out.println(answer.toString().trim());
    }

    Map<Integer, String> number;
    List<readAndNumber> numbers;

    void init() {
        number = new HashMap<>();

        number.put(0, "zero");
        number.put(1, "one");
        number.put(2, "two");
        number.put(3, "three");
        number.put(4, "four");
        number.put(5, "five");
        number.put(6, "six");
        number.put(7, "seven");
        number.put(8, "eight");
        number.put(9, "nine");
    }

    String readNumber(int num) {

        StringBuilder sb = new StringBuilder();

        if (num >= 10) {
            sb.append(number.get(num / 10)).append(" ");
        }
        sb.append(number.get(num % 10));

        return sb.toString();
    }

    private class readAndNumber {

        String read;
        int num;

        public readAndNumber(String read, int num) {
            this.read = read;
            this.num = num;
        }

    }

}
