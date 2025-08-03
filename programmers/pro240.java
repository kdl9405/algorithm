package programmers;

// 2025 프로그래머스 코드챌린지 2차 예선
// 택배 상자 꺼내기


public class pro240 {

    public int solution(int n, int w, int num) {
        int numHeight = getHeight(num, w);
        int numIndex = getIndex(numHeight, num % w, w);

        int totalHeight = getHeight(n, w);
        int totalIndex = getIndex(totalHeight, n % w, w);

        int distance = totalHeight - numHeight;

        if (totalHeight % 2 == 1) {
            if (numIndex <= totalIndex)
                distance++;
        } else {
            if (numIndex >= totalIndex)
                distance++;
        }
        return distance;
    }

    private int getHeight(int number, int width) {
        return (number - 1) / width + 1;
    }

    private int getIndex(int row, int mod, int width) {
        if (mod == 0)
            mod = width;
        return row % 2 == 1 ? mod : width + 1 - mod;
    }
}
