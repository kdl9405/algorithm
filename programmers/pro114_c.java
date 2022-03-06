package programmers;

//[카카오 인턴] 키패드 누르기

public class pro114_c {

    public static void main(String[] args) {

        int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
        String hand = "right";

        System.out.println(solution(numbers, hand));

    }

    public static String solution(int[] numbers, String hand) {
        
        StringBuilder sb = new StringBuilder();
        
        left = new int[]{3,0};
        right = new int[]{3,2};
        
        for(int number : numbers){
            if(number == 1 || number == 4 || number == 7){
                sb.append("L");
                left = point[number];
            }
            else if(number == 3 || number == 6 || number == 9){
                sb.append("R");
                right = point[number];
            }else {
                int disL = Math.abs(left[0]-point[number][0]) + Math.abs(left[1]-point[number][1]);
                int disR = Math.abs(right[0]-point[number][0]) + Math.abs(right[1]-point[number][1]);
               
                if(disL < disR){
                    sb.append("L");
                    left = point[number];
                }else if(disL > disR){
                     sb.append("R");
                     right = point[number];
                }else{
                    if(hand.equals("right")){
                        sb.append("R");
                        right = point[number];
                    }else {
                         sb.append("L");
                        left = point[number];
                    }
                }
            }
        }
        
        return sb.toString();
        
    }
    
    static int[][] point = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
    static int[] left;
    static int[] right;
}