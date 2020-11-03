import java.util.*;

//파일명 정렬
public class pro3 {

    public static void main(String[] args) {

        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};

        

        solution(files);
        
    }

    static String[] solution(String[] files) {
        String[] answer = {};

        Arrays.sort(files);

        String[][] temp = new String[files.length][3];

        for(int i = 0; i<files.length-1;i++){
            
            int x = 0;
            for(x = 0; x<files[i].length();x++){
                if(Character.isDigit(files[i].charAt(x))){
                    break;
                }
            }

            
            
        }

        
        for(int i = 0; i<files.length; i++){
            System.out.println(files[i]);
        }



        return answer;
    }
}