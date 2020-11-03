
import java.util.ArrayList;
import java.util.HashSet;

//소수 찾기
public class pro19 {

    static String[] str;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static HashSet<Integer> hash = new HashSet<>();

    public static void main(String[] args) {

        String numbers = "7843";

        System.out.println("result = " + solution(numbers));
    }

    static int solution(String numbers) {
        int answer = 0;

        str = numbers.split("");

        visit = new boolean[str.length];

        for (int i = 0; i < str.length; i++) {

            arr = new int[i + 1];

            dfs(0, 0, i + 1);
        }

        answer = hash.size();

        System.out.println(hash);

        return answer;
    }

    static void dfs(int n, int depth, int size) {
        if (depth == size) {
            for (int num : arr) {
                sb.append(num);
                System.out.println(num);
            }
            int num = Integer.parseInt(sb.toString());

            System.out.println(sb);

            sb = new StringBuilder();

            boolean prime = true;

            if (num > 1) {
                for (int i = 2; i < num; i++) {
                    if ((num % i) == 0) {
                        prime = false;
                        break;
                    }
                }
            } else if (num <= 1) {
                prime = false;

            }

            if (prime) {
                hash.add(num);
            }

            return;
        }

        for (int i = 0; i < str.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = Integer.parseInt(str[i]);
                dfs(i, depth + 1, size);
                visit[i] = false;
            }
        }

    }

}
