package programmers;

// [1차] 비밀지도

public class pro115 {
    public static void main(String[] args) {
        
        int n = 5;
        int[] arr1 ={9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        String[] s = solution(n, arr1, arr2);
        for(String st : s){
            System.out.println(st);
        }
        
    }
    static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i = 0; i<n; i++){
            String num1 = Integer.toBinaryString(arr1[i]);
            String num2 = Integer.toBinaryString(arr2[i]);

            while (num1.length() < n) {
                num1 = "0"+num1;
            }
            while (num2.length() < n) {
                num2 = "0"+num2;
            }

            StringBuilder sb = new StringBuilder();
            for(int j = 0; j<n; j++){
                if (num1.charAt(j) == '0' && num2.charAt(j) == '0') {
                    sb.append(" ");
                }else{
                    sb.append("#");
                }
            }
            
            answer[i] = sb.toString();
            
        }


        return answer;
    }
}
