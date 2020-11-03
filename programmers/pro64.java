import java.util.HashMap;

/**
 * n개의 최소공배수
 */
public class pro64 {

    public static void main(String[] args) {

        int[] arr = {2,6,8,14}; 

        System.out.println(solution(arr));

    }

    static int solution(int[] arr) {
        int answer = 1;

        int[]  num = new int[101];

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : arr){

            map = new HashMap<>();

            int i = 2;
            while (n>= i) {
                if (n%i == 0) {
                    map.put(i, map.getOrDefault(i, 0)+1);
                    n /= i;
                }
                else{
                    i++;
                }
            }

            for(Integer m : map.keySet()){
                if (num[m] < map.get(m)) {
                    num[m] = map.get(m);
                }
            }
        }

        for(int i = 1; i<=100; i++){
            if (num[i] != 0) {
                answer *= Math.pow(i, num[i]);
            }
        }


        return answer;
    }
}