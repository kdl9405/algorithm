package programmers;

import java.util.*;

/* 
    카드 짝 맞추기

    70
*/
public class pro134_copy {

    public static void main(String[] args) {
        int[][] board = { { 1, 0, 0, 3 }, { 2, 0, 0, 0 }, { 0, 0, 0, 2 }, { 3, 0, 1, 0 } };
        int r = 1;
        int c = 0;

        System.out.println(solution(board, r, c));

    }

    static boolean[] visit;
    static List<int[]> deleteSequence;
    static int[] arr;
    static int[] dr = { 1, -1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static int solution(int[][] board, int r, int c) {

        HashMap<Integer, HashSet<card>> cards = new HashMap<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != 0) {
                    HashSet<card> temp;
                    if (cards.containsKey(board[i][j])) {
                        temp = cards.get(board[i][j]);
                    } else {
                        temp = new HashSet<>();
                    }
                    temp.add(new card(i, j));
                    cards.put(board[i][j], temp);
                }
            }
        }

        int[] cardNumber = cards.keySet().stream().mapToInt(i -> i).toArray();
        visit = new boolean[cardNumber.length];
        arr = new int[cardNumber.length];
        deleteSequence = new ArrayList<>();
        findSequence(cardNumber, 0);

        int answer = Integer.MAX_VALUE;

        for (int[] sequence : deleteSequence) {

            int[][] map = new int[4][4];

            for (int j = 0; j < 4; j++) {
                System.arraycopy(board[j], 0, map[j], 0, 4);
            }

            int count = 0;
            int nr = r;
            int nc = c;

            for (int n : sequence) {

                card[] card = new card[2];
                int i = 0;
                for (card temp : cards.get(n)) {
                    card[i] = temp;
                    i++;
                }

                int t1 = move(nr, nc, card[0].r, card[0].c, map);
                int t2 = move(nr, nc, card[1].r, card[1].c, map);
                int t3 = move(card[0].r, card[0].c, card[1].r, card[1].c, map);
                int t4 = move(card[1].r, card[1].c, card[0].r, card[0].c, map);
                if (t1 + t3 < t2 + t4) {
                    nr = card[1].r;
                    nc = card[1].c;
                    count += (t1 + t3);

                } else {
                    nr = card[0].r;
                    nc = card[0].c;
                    count += (t2 + t4);

                }

                map[card[0].r][card[0].c] = 0;
                map[card[1].r][card[1].c] = 0;

            }
            answer = Math.min(answer, count);
        }

        return answer + (cards.keySet().size() * 2);
    }

    static void findSequence(int[] number, int depth) {
        if (depth == number.length) {

            int[] num = new int[depth];
            for (int i = 0; i < depth; i++) {
                num[i] = arr[i];
            }
            deleteSequence.add(num);

            return;
        }

        for (int i = 0; i < number.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = number[i];
                findSequence(number, depth + 1);
                visit[i] = false;
            }
        }
        return;
    }

    static int move(int r1, int c1, int r2, int c2, int[][] map) {
        int count = Math.abs(r1 - r2) + Math.abs(c1 - c2);

        Queue<String> queue = new LinkedList<>();
        queue.add(r1 + "," + c1);

        int t = 0;
        while (t < count) {

            Queue<String> temp = new LinkedList<>();

            while (!queue.isEmpty()) {
                String[] point = queue.poll().split(",");
                int r = Integer.parseInt(point[0]);
                int c = Integer.parseInt(point[1]);

                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if (nr >= 0 && nr < 4 && nc >= 0 && nc < 4) {
                        if (!temp.contains(nr + "," + nc)) {
                            temp.add(nr + "," + nc);
                        }
                    }

                    while (nr >= 0 && nr < 4 && nc >= 0 && nc < 4) {

                        if (map[nr][nc] != 0) {
                            if (!temp.contains(nr + "," + nc)) {
                                temp.add(nr + "," + nc);
                            }
                        }
                        nr += dr[i];
                        nc += dc[i];
                    }
                    if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4) {
                        nr -= dr[i];
                        nc -= dc[i];
                        if (!temp.contains(nr + "," + nc)) {
                            temp.add(nr + "," + nc);
                        }
                    }
                }
            }
            queue.addAll(temp);
            t++;
            if (queue.contains(r2 + "," + c2)) {
                break;
            }
        }

        return Math.min(count, t);
    }
}

class card {
    int r, c;

    public card(int r, int c) {
        this.r = r;
        this.c = c;
    }
}