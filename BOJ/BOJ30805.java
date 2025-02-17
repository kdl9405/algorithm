package boj;

import java.io.*;
import java.util.*;

public class BOJ30805 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] A = br.readLine().split(" ");
        int M = Integer.parseInt(br.readLine());
        String[] B = br.readLine().split(" ");

        List<String> aList = new ArrayList<>(Arrays.asList(A)); // 순서 유지
        List<String> bList = new ArrayList<>(Arrays.asList(B)); // 순서 유지
        Set<String> shareSet = new HashSet<>(aList); // 빠른 검색용
        shareSet.retainAll(bList);

        if (shareSet.isEmpty()) {
            System.out.println(0);
            return;
        }

        List<String> shareWords = new ArrayList<>();
        for (String s : A) {
            if (shareSet.contains(s)) {
                shareWords.add(s);
            }
        }
        Collections.sort(shareWords, Comparator.reverseOrder());

        List<String> filteredA = filterList(A, shareSet);
        List<String> filteredB = filterList(B, shareSet);

        List<String> lastSubsequence = findLastSubsequence(filteredA, filteredB, shareWords);

        System.out.println(lastSubsequence.size());
        System.out.println(String.join(" ", lastSubsequence));
    }

    static List<String> filterList(String[] original, Set<String> shareList) {
        List<String> filteredList = new ArrayList<>();
        for (String s : original) {
            if (shareList.contains(s)) {
                filteredList.add(s);
            }
        }
        return filteredList;
    }

    static List<String> findLastSubsequence(List<String> filteredA, List<String> filteredB, List<String> sharewWords) {

        List<String> subsequence = new ArrayList<>();

        int aIndex = 0;
        int bIndex = 0;

        for(String word : sharewWords){

            int aNextIndex = findIndex(filteredA, aIndex, word);
            int bNextIndex = findIndex(filteredB, bIndex, word);

            if(aNextIndex == filteredA.size() || bNextIndex == filteredB.size()){
                continue;
            }

            subsequence.add(word);
            aIndex = aNextIndex+1;
            bIndex = bNextIndex+1;
        }

        return subsequence;

    }

    static int findIndex(List<String> list, int index ,String word) {
        for (int i = index; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                return i;
            }
        }
        return list.size();
    }

    // 시간초과

    // public static void main(String[] args) throws NumberFormatException, IOException {

    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //     N = Integer.parseInt(br.readLine());
    //     A = br.readLine().split(" ");
    //     M = Integer.parseInt(br.readLine());
    //     B = br.readLine().split(" ");

    //     Set<String> aSet = Arrays.stream(A).collect(Collectors.toSet());
    //     Set<String> bSet = Arrays.stream(B).collect(Collectors.toSet());

    //     List<String> shareWords = new ArrayList<>(aSet);
    //     shareWords.retainAll(bSet);

    //     if (shareWords.isEmpty()) {
    //         System.out.println(0);
    //         return;
    //     }

    //     Collections.sort(shareWords);
    //     String lastWord = shareWords.get(shareWords.size() - 1);

    //     int i = findFirstIndex(A, lastWord);
    //     int j = findFirstIndex(B, lastWord);

    //     Set<List<String>> subSequences = new HashSet<>();
    //     List<String> initialSequence = new ArrayList<>();
    //     initialSequence.add(lastWord);
    //     findSubSequences(i + 1, j + 1, initialSequence, subSequences);


    //     List<List<String>> sortedSubSequences = new ArrayList<>(subSequences);
    //     sortedSubSequences.sort((o1, o2) -> {
    //         String str1 = String.join(" ", o1);
    //         String str2 = String.join(" ", o2);
    //         return str1.compareTo(str2);
    //     });

    //     System.out.println(sortedSubSequences.get(sortedSubSequences.size() - 1).size());
    //     System.out.println(String.join(" ", sortedSubSequences.get(sortedSubSequences.size() - 1)));


    // }

    // static int N, M;
    // static String[] A;
    // static String[] B;

    // static void findSubSequences(int i, int j, List<String> current, Set<List<String>> result) {
    //     if (i >= N || j >= M) {
    //         result.add(new ArrayList<>(current));
    //         return;
    //     }

    //     if (A[i].equals(B[j])) {
    //         current.add(A[i]);
    //         findSubSequences(i + 1, j + 1, current, result);
    //         current.remove(current.size() - 1);
    //     }

    //     findSubSequences(i + 1, j, current, result);
    //     findSubSequences(i, j + 1, current, result);
    // }

    // static int findFirstIndex(String[] arr, String word) {
    //     for (int i = 0; i < arr.length; i++) {
    //         if (arr[i].equals(word)) {
    //             return i;
    //         }
    //     }
    //     return arr.length;
    // }

}
