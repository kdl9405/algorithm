package programmers;
import java.util.Scanner;

/* 
    직사각형 별찍기

*/
public class pro161 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        StringBuffer sf = new StringBuffer();

        while (a-- > 0) {
            sf.append("*");
        }
        while (b-- > 0) {
            sb.append(sf).append("\n");
        }

        System.out.println(sb.toString().trim());

    }
}