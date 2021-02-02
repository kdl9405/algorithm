package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 매칭점수
 * 테스트케이스 9,11,13,17 안됨.....ㅜㅜㅜㅜㅜㅜㅜㅜㅜ
 */
public class pro122 {

    public static void main(String[] args) {
        String word = "blind";
        String[] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>블라블라블라\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};

        System.out.println(solution(word, pages));

        
    }

    static public int solution(String word, String[] pages) {

        word = word.toLowerCase();

        HashMap<String, Integer> pageIndex = new HashMap<>();

        double[][] point = new double[pages.length][4]; // 0: index 1 : basic 2 : link 3 : total
        String[][] html = new String[pages.length][5]; // 1 : head 3 : body

        for (int i = 0; i < pages.length; i++) {
            String temp = pages[i].replaceAll("<head>", "@rayJump!");
            temp = temp.replaceAll("</head>", "@rayJump!");
            temp = temp.replaceAll("<body>", "@rayJump!");
            temp = temp.replaceAll("</body>", "@rayJump!");

            html[i] = temp.split("@rayJump!"); // 1 => head // 3 => body

            html[i][1] = html[i][1].replaceAll("<", "@rayJump!");
            html[i][1] = html[i][1].replaceAll(">", "@rayJump!");

            String[] str = html[i][1].split("@rayJump!");
            for(String s : str){
                if (s.contains("meta") && s.contains("\"https://")) {
                    String[] str2 = s.split("\"https://");
                    int ind = str2[1].indexOf("\"");
                    html[i][1] = "https://"+str2[1].substring(0, ind);
                }
            }
            
            // String[] str2 = str[1].split("\"/>");
            // html[i][1] = str2[0].substring(1, str2[0].length());

            System.out.println(html[i][1]);

            // html[i][1] = str[1].substring(1, str[1].length() - 4);
            pageIndex.put(html[i][1], i);
            point[i][0] = i;
        }

        for (int i = 0; i < pages.length; i++) {

            // html[i][3] = html[i][3].replaceAll("<a", "@rayJump!");
            // html[i][3] = html[i][3].replaceAll("</a>", "@rayJump!");
            html[i][3] = html[i][3].replaceAll("<", "@rayJump!");
            html[i][3] = html[i][3].replaceAll(">", "@rayJump!");
            String[] str = html[i][3].split("@rayJump!");

            HashSet<String> linkPage = new HashSet<>();

            for (String s : str) {

                // if (s.length()==0 || s.charAt(0) == '/') {
                //     continue;
                // }

                if (s.contains("a href=")) {
                    s = s.substring(8, s.length() - 1);
                    linkPage.add(s);
                } else {
                    s = s.replaceAll("[^a-z_^A-Z]", " ");
                    s = s.toLowerCase();
                    if (s.contains(word)) {
                        String[] wordStr = s.split(" ");
                        for (String w : wordStr) {
                            if (w.equals(word)) {
                                point[i][1]++;
                            }
                        }
                    }
                }
            }

            if (!linkPage.isEmpty()) {
                double linkPoint = (point[i][1] / (double) linkPage.size());
                for(String page : linkPage){
                    if (pageIndex.containsKey(page)) {
                        point[pageIndex.get(page)][2] += linkPoint;
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
