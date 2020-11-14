import java.util.Arrays;

/**
 * 징검다리 건너기
 * 
 */
public class pro111 {

    public static void main(String[] args) {

        int[] stones = { 2, 4, 5, 2, 2, 1, 1, 1, 1, 1 };
        int k = 3;

        System.out.println(solution(stones, k));

    }

    static int solution(int[] stones, int k) {
        int answer = 0;

        int[] arr = stones.clone();
        Arrays.sort(arr);
        int min = arr[0];
        int max = arr[stones.length-1];

        System.out.println(max +" "+ min);

        while (min <= max) {
            int mid = (min+max)/2;

            int temp = 0;
            int count = 0;
            for(int i =0; i<stones.length; i++){
                if(stones[i] <= mid){
                    count++;
                }else{
                    temp = Math.max(temp, count);
                    count = 0;
                }
                
                if (i == stones.length-1) {
                    temp = Math.max(temp, count);
                }
            }

            System.out.println(mid +" mid  "+ temp);


            if (temp >= k) {
                max = mid-1;
                answer = mid;
            }else{
                min = mid+1;
            }

        }

        return answer;
    }
}