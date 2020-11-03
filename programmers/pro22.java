
import java.util.Arrays;

// 큰 수 만들기
public class pro22 {

    static boolean visit[];
    static int[] arr;
    static String[] str;
    static StringBuilder sb = new StringBuilder();
    static Long max = Long.MIN_VALUE;

    public static void main(String[] args) {

        System.out.println(solution("9998977856667999", 3));
    }

    static String solution(String number, int k) {
        String answer = "";

        str = number.split("");

        visit = new boolean[str.length];
        arr = new int[k];

        dfs(0,0);

        answer = Long.toString(max);

        return answer;
    }

    static void dfs(int n, int depth) {

        if (depth == arr.length) {

            Arrays.sort(arr);            

            for (int i = 0; i < str.length; i++) {

                boolean check = false;

                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] == i) {
                        check = true;
                        break;
                    }
                }

                if (!check) {
                    sb.append(str[i]);
                }
            }
            max = Math.max(max, Long.parseLong(sb.toString()));
            sb = new StringBuilder();
            return;
        }

        for (int i = n; i < str.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i;
                dfs(i, depth + 1);
                visit[i] = false;
            }
        }

    }
}
