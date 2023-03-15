package cpOrContests.DailyLC_GFG_GoodQUES;

import striversSheet.easy.tree_inorderTraversal.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/6c4053871794c5e7a0817d7eaf88d71c4bb4c2bc/1
public class GFG_2SwappedNodesBST {
//HARD GFG!!
    static Node[] problem = new Node[2];

    public static void main(String[] args) {
//        Node root = new Node(10);
//        root.left = new Node(5);
//        root.right = new Node(8);
//        root.left.left = new Node(2);
//        root.left.right = new Node(20);

        Node root = new Node(11);
        root.left = new Node(3);
        root.right = new Node(17);
        root.right.left = new Node(10);
        root.left.right = new Node(4);


        List<Node> inorder = inorderRecursive(root);
        int problem1 = -1, problem2 = -1;
        int temp = -1;
        for (int i = 1; i < inorder.size(); i++) {

            if (inorder.get(i-1).data > inorder.get(i).data) {

                if (problem1 == -1) {
                    problem1 = inorder.get(i - 1).data;
                    temp = inorder.get(i).data;
                }
                else
                    problem2 = inorder.get(i).data;
            }
        }
        if (problem2 == -1)
            problem2 = temp;

        if (problem1 == -1)
            problem1 = root.data;
        else if (problem2 == -1)
            problem2 = root.data;

        System.out.println(swapBST(root, problem1, problem2));
    }

    public static List<Node> inorderRecursive(Node root){
        List<Node> list = new ArrayList<>();
        if (root != null) {
            list.addAll(inorderRecursive(root.left));
            list.add(root);
            list.addAll(inorderRecursive(root.right));
        }
        return list;
    }

    public static List<Integer> swapBST(Node root, int p1, int p2) {
        List<Integer> inorder = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        Node popped;

        //return empty list if tree is empty
        if (root == null)
            return inorder;

        s.push(root);

        while (!s.isEmpty()){
            //put all left nodes until its null
            while (root.left != null) {
                s.push(root.left);
                root = root.left;
            }

            //pop node now
            popped = s.pop();

            if (popped.data == p1) {
                popped.data = p2;
            }
            else if (popped.data == p2) {
                popped.data = p1;
            }

            inorder.add(popped.data);

            //push the right of popped node if it's not null
            if (popped.right != null) {
                root = popped.right;
                s.push(root);
            }
        }

        return inorder;
    }
}
