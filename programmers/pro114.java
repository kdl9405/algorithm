package programmers;

//[카카오 인턴] 키패드 누르기

public class pro114 {

    public static void main(String[] args) {

        int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
        String hand = "right";

        System.out.println(solution(numbers, hand));

    }

    static String solution(int[] numbers, String hand) {

        StringBuilder sb = new StringBuilder();

        char H = Character.toUpperCase(hand.charAt(0));

        int[][] numP = new int[10][2];
        for (int i = 1; i < 10; i++) {
            numP[i][0] = i / 3 + 1;
            numP[i][1] = i % 3;
            if (numP[i][1] == 0) {
                numP[i][0]--;
                numP[i][1] = 3;
            }
        }
        numP[0][0] = 4;
        numP[0][1] = 2;

        int[] rP = new int[2];
        int[] lP = new int[2];

        rP[0] = 4;
        rP[1] = 3;
        lP[0] = 4;
        lP[1] = 1;

        for (int n : numbers) {
            switch (n) {
                case 1:
                case 4:
                case 7:
                    sb.append("L");
                    lP[0] = numP[n][0];
                    lP[1] = numP[n][1];

                    break;

                case 3:
                case 6:
                case 9:
                    sb.append("R");
                    rP[0] = numP[n][0];
                    rP[1] = numP[n][1];

                    break;

                case 0:
                case 2:
                case 5:
                case 8:
                    int lD = Math.abs(lP[0] - numP[n][0]) + Math.abs(lP[1] - numP[n][1]);
                    int rD = Math.abs(rP[0] - numP[n][0]) + Math.abs(rP[1] - numP[n][1]);

                    if (lD < rD) {
                        sb.append("L");
                        lP[0] = numP[n][0];
                        lP[1] = numP[n][1];
                    } else if (rD < lD) {
                        sb.append("R");
                        rP[0] = numP[n][0];
                        rP[1] = numP[n][1];
                    } else {
                        sb.append(H);
                        if (H == 'R') {
                            rP[0] = numP[n][0];
                            rP[1] = numP[n][1];
                        }else{
                            lP[0] = numP[n][0];
                        lP[1] = numP[n][1];
                        }
                    }

                    break;
            }
        }

        return sb.toString();

    }

}
