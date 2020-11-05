import java.util.HashMap;
import java.util.HashSet;

/**
 * pro108
 */
public class pro108_copy {

    public static void main(String[] args) {

        int[] a = { 0, 3, 3, 0, 7, 2, 0, 2, 2, 0 };

        System.out.println(solution(a));

    }

    static int solution(int[] a) {
        int answer = 0;

        if (a.length < 4) {
            return 0;
        }

        A = a.clone();

        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int n : a) {
            hash.put(n, hash.getOrDefault(n, 0) + 1);
        }

        int max = 0;
        for (int n : hash.keySet()) {
            max = Math.max(max, hash.get(n));
        }

        max *= 2;
        if (max > a.length) {
            max = a.length;
        }

        while (max > 2) {
            visit = new boolean[a.length];
            arr = new int[max];

            dfs(0, max, 0);

            if (possible) {
                answer = max;
                break;
            }

            max -= 2;
        }

        return answer;
    }

    static int[] arr;
    static int[] A;
    static boolean[] visit;
    static boolean possible = false;

    static void dfs(int d, int n, int index) {
        if (d == n) {
            if (checkStar(arr)) {
                possible = true;
            }
            return;
        }

        for (int i = index; i < visit.length; i++) {
            if (n - d > visit.length - i) {
                return;
            }
            if (!visit[i]) {

                if (d % 2 == 1 && arr[d - 1] == A[i]) {
                    return;
                }

                visit[i] = true;
                arr[d] = A[i];
                dfs(d + 1, n, i + 1);
                visit[i] = false;
            }
        }
        return;
    }

    static boolean checkStar(int[] arr) {

        boolean check = true;

        for (int x = 0; x < 2; x++) {

            for (int i = 0; i < arr.length; i += 2) {
                if (arr[x] != arr[i] && arr[x] != arr[i + 1]) {
                    check = false;
                    break;
                }
            }
            if (check) {
                return true;
            }
        }

        return false;
    }

}