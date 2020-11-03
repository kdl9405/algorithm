package programmers;

public class pro50 {

    public static void main(String[] args) {

        int n = 2;
        String[] data = { "N~F=0", "R~T>2" };

        System.out.println(solution(n, data));

    }

    static char[] ch = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };
    static char[] arr;
    static boolean[] visit;
    static int count;

    static int solution(int n, String[] data) {
        int answer = 0;

        arr = new char[8];
        visit = new boolean[8];
        count = 0;

        dfs(0, data);

        answer = count;
        return answer;
    }

    static void dfs(int depth, String[] data) {
        if (depth == 8) {
            if (check(data)) {
                count++;
            }
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = ch[i];
                dfs(depth + 1, data);
                visit[i] = false;
            }
        }
    }

    static boolean check(String[] data) {
        int n = data.length;
        for (int i = 0; i < n; i++) {
            char[] condi = data[i].toCharArray();

            int x = 0;
            int y = 0;
            int dif = 0;
            int val = condi[4] - '0';


            for (int j = 0; j < 8; j++) {
                if (arr[j] == condi[0]) {
                    x = j;
                }
                if (arr[j] == condi[2]) {
                    y = j;
                }
            }

            dif = Math.abs(x - y) - 1;

            switch (condi[3]) {
                case '=':
                    if (dif != val) {
                        return false;
                    }
                    break;

                case '<':
                    if (dif >= val) {
                        return false;
                    }
                    break;
                case '>':
                    if (dif <= val) {
                        return false;
                    }
                    break;
            }

        }

        return true;
    }
}