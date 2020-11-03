package programmers;

public class pro50_copy {

    public static void main(String[] args) {

        int n = 2;
        String[] data = { "N~F=0", "R~T>2" };

        System.out.println(solution(n, data));

    }

    static int solution(int n, String[] data) {
        int answer = 0;


        visit = new boolean[8];
        arr = new char[8];
        count = 0;

        condi = data.clone();

        dfs(0);
        answer = count;

        return answer;
    }

    static char[] ch = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static boolean[] visit;
    static char[] arr;
    static int count;
    static String[] condi;

    static void dfs(int depth) {

        if (depth == 8) {

            StringBuilder sb = new StringBuilder();

            for (char c : arr) {
                sb.append(c);
            }

            if (check(sb.toString())) {
                count++;
            }
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = ch[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }

    static boolean check(String s) {

        for (int i = 0; i < condi.length; i++) {
            char x = condi[i].charAt(0);
            char y = condi[i].charAt(2);
            char op = condi[i].charAt(3);
            int va = Integer.parseInt(Character.toString(condi[i].charAt(4)));

            int xp = 0;
            int yp = 0;

            int c = 0;
            for (int j = 0; j < 8; j++) {
                if (s.charAt(j) == x) {
                    xp = j;
                    c++;
                } else if (s.charAt(j) == y) {
                    yp = j;
                    c++;
                }
                if (c == 2) {
                    break;
                }
            }

            int dif = Math.abs(xp - yp)-1;

            switch (op) {
                case '=':
                    if (dif != 0) {
                        return false;
                    }
                    break;

                case '<':
                    if (dif >= va) {
                        return false;
                    }
                    break;
                case '>':
                    if (dif <= va) {
                        return false;
                    }
                    break;
            }

        }

        return true;

    }
}
