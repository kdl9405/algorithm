package programmers;

/*
    쿼드압축 후 개수 세기

*/
public class pro164 {

    public int[] solution(int[][] arr) {
        answer = new int[2];

        map = arr.clone();

        divide(0, 0, arr.length);

        return answer;
    }

    static int[][] map;
    static int[] answer;

    static void divide(int x, int y, int size) {

        if (check(x, y, size)) {
            answer[map[x][y]]++;
        } else {
            size /= 2;
            divide(x, y, size);
            divide(x, y + size, size);
            divide(x + size, y, size);
            divide(x + size, y + size, size);
        }

    }

    static boolean check(int x, int y, int size) {

        int p = map[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != p) {
                    return false;
                }
            }
        }
        return true;
    }
}
