package programmers;

import java.util.*;

/* 
    카드 짝 맞추기

    70
*/
public class p2 {

    public static void main(String[] args) {
        int[][] board = { { 1, 0, 0, 3 }, { 2, 0, 0, 0 }, { 0, 0, 0, 2 }, { 3, 0, 1, 0 } };
        int r = 1;
        int c = 0;

        // System.out.println(solution(board, r, c));

        System.out.println(move(1, 0, 2, 3, board));

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

            Queue<String> queue = new LinkedList<>();
            queue.add(r + " " + c + " " + 0);

            for (int num : sequence) {

                card[] card = new card[2];
                int i = 0;
                for (card temp : cards.get(num)) {
                    card[i] = temp;
                    i++;
                }

                int t3 = move(card[0].r, card[0].c, card[1].r, card[1].c, map);
                int t4 = move(card[1].r, card[1].c, card[0].r, card[0].c, map);

                Queue<String> candidate = new LinkedList<>();

                while (!queue.isEmpty()) {
                    String[] now = queue.poll().split(" ");

                    int nr = Integer.parseInt(now[0]);
                    int nc = Integer.parseInt(now[1]);
                    int count = Integer.parseInt(now[2]);

                    if (count >= answer) {
                        continue;
                    }

                    int t1 = move(nr, nc, card[0].r, card[0].c, map);
                    int t2 = move(nr, nc, card[1].r, card[1].c, map);

                    int c1 = count + t1 + t3;
                    int c2 = count + t2 + t4;
                    candidate.add(card[1].r + " " + card[1].c + " " + c1);
                    candidate.add(card[0].r + " " + card[0].c + " " + c2);

                }
                map[card[0].r][card[0].c] = 0;
                map[card[1].r][card[1].c] = 0;
                queue.addAll(candidate);
            }

            for (String result : queue) {
                String[] str = result.split(" ");
                if (Integer.parseInt(str[2]) < answer) {
                    answer = Integer.parseInt(str[2]);
                }
            }

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
                            break;
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