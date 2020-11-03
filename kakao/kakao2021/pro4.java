package kakao.kakao2021;

import java.util.Arrays;

public class pro4 {

    public static void main(String[] args) {

        int[][] fares = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};

        System.out.println(solution(7,3, 4, 1, fares));


    }

    static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;

        for(int[] f : fares){
            if (f[0] > f[1]) {
                int temp = f[0];
                f[0] = f[1];
                f[1] = temp;
            }
        }

        Arrays.sort(fares, (f1, f2) ->{
            return f1[0] - f2[0];
        });

        for(int i = 0; i<fares.length; i++){
            if (fares[i][0] == s || fares[i][1] == s) {
                
            }
        }

        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        



       

        return answer;
    }
}
