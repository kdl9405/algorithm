import java.util.*;

/**
 * 풍선 터트리기
 */
public class pro81 {

    public static void main(String[] args) {

        int[] a = {9,-1,-5 };
        System.out.println(solution(a));

    }

    static int solution(int[] a) {
        int answer = 0;
        
        int[] beforeM = new int[a.length];
        int[] afterM = new int[a.length];

        beforeM[0] = Integer.MAX_VALUE;
        afterM[a.length-1] = Integer.MAX_VALUE;

        for(int i = 1; i<a.length; i++){
            beforeM[i] = Math.min(beforeM[i-1], a[i-1]);

        }
        for(int i = a.length-2 ; i>=0; i--){
            afterM[i] = Math.min(afterM[i+1], a[i+1]);
        }

        for(int i = 0; i<a.length; i++){
            if (beforeM[i] > a[i] || afterM[i] > a[i]) {
                answer++;
            }
        }
                
        return answer;
    }
}