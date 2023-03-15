package cpOrContests.DailyLC_GFG_GoodQUES;

import java.util.ArrayList;

//https://leetcode.com/problems/sum-root-to-leaf-numbers/
public class LC_sumRootToLeaf {


    public int sumNumbers(TreeNode root) {
        ArrayList<Integer> nums = new ArrayList<>();
        traversal(root, nums, 0);

        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        return sum;
    }

    public void traversal(TreeNode root, ArrayList<Integer> nums, int prevVal) {
        if (root != null) {
            prevVal = prevVal*10 + root.val;
            if (root.left == null && root.right == null)
                nums.add(prevVal);
            else {
                traversal(root.left, nums, prevVal);
//                prevVal = prevVal/10;//removes left digit -- NOT NEEDED. see? doesnt it retain its val??
                traversal(root.right, nums, prevVal);
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
