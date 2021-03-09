import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * InnerBJ9498 시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D,
 * 나머지 점수는 F를 출력하는 프로그램을 작성하시오.
 */
public class BJ9498 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int score = Integer.parseInt(br.readLine());

        if (score >= 90)
            System.out.println("A");

        else if (score >= 80)
            System.out.println("B");

        else if (score >= 70)
            System.out.println("C");

        else if (score >= 60)
            System.out.println("D");

        else
            System.out.println("F");

    }
}