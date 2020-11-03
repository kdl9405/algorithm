package kakao.test1;

/**
 * Solution
 */
public class Solution {

    public static void main(String[] args) {

        int[] numbers = { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 };
        // L R L R RRLLRRR
        String hand = "left";

        String answer = solution(numbers, hand);

        System.out.println(answer);

        
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        String[][] point = new String[3][4];
        point[0][3] = "L";
        point[2][3] = "R";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {

                for (int x = 0; x < 2; x++) {
                    for (int y = 0; y < 4; y++) {
                        if (point[x][y] == "L") {
                            point[x][y] = null;
                        }
                    }
                }

                switch (numbers[i]) {
                    case 1:
                        point[0][0] = "L";
                        break;

                    case 4:
                        point[0][1] = "L";
                        break;
                    case 7:
                        point[0][2] = "L";
                        break;
                }
                sb = sb.append("L");

            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                for (int x = 1; x < 3; x++) {
                    for (int y = 0; y < 4; y++) {
                        if (point[x][y] == "R") {
                            point[x][y] = null;
                        }
                    }
                }

                switch (numbers[i]) {
                    case 3:
                        point[2][0] = "R";
                        break;

                    case 6:
                        point[2][1] = "R";
                        break;
                    case 9:
                        point[2][2] = "R";
                        break;
                }
                sb = sb.append("R");
            } else {

                int[] lPoint = new int[2];
                int[] rPoint = new int[2];
                int[] xPoint = new int[2];
                int lDis = 0;
                int rDis = 0;

                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 4; y++) {

                        if (point[x][y] == "L") {
                            lPoint[0] = x;
                            lPoint[1] = y;

                        } else if (point[x][y] == "R") {
                            rPoint[0] = x;
                            rPoint[1] = y;

                        }
                        System.out.println("L 위치 : " + lPoint[0] + lPoint[1] + "R 위치 : " + rPoint[0] + rPoint[1]);
                        // System.out.println("R 위치 : " + rPoint[0] + rPoint[1]);
                    }
                }

                switch (numbers[i]) {

                    case 2:
                        xPoint[0] = 1;
                        xPoint[1] = 0;
                        break;
                    case 5:
                        xPoint[0] = 1;
                        xPoint[1] = 1;

                        break;
                    case 8:
                        xPoint[0] = 1;
                        xPoint[1] = 2;
                        break;
                    case 0:
                        xPoint[0] = 1;
                        xPoint[1] = 3;
                        break;
                }

                lDis = Math.abs(xPoint[0] - lPoint[0]) + Math.abs(xPoint[1] - lPoint[1]);
                rDis = Math.abs(xPoint[0] - rPoint[0]) + Math.abs(xPoint[1] - rPoint[1]);

                if (lDis < rDis) {
                    point[lPoint[0]][lPoint[1]] = null;
                    point[xPoint[0]][xPoint[1]] = "L";
                    sb.append("L");
                } else if (rDis < lDis) {
                    point[rPoint[0]][rPoint[1]] = null;
                    point[xPoint[0]][xPoint[1]] = "R";
                    sb.append("R");
                } else if (rDis == lDis) {
                    switch (hand) {
                        case "left":
                            point[lPoint[0]][lPoint[1]] = null;
                            point[xPoint[0]][xPoint[1]] = "L";
                            sb.append("L");

                            break;

                        case "right":
                            point[rPoint[0]][rPoint[1]] = null;
                            point[xPoint[0]][xPoint[1]] = "R";
                            sb.append("R");
                            break;
                    }
                }

            }

        }
        answer = sb.toString();
        return answer;
    }
}
