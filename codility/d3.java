package codility;

public class d3 {

    public static void main(String[] args) {
        
    }

    public static int solution(int N) {

        if (N < 10) {
            return N + 1;
        }

        N++;

        loop: while (true) {
            String number = Integer.toString(N);

            for (int i = 1; i < number.length(); i++) {
                if (number.charAt(i - 1) == number.charAt(i)) {
                    int d = number.length() - (i);

                    N = Integer.parseInt(number.substring(0, i)) * ((int) Math.pow(10, d));

                    N += Integer.parseInt(number.charAt(i) + "") * ((int) Math.pow(10, d - 1));
                    continue loop;
                }
            }

            break;

        }

        return N;
    }
}
