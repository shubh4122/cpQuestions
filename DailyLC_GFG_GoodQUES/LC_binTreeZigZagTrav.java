package cpOrContests.DailyLC_GFG_GoodQUES;

import striversSheet.easy.tree_inorderTraversal;
import striversSheet.easy.tree_inorderTraversal.Node;

import java.util.*;

public class LC_binTreeZigZagTrav {

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);
        root.right.left = new Node(0);
        root.right.right = new Node(8);

        System.out.println(zigzagBFS(root));
        System.out.println(zigzagEfficient(root));
    }

    //only 1 insert 1 pop operation per node
    public static List<List<Integer>> zigzagEfficient(Node root) {
        //use 2 stack
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        List<List<Integer>> zzAns = new ArrayList<>();
        List<Integer> levelList = new ArrayList<>();

        //empty tree
        if (root == null)
            return zzAns;

        s1.add(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            Node pop;
            //pushing children of nodes in s1 ---> to s2
            while (!s1.isEmpty()) {
                pop = s1.pop();
                levelList.add(pop.data);

                //Push Order -> Left then Right
                if (pop.left != null)
                    s2.push(pop.left);

                if (pop.right != null)
                    s2.push(pop.right);
            }
            if (!levelList.isEmpty()) {
                zzAns.add(new ArrayList<>(levelList));
                levelList = new ArrayList<>();
            }

            //pushing children of nodes in s2 ---> to s1 in REVERSE ORDER(RtL)
            while (!s2.isEmpty()) {
                pop = s2.pop();
                levelList.add(pop.data);

                //Push Order -> Right then Left (REVERSE)
                if (pop.right != null)
                    s1.push(pop.right);

                if (pop.left != null)
                    s1.push(pop.left);
            }
            if (!levelList.isEmpty()) {
                zzAns.add(new ArrayList<>(levelList));
                levelList = new ArrayList<>();
            }
        }
        return zzAns;
    }

    //In-Efficent, many operations per node
    public static List<List<Integer>> zigzagBFS(Node root) {
        Queue<Node> q = new LinkedList<>();
        Stack<Node> s = new Stack<>();
        List<List<Integer>> zzAns = new ArrayList<>();
        List<Integer> levelList = new ArrayList<>();

        //empty tree
        if (root == null)
            return zzAns;

        int level = 0;

        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node pop = q.remove();

            if (pop != null) {
                levelList.add(pop.data);//stores list of nodes in a level.

                if (level%2 == 0) {
                    if (pop.left != null)
                        s.push(pop.left);

                    if (pop.right != null)
                        s.push(pop.right);
                }
                else {
                    if (pop.right != null)
                        s.push(pop.right);

                    if (pop.left != null)
                        s.push(pop.left);
                }
            }
            else {//null popped
                zzAns.add(new ArrayList<>(levelList));//when null, level finished, so add it to ans
                levelList = new ArrayList<>();

                level++;
                boolean allNodeVisited = s.isEmpty();

                while (!s.isEmpty()){
                    q.add(s.pop());
                }

                if (!allNodeVisited)
                    q.add(null);//marking end of level
            }
        }
        return zzAns;
    }
}
