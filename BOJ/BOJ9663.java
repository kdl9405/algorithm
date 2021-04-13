import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ9663
 */
public class BOJ9663 {

    static int n;
    static boolean[][] map;
    static int count;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new boolean[n][n];

        count = 0;
        set_quean(0, 0, 0);

        System.out.println(count);

    }

    static void set_quean(int x, int y, int depth) {

        if (depth == n) {
            count++;
            return;
        }

        for (int i = x; i < n; i++) {
            for (int j = y; j < n; j++) {

                if (!map[i][j]) {
                    // 함수 : 못놓은 자리 체크 => 가능한 자리 수 체크하여 진행 가능여부 반환

                    if (posi_check(i, j, depth + 1)) {
                        map[i][j] = true;
                        set_quean(i, 0, depth + 1);

                    } else {
                        map[i][j] = false;
                        
                        if(y<n-1){
                            y++;
                        }else if(x<n-1){
                            x++;
                        }                        
                    }

                    map[i][j] = false;
                }


            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                System.out.print(map[i][j] + " ");

            }
            System.out.println();

        }


    }

    static boolean posi_check(int x, int y, int depth) {

        boolean[][] temp_map = map;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (temp_map[i][j]) {
                    continue;
                }

                else if (i == x || j == y || Math.abs(i - x) == Math.abs(j - y)) {
                    temp_map[i][j] = true;

                }

            }
        }

        int posi_count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!temp_map[i][j]) {

                    posi_count++;
                }

                System.out.print(temp_map[i][j] + " ");

            }
            System.out.println();

        }

        if (n - depth > posi_count) {
            System.out.println(x +","+y + "불가능" + depth);
            return false;
        }

        map = temp_map;
        System.out.println(x +","+y + " 가능"+ depth);
        return true;
    }

}