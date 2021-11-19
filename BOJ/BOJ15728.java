package BOJ;

/* 
    에리 - 카드

    1. 공유카드는 가장 작은 수와 가장 큰 수만 고려하면 됨(작은 수는 마이너스 값끼리의 곱을 위해서.)
    2. 팀숫자카드를 순회하여 공유카드의 작은수, 큰수와의 곱 중 큰수를 저장
    3. 저장된 값을 담고 있는 배열을 정렬한 후, K+1번째 수를 반환
*/

import java.io.*;
import java.util.*;

public class BOJ15728 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int maxShare = -10000;
        int minShare = 10000;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            int x = Integer.parseInt(st.nextToken());

            maxShare = Math.max(maxShare, x);
            minShare = Math.min(minShare, x);
        }

        int[] teamCard = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] point = new int[N];

        for(int i = 0; i<N; i++){
            point[i] = Math.max(teamCard[i]*maxShare, teamCard[i]*minShare);
        }

        Arrays.sort(point);

        System.out.println(point[N-K-1]);
    }
}
