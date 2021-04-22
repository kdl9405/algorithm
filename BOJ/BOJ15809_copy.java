package BOJ;

import java.io.*;
import java.util.*;

/**
 * 전국시대
 * 
 * 1) root로 그룹을 묶어서 표현 2) root을 찾은 후 전투 및 병력 계산.
 * 
 *      정렬 시 Arrays.sort 활용
 *      java 8 : 384ms
 *      java 11 : 560ms
 */
public class BOJ15809_copy {

    static int[] militaly;
    static int[] root;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        root = new int[N + 1];
        militaly = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            root[i] = i;
            militaly[i] = Integer.parseInt(br.readLine());
        }

        int P, Q;
        int nation = N;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            String O = st.nextToken();
            P = findRoot(Integer.parseInt(st.nextToken()));
            Q = findRoot(Integer.parseInt(st.nextToken()));

            if (O.equals("1")) { // 동맹

                root[Q] = P;
                militaly[P] += militaly[Q];
                nation--;

            } else { // 전투
                if (militaly[P] == militaly[Q]) {
                    root[P] = 0;
                    root[Q] = 0;
                    nation-=2;
                } else if (militaly[P] > militaly[Q]) {
                    militaly[P] -= militaly[Q];
                    root[Q] = P;
                    nation--;
                } else {
                    militaly[Q] -= militaly[P];
                    root[P] = Q;
                    nation--;
                }
            }
        }

        int[] mArr = new int[nation];

        int index = 0;
        for (int i = 1; i <= N; i++) {
            if (root[i] == i) {                
                mArr[index++] = militaly[i]; 
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(nation+"\n");

        Arrays.sort(mArr);
        for(int m : mArr){
            sb.append(m +" ");
        }
        System.out.println(sb.toString());
    }

    static int findRoot(int n) {
        if (root[n] == n) {
            return n;
        }
        return root[n] = findRoot(root[n]);
    }

}