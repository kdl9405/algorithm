import java.util.Arrays;
import java.util.HashMap;

/**
 * rick juice mix
 */
public class challenge1 {

    public static void main(String[] args) {
        int[] juice = { 1,2,3,4,5 };
        int[] capacity = { 1,2,3,4,5};

        System.out.println(solution(juice, capacity));
    }

    static int solution(int[] juice, int[] capacity) {
        int answer = 1;

        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[][] arr = new int[juice.length][2];
        for (int i = 0; i < juice.length; i++) {
            sum+=juice[i];
            map.put(juice[i], map.getOrDefault(juice[i], 0) + 1);
            arr[i][0] = juice[i];
            arr[i][1] = capacity[i];
        }

        System.out.println(map);

        int[] key = map.keySet().stream().mapToInt(i -> i).toArray();

        Arrays.sort(key);
        Arrays.sort(arr, (a1, a2) -> {
            return (a2[1] - a2[0]) - (a1[1] - a1[0]);
        });

        if (arr[0][1] >= sum) {
            return juice.length;
        }

        if (arr[0][1] - arr[0][0] == 0) {
            return 1;
        }

        for (int i = 0; i < arr.length; i++) {

            int x = arr[i][1] - arr[i][0];

            if (x == 0) {
                break;
            }

            int count = 1;

            for (int j = 0; j < key.length; j++) {
                int c = map.get(key[j]);
                if (arr[i][0] == key[j]) {
                    c--;
                }
                if (x - (c * key[j]) > 0) {
                    count += c;
                    x -= (c * key[j]);
                }else {
                    count += (x/key[j]);
                    break;
                }
            }

            answer = Math.max(count, answer);

        }

        // if (juice.length == 1) {
        // return 1;
        // }

        // for (int i = 0; i < juice.length; i++) {
        // int possible = capacity[i] - juice[i];
        // if (possible == 0) {
        // continue;
        // }

        // int[] arr = juice.clone();
        // arr[i] = Integer.MAX_VALUE;
        // Arrays.sort(arr);
        // int count = 1;
        // for (int j = 0; j < arr.length; j++) {
        // possible -= arr[j];
        // if (possible < 0) {
        // break;
        // }else{
        // count++;
        // }
        // }
        // answer = Math.max(count, answer);
        // }

        return answer;
    }
}
