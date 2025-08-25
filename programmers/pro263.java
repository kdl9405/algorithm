package programmers;

public class pro263 {
    public int[] solution(int[][] edges) {

        // 1) 정점을 찾는다...
        // 들어온것은 없고,, 나간것은 2개 이상..

        // 2) 들어온거 나간거 개수 저장
        // 3) 각 그래프의 정점의 in/out 특징으로 찍어맞춘다..
        // 정점 : 0개 들어오고 2개이상 나간거..
        // 도넛 : ??? -> 정점의 아웃 - (막대+8자)
        // 막대 : 들어온건 있으나,, 나간게 없는거의 개수
        // 8자 : 2개이상 들어오고 2개 나간거..

        int[] in = new int[1000001];
        int[] out = new int[1000001];

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            out[a]++;
            in[b]++;

        }

        int point = 0;
        int donut = 0;
        int stick = 0;
        int eight = 0;

        for (int i = 1; i <= 1000000; i++) {
            if (in[i] == 0 && out[i] > 1) {
                point = i;
            } else if (in[i] >= 1 && out[i] == 0) {
                stick++;
            } else if (in[i] >= 2 && out[i] == 2) {
                eight++;
            }
        }

        donut = out[point] - stick - eight;


        int[] answer = new int[] {point, donut, stick, eight};


        return answer;
    }
}
