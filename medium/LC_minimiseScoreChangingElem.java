package cpOrContests.medium;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-score-by-changing-two-elements/description/
public class LC_minimiseScoreChangingElem {

    public static void main(String[] args) {
        int[] n = new int[]{59,27,9,81,33};//{1,4,7,8,5};//{1,4,3};
        System.out.println(minimizeSum(n));
    }

    public static int minimizeSumCleaner(int[] nums) {
        //cleaner and efficient code
        /*
            we just need to return high, as low will be 0
            now, for making high MIN, we can either:
            1. replace the smallest 2 no.s in arr with max in arr
            2. replace highest 2 no.s in arr with min in arr
            3. replace the highest and smallest in arr with 2nd highest/smallest in arr.

            But we dont have to actually replace, we can just assume we changed
            and use the value from main arr itself!

            score = high, as low is 0 after change
         */
        int n = nums.length;
        Arrays.sort(nums);
        int score1 = nums[n - 1] - nums[2];// max in arr - new min in arr
        int score2 = nums[n - 3] - nums[0];//new max in arr - min of arr
        int score3 = nums[n - 2] - nums[1];//new max - new min

        return Math.min(score1, Math.min(score2, score3));
    }

    public static int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int [] nums1 = new int[nums.length];
        int [] nums2 = new int[nums.length];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nums[i];
            nums2[i] = nums[i];
        }

        //case 1:
        nums[0] = nums[1] = nums[nums.length - 1];
        int low = 0;
        Arrays.sort(nums);
        int high = nums[nums.length - 1] - nums[0];

        //case 2:
        nums1[nums1.length - 1] = nums1[nums1.length - 2] = nums1[0];
        int low1 = 0;
        Arrays.sort(nums1);
        int high1 = nums1[nums1.length - 1] - nums1[0];

        //case 3:
        nums2[nums2.length - 1] = nums2[0] = nums2[nums2.length - 2];
        Arrays.sort(nums2);
        int high2 = nums2[nums2.length - 1] - nums2[0];

        int score = low + high;
        int score1 = low1 + high1;
        int score2 = high2;

        return Math.min(score1, Math.min(score, score2));
    }
}
