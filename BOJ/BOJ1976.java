package BOJ;

import java.io.*;
import java.util.*;

/*
    여행 가자
*/

public class BOJ1976 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];

        for(int i = 1; i<=n; i++){
            parent[i] = i;
        }

        for (int i = 1; i <=n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = findParent(i);

            for(int j = 1; j<=n; j++){

                int link = Integer.parseInt(st.nextToken());

                if(i == j || link == 0){
                    continue;
                }

                int b = findParent(j);

                if (a != b) {
                    parent[b] = a; 
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        int x = findParent(Integer.parseInt(st.nextToken()));
        String answer = "YES";

        for(int i = 1; i<m; i++){
            if (x != findParent(Integer.parseInt(st.nextToken()))) {
                answer = "NO";
                break;
            }
        }

        System.out.println(answer);

    }

    static int[] parent;

    static int findParent(int x) {

        if (parent[x] == x) {
            return x;
        }

        return parent[x] = findParent(parent[x]);

    }
}
