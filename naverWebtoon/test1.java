package naverWebtoon;

/* 
    Q. 주어진 문자열에서 "x"를 제외하세요. 단, 문자열의 맨 앞 또는 맨 뒤에 "x"가 나타나는 경우는 제외하지 않습니다.
    ex) stringX("xxHxix") => "xHix"
        stringX("abxxxcd") => "abcd"
        stringX("xabxxxcdx") => "xabcdx"

*/

public class test1 {

    public static void main(String[] args) {

        String s = "xabxxxcdx";

        System.out.println(deleteX(s));

    }

    static String deleteX(String s) {

        StringBuilder sb = new StringBuilder();
        
        sb.append(s.charAt(0));

        String sub = s.substring(1, s.length() - 1);

        sb.append(sub.replaceAll("x", ""));

        sb.append(s.charAt(s.length() - 1));

        return sb.toString();

    }

}
