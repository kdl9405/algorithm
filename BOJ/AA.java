package BOJ;


import java.util.HashMap;
import java.util.HashSet;

public class AA {
    
    public static void main(String[] args) {
        String s = "VNBHEEKMRKMIKAXRVOMKQCFJMYTWQNGIIROYNTOLPSGRZDGRFJYITFFQJUQGEELBEWKMJLUALJAEWLBNREPFYRVOIIHLVAZWSSNZIISIAAVVVXVVZEWHEEAHPQYIELCAJMYTWMPPDPUZIBLVJKWLJQORVKMVVBXYWGHZYIIGZUQNTRJYABNHILBBUVWNSSAMVRUEUEBCENSSAMCIJOIEMQIEYYNVXIRYUVVNXTJCZQIECKUAWVXYLYZXZVVVVLINIEKYBNEYJLCPMWVLUYGZVMEKBVUNICXJUGNMTSFYGVRUAHGMGPVUNHIGPPSHQKMEWLMNJVXZFMCQMIUHYEAJRRLISQBLKULVUZFRLGNVJTVJUGMNMELBRNDGKAIAIGKFLBNUXMKQQVBCEJKCFBVRTWZEWHZRJCBCNWLHJBZOMEYWUIMETLYEADRTDOQQIKYAMOCOPVJUYNMIUHIYQXITGGZQNWZGHRZEMDYIELJRRFXIQBMCSHGMVPCAYFAPGYSMEWWMEMHYQFIDGMGAPTVJBRZJIJTUGUVRUGYFVJXGGMFMNWRFSVVCYDSHFCKIIHIJMMWYWXBMNLFOYIMMTFKMRANEXWHVCNPVNYYQIXVDFRKOEEVCFIKIVJFRANQRJNVIGEILCFBVRUZCFDVWKOYNTOLRXZBZYWYAGNVZBKJUBZYMESLLIMWVFUYWAAVSJBVMCRFXRYPMGEYABVPRJARINWFJNZMIXFXPVTGEZFMZIFILHVNBHEEKLBOPIJYUYTZVPAHPTPHZFAUQNRVEYFQNXYWDBSZV";

        String s2 ="mylsfsdcspylmyl";
        System.out.println(s.length());

        HashSet<String> hash = new HashSet<>();

        int length = 3;

        // for(int n = 0; n<26; n++){
        //     for(int i = 0; i<s.length()-length+1; i++){
        //         if (s.charAt(i) == 'A'+n) {
        //             String str = s.substring(i, i+length);
        //             String temp = s.substring(i+length, s.length());
                    
        //             for(int j = 0; j<temp.length()-length+1; j++){
        //                 if (temp.substring(j, j+length).equals(str)) {
                            
        //                     String str2 = temp.substring(j, j+length);
        //                     String temp2 = temp.substring(j+length, temp.length());                            
                            
        //                     if (temp2.contains(str)) {
        //                         hash.add(str);
        //                     }   
        //                 }
        //             }                  
                         
        //         }
        //     }
        //     System.out.println(hash);
        //     hash = new HashSet<>();
        // }   

        // for(int n = 0; n<26; n++){
        //     for(int i = 0; i<s.length()-length+1; i++){
        //         if (s.charAt(i) == 'A'+n) {
        //             String str = s.substring(i, i+length);
        //             String temp = s.substring(i+length, s.length());
                    
        //             for(int j = 0; j<temp.length()-length+1; j++){
        //                 if (temp.substring(j, j+length).equals(str)) {
                            
        //                     String str2 = temp.substring(j, j+length);
        //                     String temp2 = temp.substring(j+length, temp.length());                            
                            
        //                     if (temp2.contains(str)) {
        //                         hash.add(str);
        //                     }   
        //                 }
        //             }                  
                         
        //         }
        //     }
        //     System.out.println(hash);
        //     hash = new HashSet<>();
        // }   

        int start = 0;
        int end = 0;

        for(int i = 0; i<s.length()-2; i++){
            if (s.substring(i,i+3).equals("HEE")) {
                System.out.println(i-start);
                start = i;
                
            }
        }
    }



   
}
