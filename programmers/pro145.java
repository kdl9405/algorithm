package programmers;

/* 
    시저 암호

*/
public class pro145 {
    public static void main(String[] args) {
        String s = "z";
        int n = 1;

        System.out.println(solution(s, n));

    }
    static String solution(String s, int n) {
         String answer = "";
        
        char[] arr = s.toCharArray();
        
        for(int i= 0; i<arr.length; i++){
            
            if(arr[i] == ' '){
                continue;
            }
           
            if(arr[i] >= 'a' && arr[i] <='z'){

                arr[i] = (char)(arr[i]+n);
                System.out.println(arr[i]);
                if(arr[i] > 'z'){
                    arr[i] = (char)(arr[i]-26);
                }
            }else{
                arr[i] = (char)(arr[i]+n);
                if(arr[i] > 'Z'){
                    arr[i] =(char)(arr[i]-26);
                }
            } 
        }
        answer = new String(arr);
        
        return answer;
    }
}