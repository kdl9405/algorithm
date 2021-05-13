package programmers.month2105;

// 

public class sol3_copy {

    public static void main(String[] args) {

        String[] s = {"0111111010"};

        String[] answer = solution(s);

        for(String a : answer){
            System.out.println(a);
        }

        // find("10");
    }

    public static String[] solution(String[] s) {

        for(int i = 0; i<s.length; i++){
        
            if (s[i].contains("110")) {
                s[i] = find(s[i].replaceFirst("110", ""));
            }
        }

        return s;
    }


    static String find(String x){


        if (x.contains("111")) {
            x = x.replaceFirst("111", "1101 11");
            String[] str = x.split(" "); 
            
            if (str[1].contains("110")) {
                str[1] = find(str[1].replaceFirst("110", ""));
            }

            return str[0]+str[1];

        }else{
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
               
           }else if(i>2){
               break;
           }
        }
       
        return s;
        }

        
    }

}
