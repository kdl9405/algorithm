package gooorm;

import java.util.*;
/**
 * nhn2
 */
public class nhn2 {

    private static void solution(int day, int width, int[][] blocks) {

        if (width <= 2) {
            System.out.println(0);
            return;
        }

        int count = 0;
        int l = blocks[0][0];
        int r = 0;

        int[] arr = new int[width];

        int d = 0;
        while (d < day) {

            for(int j = 0; j<width; j++){
                arr[j] += blocks[d][j];
            }

            for(int i = 1; i<width-1; i++){

                l = Math.max(l, arr[i-1]);
                
                r = arr[i];
                int j = i;
                for(j = i; j<width-1; j++){                  
                    
                    if (arr[j] > arr[j+1] && arr[j] > r) {
                        r = arr[j];
                        break;
                    }
                    if (j == width-2 && arr[j]<arr[j+1] && r<arr[j+1]) {
                        r = arr[j+1];
                    }
                }
                if (r != arr[i]) {
                    int cement = Math.min(l, r) - arr[i];

                    if (cement <= 0) {
                        continue;
                    }

                    count += cement;
                    arr[i] = Math.min(l, r);
                }

            }

            d++;
        }

        System.out.println(count);

    }

    private static class InputData {
        int day;
        int width;
        int[][] blocks;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.day = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.width = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.blocks = new int[inputData.day][inputData.width];
            for (int i = 0; i < inputData.day; i++) {
                String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
                for (int j = 0; j < inputData.width; j++) {
                    inputData.blocks[i][j] = Integer.parseInt(buf[j]);
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.day, inputData.width, inputData.blocks);
    }
}