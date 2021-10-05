package naverWebtoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
    # 모음의 순서를 바꾸는 함수

- hello -> holle
- naver webtoon => novor webtean

*/

public class test {
    
    public static void main(String[] args) throws IOException {
        


        String s = "naver webtoon";


        System.out.println(changeS(s));


    }

    static String changeS(String s){

        Stack<Character> alph = new Stack<>();

        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);

            if (c == 'a' || c == 'e' || c=='i' || c=='o' || c== 'u') {
                alph.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);

            if (c == 'a' || c == 'e' || c=='i' || c=='o' || c== 'u') {
                sb.append(alph.pop());
            }else{
                sb.append(c);
            }
        }

        return sb.toString();

    }



    /* 
    ## 입력받은 영문자에 대해서 대문자는 소문자로, 소문자는 대문자로 변경하는 함수를 작성해주세요.
예시)

- Hello World -> hELLO wORLD
- Naver Webtoon -> nAVER wEBTOON

A = 65 / Z = 90
a = 97 / z = 122
    
    */


    static String changeA(String s ){

        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){

            if (c == ' ') {
                sb.append(' ');
            }else if (c - 'a' >= 0) {
                ch a = c - 
            }else{
                sb.append((char)())
            }

            
        }
    }
}
