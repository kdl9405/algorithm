package programmers;

import java.util.*;

/*
    선입 선출 스케줄링

    정확도도 통과 못함 시브링너ㅔㄹ
*/
public class pro177 {

    public static void main(String[] args) {
        int n = 10;
        int[] cores = {2, 10, 1, 5};

        System.out.println(solution(n, cores));
    }

    static int solution(int n, int[] cores) {
        int answer = 0;

        int[][] arr = new int[cores.length][2]; // [0] = 시간 // [1] = 인덱스

        for (int i = 0; i < cores.length; i++) {
            arr[i][0] = cores[i];
            arr[i][1] = i + 1;
        }

        Arrays.sort(arr, (a1, a2) -> {
            if (a1[0] == a2[0]) {
                return a1[1] - a2[1];
            }
            return a1[0] - a2[0];
        });

        if (n <= cores.length) {
            answer = n;
        } else {
            int num = cores.length;
            long t = arr[0][0];

            loop: while (true) {

                for (int[] a : arr) {
                    if (a[0] > t) {
                        break;
                    }
                    if (t % a[0] == 0) {
                        num++;

                        System.out.println("time = " + t+ " " +a[1]+"번 코어 = "+ a[0] +"  작업  번호 = "+ num);

                        if (num == n) {
                            answer = a[1];
                            break loop;
                        }
                    }
                    
                }
                t++;
            }
        }
        return answer;
    }
}
