package programmers;

public class pro46 {

    //124나라
    
    public static void main(String[] args) {
        System.out.println(solution(10));
    }

    static String solution(int n) {

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int r = n % 3;
            n = n/3;

            if (r == 0) {
                n -= 1;
                r = 4;
            }

            sb.append(r);

        }
        return sb.reverse().toString();
    }

   

}
