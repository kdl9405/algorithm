/**
 * N으로 표현
     dfs
 */
public class pro79_copy {

    public static void main(String[] args) {

        System.out.println(solution(5, 12));
    }

    static int answer = -1;

    static int solution(int N, int number) {
        dfs(N, 0, 0, number, "");
        return answer;
    }

    static void dfs(int n, int pos, int num, int number, String s) {
        if (pos > 8)
            return;
        if (num == number) {
            if (pos < answer || answer == -1) {
                System.out.println(s);
                answer = pos;
            }
            return;
        }
        int nn = 0;
        for (int i = 0; i < 8; i++) {
            nn = nn * 10 + n;
            dfs(n, pos + 1 + i, num + nn, number, s + "+");
            dfs(n, pos + 1 + i, num - nn, number, s + "-");
            dfs(n, pos + 1 + i, num * nn, number, s + "*");
            dfs(n, pos + 1 + i, num / nn, number, s + "/");
        }
    }
}