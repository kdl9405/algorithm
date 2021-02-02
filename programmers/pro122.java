package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
 * 
 * 매칭점수 
 * 
 *  뭐가 문제냐야앙아아아아아아아앙 9 11 13 17!!!!!!!!!!!
 */
public class pro122 {

    public static void main(String[] args) {
        String word = "Muzi";
        String[] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"};

        System.out.println(solution(word, pages));

        
    }

    static public int solution(String word, String[] pages) {

        word = word.toLowerCase();

        HashMap<String, Integer> pageIndex = new HashMap<>();

        double[][] point = new double[pages.length][4]; // 0: index, 1 : basic, 2 : link, 3 : total
        String[][] html = new String[pages.length][5]; // 1 : head, 3 : body

        for (int i = 0; i < pages.length; i++) {  // 해당 URL 찾고 인덱스 번호 연결
            String temp = pages[i].replaceAll("<head>", "@rayJump!");
            temp = temp.replaceAll("</head>", "@rayJump!");
            temp = temp.replaceAll("<body>", "@rayJump!");
            temp = temp.replaceAll("</body>", "@rayJump!");

            html[i] = temp.split("@rayJump!"); // 1 => head // 3 => body

            html[i][1] = html[i][1].replaceAll("<", "@rayJump!");
            html[i][1] = html[i][1].replaceAll(">", "@rayJump!");

            String[] str = html[i][1].split("@rayJump!");

            loop:
            for(String s : str){
                if (s.contains("meta") && s.contains("https://")) {
                    String[] str2 = s.split("\"");
                    for(String ss : str2){
                        if (ss.contains("https://")) {
                            html[i][1] = ss;
                            break loop;
                        }
                    }
                }
           }

            pageIndex.put(html[i][1], i);
            point[i][0] = i;
        }

        for(int i = 0; i< pages.length; i++){ // 기본점수 
            String temp = pages[i].replaceAll("[^a-z_^A-Z]", " ");
            temp = temp.toLowerCase();
            String[] str = temp.split(" ");

            for(String s : str){
                if (s.equals(word)) {
                    point[i][1]++;
                }
            }
        }


        for (int i = 0; i < pages.length; i++) {  // a 태그 안에 있는 외부 링크 
            String[] str = pages[i].split(">");
            
            HashSet<String> linkPage = new HashSet<>();

            for(String s : str){
                if (s.contains("<a")) {
                    String[] str2 = s.split("href=\"");
                    str2 = str2[1].split("\"");
                    linkPage.add(str2[0]);
                }
            }
            if (!linkPage.isEmpty()) {
                double linkpoint = point[i][1] / (double)linkPage.size();
                for(String p : linkPage){
                    if (pageIndex.containsKey(p)) {
                        point[pageIndex.get(p)][2] += linkpoint;
                    }
                }
            }
        }

        for(int i = 0; i<point.length; i++){
            point[i][3] = point[i][1]+ point[i][2];
        }

        Arrays.sort(point, (p1, p2) ->{
            if (p1[3] == p2[3]) {
                return (int) (p1[0] - p2[0]);
            }else{
                return (int) ((p2[3] * 100) - (p1[3] * 100));
            }
        });

        for(double[] p : point){
            System.out.println(p[0] + " = "+p[1]+"-"+p[2]+"-"+p[3]);
        }

        return (int)point[0][0];
    }
}
