package programmers.month2105;

// 메모리초과

public class sol3 {

    public static void main(String[] args) {

        String[] s = {"1110","100111100","0111111010"};

        String[] answer = solution(s);

        for(String a : answer){
            System.out.println(a);
        }

        // find("10");
    }

    public static String[] solution(String[] s) {
        String[] answer = new String[s.length];


        for(int i = 0; i<s.length; i++){

            String min = s[i];

            for(int j = 0; j<s[i].length()-2; j++){
                if (s[i].charAt(j) == '1' && s[i].charAt(j+1) == '1' &&  s[i].charAt(j+2) == '0') {
                    
                    String x = s[i].substring(0,j);
                    if (j+3 < s[i].length()) {
                        x+=s[i].substring(j+3,s[i].length());
                    }

                    String temp = find(x);

                    if (min.compareTo(temp)>0) {
                        min = temp;
                    }

                    j+=2;
                }
            }

            answer[i] = min;
        }

        return answer;
    }


    static String find(String x){
        String s = "110"+x;

        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder().append(x);
        StringBuilder temp;
        for(int i = 0; i<x.length(); i++){
            temp = new StringBuilder();            
            left.append(right.charAt(0));
            right.deleteCharAt(0);

            temp.append(left).append("110");

           if (s.compareTo(temp.toString())>0) {

               if (right.toString().contains("110")) {

                    temp.append(find(right.toString().replaceFirst("110", "")));

               }else{
                   temp.append(right);
               }

               s = temp.toString();
           }
        }
       
        return s;
    }

}
