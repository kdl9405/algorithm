package programmers;

/* 
    양궁대회
*/
public class pro232 {

    public static void main(String[] args) {

        new pro232().test();
    }

    void test() {
        int n = 9;
        int[] info = { 0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};

        int[] A = solution(n, info);
        for (int a : A) {
            System.out.print(a + " ");
        }
    }

    public int[] solution(int n, int[] info) {

        answer = new int[11];
        
        distance = 0;

        temp = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, n };
        backTracking(1, 0, 0, info);

        if (distance <= 0) {
            answer = new int[] { -1 };
        }
        return answer;
    }

    int[] temp;
    int[] answer;
    int distance;

    void backTracking(int point, int apeach, int ryan, int[] info) {

        if (point == 11) {

            if (distance <= ryan - apeach) {
                distance = ryan - apeach;

                for (int i = 0; i <= 10; i++) {
                    answer[i] = temp[i];
                }
            }

            return;
        }

        if (info[10 - point] == 0) {
            backTracking(point + 1, apeach, ryan, info);
        } else {
            backTracking(point + 1, apeach + point, ryan, info);
        }

        if (temp[10] > info[10 - point]) {
            temp[10 - point] = info[10 - point] + 1;
            temp[10] -= temp[10 - point];

            backTracking(point + 1, apeach, ryan + point, info);

            temp[10] += temp[10 - point];
            temp[10 - point] = 0;
        }

    }

}
