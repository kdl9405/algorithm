package programmers;

import java.util.*;

/**
 * 길 찾기 게임
 * 
 */
public class pro106 {

    public static void main(String[] args) {

        int[][] nodeinfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 },
                { 2, 2 } };
        int[][] result = solution(nodeinfo);

        for (int[] r : result) {
        for (int i = 0; i < r.length; i++) {
        System.out.print(r[i] + " ");
        }
        System.out.println("");
        }

    }

    static int[][] solution(int[][] nodeinfo) {

        List<Node> list = new ArrayList<>();

        for (int i = 0; i < nodeinfo.length; i++) {
            list.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }

       
        Collections.sort(list, (o1, o2) ->{
            if(o1.y == o2.y){
                return o1.x - o2.x;
            }
            return o2.y - o1.y;
        });

        Node root = list.get(0);
        int[][] answer = new int[2][nodeinfo.length];

        for (int i = 1; i < list.size(); i++) {
            addNode(root, list.get(i));
        }

        preorder(answer, root);
        index = 0;
        postorder(answer, root);

        return answer;
    }

    static int index = 0;

    static void addNode(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                addNode(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                addNode(parent.right, child);
            }
        }
    }

    static void preorder(int[][] arr, Node root) {
        if (root != null) {
            arr[0][index++] = root.num;
            preorder(arr, root.left);
            preorder(arr, root.right);
        }
    }

    static void postorder(int[][] arr, Node root) {
        if (root != null) {
            postorder(arr, root.left);
            postorder(arr, root.right);
            arr[1][index++] = root.num;
        }
    }

}

class Node {

    int num;
    int x;
    int y;

    Node left;
    Node right;

    Node(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }
}