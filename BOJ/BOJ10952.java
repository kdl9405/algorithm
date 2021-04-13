package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 */
public class BOJ10952 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while (true) {

            String str = br.readLine();

            int A = str.charAt(0) - 48;
            int B = str.charAt(2) - 48;            
            
            if( A == 0 & B == 0) {
                break ;
            }
            
            sb.append((A+B)).append('\n');
        }

        System.out.println(sb);

    }
}