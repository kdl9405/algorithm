package codility;

/**
 * d2
 */
public class d2 {

    public static void main(String[] args) {

    }

    public String solution(String S) {
        // write your code in Java SE 8
 
        int min = Integer.MAX_VALUE;

        String[] line = S.split("\n");

        for (String s : line) {

            String name = s.substring(11);
            String[] data = name.split("\\.");
            if (data[1].equals("doc") || data[1].equals("xls") || data[1].equals("pdf")) {

                String owner = s.substring(0, 6);
                if (owner.equals("  root")) {
                    String perm = s.substring(7, 10);
                    if (perm.charAt(0) == 'r' && perm.charAt(1) == '-'){
                        min = Math.min(min, name.length());
                    }
                }

            } else {
                min = Math.min(min, name.length());
            }

        }

        if(min == 0){
            return "NO FILES";
        }

        return Integer.toString(min);
    }
}