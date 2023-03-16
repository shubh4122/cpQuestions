package cpOrContests.DailyLC_GFG_GoodQUES;

import striversSheet.easy.tree_inorderTraversal.Node;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/check-completeness-of-a-binary-tree/
public class LC_CheckBTcompleteness {

    public boolean isCompleteTree(Node root) {
        //level order traversal
        Queue<Node> q = new LinkedList<>();
        int level = 0;

        q.add(root);
        q.add(null);

        int countLevelNodes = 0;
        boolean gap = false;//denotes if nodes absent between 2 nodes, hence not leftmost arrangement

        while (!q.isEmpty()) {
            Node pop = q.remove();

            //case when nodes are not to the leftmost
            if (pop != null && pop.data == -1){
                gap = true;
                continue;
            }

            if (pop == null) {
                if (!q.isEmpty()) {
                    q.add(null);
                    if (countLevelNodes != Math.pow(2, level))
                        return false;
                    countLevelNodes = 0;
                    level++;
                }
                else
                    return true;
            }
            else {
                countLevelNodes++;

                if (gap)
                    return false;

                if (pop.left != null)
                    q.add(pop.left);
                else
                    q.add(new Node(-1));

                if (pop.right != null)
                    q.add(pop.right);
                else
                    q.add(new Node(-1));
            }
        }
        return true;
    }
}
