package cpOrContests.easy;

// https://leetcode.com/contest/biweekly-contest-98/problems/maximum-difference-by-remapping-a-digit/

public class LC_remappingDig {

    public static void main(String[] args) {
        int n = 90;//11891;
        System.out.println(minMaxDifference(n));
    }
    public static int minMaxDifference(int num) {
        StringBuilder n = new StringBuilder(Integer.toString(num));
        int firstDig = n.charAt(0) - '0';
        int i = 0;
        while (firstDig == 9) {
            firstDig = n.charAt(i) - '0';
            i++;
            if (i == n.length())
                break;
        }

        for (int j = 0; j < n.length(); j++) {
            if ((n.charAt(j) - '0') == firstDig) {
                n.replace(j, j+1, "9");
            }
        }
        int nMax = Integer.parseInt(n.toString());

        n = new StringBuilder(Integer.toString(num));
        firstDig = n.charAt(0) - '0';

        for (int j = 0; j < n.length(); j++) {
            if ((n.charAt(j) - '0') == firstDig) {
                n.replace(j, j+1, "0");
            }
        }

        int nMin = Integer.parseInt(n.toString());

        return nMax - nMin;
    }
}
