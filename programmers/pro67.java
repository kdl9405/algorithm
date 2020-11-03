import java.util.*;

/**
 * 점프와 순간이동
 */
public class pro67 {

    public static void main(String[] args) {

        System.out.println(solution(999999999));

    }

    static int solution(int n) {
        int ans = 0;

        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2; 
            }else{
                n--;
                ans++;
            }
        }

       
        return ans;
    }

    

}