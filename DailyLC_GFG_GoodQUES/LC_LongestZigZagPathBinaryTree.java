package cpOrContests.DailyLC_GFG_GoodQUES;

//https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/
public class LC_LongestZigZagPathBinaryTree {

    int maxPathLen = -1;

    public int longestZigZag(TreeNode root) {
        dfsLongestZZ(root, true, 0);
        dfsLongestZZ(root, false, 0);

        return maxPathLen;
    }

    public void dfsLongestZZ(TreeNode root, boolean goLeft, int pathLen) {
        if (root != null) {
            maxPathLen = Math.max(maxPathLen, pathLen);

            if (goLeft) {
                //because last call asked us to go left, and we go left in this call, so we continue the path
                //hence add 1 to existing path.
                dfsLongestZZ(root.left, false, 1 + pathLen);
                dfsLongestZZ(root.right, true, 1);
                //but if we dont go left, instead go right. then previous path is of no use for us.
                //we start a new path, beginning from this node, hence new path len = 1
            }
            else{
                dfsLongestZZ(root.right, true, 1 + pathLen);
                dfsLongestZZ(root.left, false, 1);
            }
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
