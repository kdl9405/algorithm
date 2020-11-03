import java.util.*;

/**
 * kakaodemo2
 */
public class kakaodemo2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<a; i++){

            sb = sb.append("*");
            
        }

        for(int j = 0; j<b; j++){

            System.out.println(sb);


        }
    }
}