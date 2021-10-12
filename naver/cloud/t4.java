package naver.cloud;


/* 
    회의실의 사용 시간이 주어졌을때, 

    가장 많은 회의실을 사용하는 시간을 구해라
    여러개면 오름차순으로!!


    => 
        0. 최대시간(86400)까지 각 시간과 회의실 사용 갯수를 저장하는 int[][] 생성.
        1. 회의실 사용의 시작시간을 기준으로 정렬
        2. 누적합을 이용하여 최대 시간(86400)까지 그 값을 저장(회의실 사용이 종료된 것은 반영하지 못함)
        3. 회의실 사용의 종료시간을 기준으로 정렬
        4. 누적합을 이용하여 최대 시간(86400)까지 그 값을 빼줌(회의실 사용이 종료된 것을 반영)
        5. 각 시간별 회의실 사용갯수가 반영된 배열을 정렬하여, 최대값을 가진 시간만을 List에 저장후 배열로 변환하여 반환.

        즉, 정렬이 3번, 탐색이 3번 필요 (마지막 탐색은 최악의 경우에만 끝까지 탐색).
    
        
        => 시작 시간과 종료시간을 하나의 누적합으로 한번에 측정한다면 더 좋았을 듯.

        

*/

import java.util.*;

public class t4 {

    public static void main(String[] args) {

        int[][] info = { { 1, 5 }, { 3, 5 }, { 7, 8 }};

        // int[] ans = solution(info);

        // for(int a : ans){
        //     System.out.println(a);
        // }

        solution(info);
        solution2(info);
    }

    public static int[] solution(int[][] info) {
        List<Integer> answer = new ArrayList<>();

        Arrays.sort(info, (a, b) -> {
            return a[0] - b[0];
        });

        int[][] time = new int[86400][2];
        for (int i = 0; i < 86400; i++) {
            time[i][0] = i;
        }

        int count = 0;
        int s = 0;
        int t = info[0][0];

        while (t < 86400) {

            for (; s < info.length; s++) {
                if (info[s][0] == t) {
                    count++;
                } else {
                    break;
                }
            }

            time[t][1] = count;
            t++;
        }

        Arrays.sort(info, (a, b) -> {
            return a[1] - b[1];
        });

        count = 0;
        s = 0;
        t = info[0][1];

        while (t < 86400) {

            for (; s < info.length; s++) {
                if (info[s][1] < t) {
                    count++;
                } else {
                    break;
                }
            }
            time[t][1] -= count;
            t++;
        }

        Arrays.sort(time, (a,b)->{
            if(a[1] == b[1]){
                return a[0]-b[0];
            }
            return b[1] - a[1];
        });

        answer.add(time[0][0]);
        for(int i = 1; i<time.length; i++){
            if (time[i-1][1] > time[i][1]) {
                break;
            }
            answer.add(time[i][0]);
        }

        System.out.println(answer);
        

        return Arrays.stream(answer.toArray()).mapToInt(i -> (int)i).toArray();
    }



    public static int[] solution2(int[][] info) {
        List<Integer> answer = new ArrayList<>();
        
        int[][] time = new int[10][2];
        for (int i = 0; i < 10; i++) {
            time[i][0] = i;
        }

        for(int[] i : info){
            time[i[0]][1]++;
            if(i[1]<10){
                time[i[1]+1][1]--;
            }
        }

        for(int i = 1; i<10; i++){
            time[i][1] += time[i-1][1];
        }
        
        Arrays.sort(time, (a,b)->{
            if(a[1] == b[1]){
                return a[0]-b[0];
            }
            return b[1] - a[1];
        });

        answer.add(time[0][0]);
        for(int i = 1; i<time.length; i++){
            if (time[i-1][1] > time[i][1]) {
                break;
            }
            answer.add(time[i][0]);
        }

        System.out.println(answer);

        return Arrays.stream(answer.toArray()).mapToInt(i -> (int)i).toArray();
    }
}
