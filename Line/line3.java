public class line3 {
    public static void main(String[] args) {
        
        int[] answer = solution(9);
        // String num = "0123456";

        // String A = num.substring(0, 3);
        // String B = num.substring(3, num.length());

        // System.out.println(A+" "+B);
        System.out.println(answer[0]+" "+answer[1]);

    }   
    static int[] solution(int n) {
        int[] answer = new int[2];
        
        if (n<10) {
            answer[0] = 0;
            answer[1] = n;
            return answer;
        }

        String number = Integer.toString(n);

        while (number.length() != 1) {

            int point = number.length()/2;     

            if (number.charAt(point) == '0') {
                int count = 1;
                while (true) {
                    if (number.charAt(point+count) != '0') {
                        point += count;
                        break;
                    }else if (number.charAt(point-count) != '0') {
                        point -= count;
                        break;
                    }
                    count++;
                }
            }



            String A = number.substring(0, point);
            String B = number.substring(point, number.length());

            int sum = Integer.parseInt(A) + Integer.parseInt(B);
            number = Integer.toString(sum);
            answer[0]++;
        }
        answer[1] = Integer.parseInt(number);       

        return answer;
    }
}
