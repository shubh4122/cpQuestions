package cpOrContests.DailyLC_GFG_GoodQUES;

import striversSheet.easy.tree_inorderTraversal.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LC_invertBinTree {
    public static void main(String[] args) {

    }

    //LESS SPACE TAKING AND CLEANER CODE:
    public static Node invertTreeRecursive(Node root) {
        //My idea - just swap the left and right links
        //using DFS trav

        //BC
        if (root == null)
            return null;

        //postorder(only this, coz to swap we need heads of both left and right subtrees)
        Node leftSubtreeHead = invertTreeRecursive(root.left);
        Node rightSubtreeHead = invertTreeRecursive(root.right);


//      swapping the subtrees
        root.left = rightSubtreeHead;
        root.right = leftSubtreeHead;

        return root;
    }



    //MORE SPACE TAKING AND LONG CODE
    public static Node invertTree(Node root) {
        //My idea - just swap the left and right links
        //using bfs trav

        //Empty tree
        if (root == null)
            return root;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node pop = q.remove();

            if (pop.left != null)
                q.add(pop.left);

            if (pop.right != null)
                q.add(pop.right);

//          swapping the subtrees
            Node temp = pop.left;
            pop.left = pop.right;
            pop.right = temp;
        }
        return root;
    }
}
