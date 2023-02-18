package cpOrContests.DailyLC_GFG_GoodQUES;

import java.util.ArrayList;

public class GFG_AppleSubsequenceLongest {

    public static void main(String[] args) {
        String s = "OAOAOOAAAAOAAOOOAAOOOAAAAAAOOAAAOOAAAOOAOAOAAOAOOAAOOOAAOAAAAAOAAOAOOAOAOAAOOOAAAAAOAAOAOAOOAOOOOAAA";//"AAOOOOAAAOA";//"AOOAO";//"AAOAO";
        int n = s.length();
        int m = 10;//2;//1;
        System.out.println(appleSubseq(n, m, s));
    }

    public static int appleSubseq(int n, int m, String s) {
        //mark window with 2 pointers, start and end
        int start = 0, end = -1;
        int mCopy = m;
        int maxSubseq = Integer.MIN_VALUE;

        //extra memory used
        ArrayList<Integer> posO = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) != 'O' || mCopy > 0){
                //we can increase window.
                end++;

                if (s.charAt(i) == 'O') {
                    mCopy--;//O is entered in window on cost of M
                }

                maxSubseq = Math.max(maxSubseq, end - start + 1);
            }
            else if (s.charAt(start) == 'O' && s.charAt(i) == 'O') {
                //eliminating start O and putting in current O. (MOVING WINDOW)
                start++;
                end++;
            }
            else {
                //Runs when an O comes, when m = 0;
                //this makes window of size m. RESIZING WINDOW
                //removing the first occuring O, by making start next to first O

                //we need to do this, because of above-mentioned line!
                do {
                    start++;
                }
                while (s.charAt(start-1) != 'O');
                
                end++;
            }
        }
        return maxSubseq;
    }
}
