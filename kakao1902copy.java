/**
 * kakao1902
 */

 /**
  * kakao1902 copy
  */
 
     
 
public class kakao1902copy {

    public static void main(String[] args) {

        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";

        s = s.replace("{{", "");
        s = s.replace("}}", "");
        s = s.replace("},{", " ");
        

        System.out.println(s);

        String[] input = s.split(" ");

        for (int j = 0; j < input.length - 1; j++) {
            for (int n = j; n < input.length; n++) {

                if (input[j].length() > input[n].length()) {
                    String temp = input[n];
                    input[n] = input[j];
                    input[j] = temp;
                }
            }
        }


        int[] answer = new int[input.length];
        answer[0] = Integer.parseInt(input[0]);

        for(int i = 1; i<input.length; i++){ 

            String[] temp = input[i].split(",");

            for(int x = 1; x< temp.length; x++){
                if (answer[i-0] != Integer.parseInt(temp[x])){
                    answer[i] = Integer.parseInt(temp[x]);
                    
                }
            }

        }
        for (int y = 0; y<answer.length;y++){
            System.out.println(input[y]);
        }
    }

    public static int[] solution(String s) {

        int[] answer = {};
        
        return answer;
    }

}