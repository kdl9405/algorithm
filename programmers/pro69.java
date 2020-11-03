/**
 * 예상 대진표

 */
public class pro69 {

    
    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7));
    }

    static int solution(int n, int a, int b)
    {
        int answer = 0;

        while (a != b) {

            answer++;

            if (a % 2 == 1) {
                a++;
            }
            if (b % 2 == 1) {
                b++;
            }

            a /= 2;
            b /= 2;

        }

        return answer;
    }
}