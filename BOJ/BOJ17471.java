package BOJ;

import java.io.*;
import java.util.*;

/**
 * 게리맨더링
 */
public class BOJ17471 {

    // 1. List<List<Integer>> 로 각 구역별 연결 구역을 저장
    // 2. 인구의 합을 구해서 최소가 0인지 1인지 구함.
    // 3. 구역들을 두 선거구로 나눌 수 있는 모든 경우의 수을 구하고 가능성 체크 후 인구차이 구함

    static int N;
    static int[] population;
    static List<List<Integer>> link;
    static boolean[] visit;
    static HashSet<Integer> partion;
    static int min;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visit = new boolean[N + 1];

        population = new int[N + 1];
        int total = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            total += population[i];
        }
        if (total % 2 == 0) {
            total = 0;
        } else {
            total = 1;
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
        for (int i = 1; i < N / 2; i++) {
            // 선거구 나누기 i=> 구역의 수
        }

    }

    static void nCr(int r, int depth, int idx) {

        if (depth == r) {
            // 가능성 체크 -> 가능하면 인구차이 갱신

            return;
        }

        for (int i = idx; i <= N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                partion.add(i);
                nCr(r, depth + 1, i + 1);
                partion.remove(i);
            }
        }
    }

    static void possibleLink(int r){

        boolean[] linked = new boolean[r];
        
        
        
    }
}