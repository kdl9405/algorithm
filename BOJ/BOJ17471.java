package BOJ;

import java.io.*;
import java.util.*;

/**
 * 게리맨더링
 * 
 * = > 구역을 순회하면서 N/2 까지 넓혀가는 식으로 리펙토링 시도해야함.... 그러면 시간 단축될듯.
 */
public class BOJ17471 {

    // 1. List<List<Integer>> 로 각 구역별 연결 구역을 저장
    // 2. 인구의 합을 구해서 최소가 0인지 1인지 구함.
    // 3. 구역들을 두 선거구로 나눌 수 있는 모든 경우의 수을 구하고 가능성 체크 후 인구차이 구함

    static int N, total;
    static int[] population;
    static List<List<Integer>> link;
    static boolean[] visit;
    static HashSet<Integer> partition;
    static int min;
    static boolean possible;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visit = new boolean[N + 1];

        population = new int[N + 1];
        total = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            total += population[i];
        }
     
        link = new ArrayList<>();
        link.add(new ArrayList<>());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            link.add(new ArrayList<>());
            while (j-- > 0) {
                link.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        min = Integer.MAX_VALUE;
        possible = false;
        for (int i = 1; i <= N / 2; i++) {
            // 선거구 나누기 i=> 구역의 수
            partition = new HashSet<>();
            nCr(i, 0, 1);
        }

        if (!possible) {
            min = -1;
        }

        System.out.println(min);


    }

    static void nCr(int r, int depth, int idx) {

        if (depth == r) {
            // 가능성 체크 -> 가능하면 인구차이 갱신

            if(possibleLink(r)){
                possible = true;
                int count = 0;
                for(Integer p : partition){
                    count += population[p];
                }
                
                min = Math.min(min, Math.abs((total-count)-count));                
            }
            return;
        }

        for (int i = idx; i <= N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                partition.add(i);
                nCr(r, depth + 1, i + 1);
                partition.remove(i);
                visit[i] = false;
            }
        }
    }

    static boolean possibleLink(int r) {

        boolean[] linked = new boolean[N+1];

        boolean A = false;
        boolean B = false;

        for (int i = 1; i <= N; i++) {
            if (partition.contains(i) && !A) {

                A = true;

                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                linked[i] = true;
                int count = 0;

                while (!queue.isEmpty()) {
                    int now = queue.poll();
                    count++;
                    for (Integer next : link.get(now)) {
                        if (!linked[next] && partition.contains(next)) {
                            linked[next] = true;
                            queue.add(next);
                        }
                    }
                }

                if (count != r) {
                    return false;
                }

            } else if (!partition.contains(i) && !B) {

                B = true;

                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                linked[i] = true;
                int count = 0;

                while (!queue.isEmpty()) {
                    int now = queue.poll();
                    count++;
                    for (Integer next : link.get(now)) {
                        if (!linked[next] && !partition.contains(next)) {
                            linked[next] = true;
                            queue.add(next);
                        }
                    }
                }
                if (count != N-r) {
                    return false;
                }

            }
        }

        return true;

    }

}