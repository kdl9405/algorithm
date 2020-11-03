import java.io.*;
import java.net.URL;

/**
 * Crawling
 */
public class Crawling {

    public static void main(String[] args) throws UnsupportedEncodingException, IOException {

        URL url = new URL("https://finance.naver.com/");

        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "euc-kr"));

        String line;
        boolean check = false;

        while ((line = br.readLine()) != null) {

            if (line.contains("/marketindex/exchangeDetail.nhn?marketindexCd=")) {
                check = true;
            }
            if (line.contains("/marketindex/?tabSel=exchange#tab_section")) {
                check = false;
            }

            if (check) {
                if (line.contains("/marketindex/exchangeDetail.nhn?marketindexCd=")) {
                    String temp = line.split(">")[2].split("<")[0];
                    temp = temp.trim();
                    System.out.println(temp);
                }

                if (line.contains("<td>") && !line.contains("em")) {
                    String temp = line.split(">")[1].split("<")[0];
                    System.out.println(temp);
                }
                if (line.contains("td") && line.contains("em")) {
                    String temp = line.split(">")[5].split("<")[0];
                    System.out.print(temp);
                    String temp2 = line.split(">")[3].split("<")[0];
                    System.out.println(" " + temp2);
                    System.out.println();
                }
            }
        }
    }
}