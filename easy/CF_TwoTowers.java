package cpOrContests.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF_TwoTowers {
    public static void main(String[] args)throws IOException {

        // -- M2 --
        /*
            TOURIST's solution

            reverse any str
            add it to back of other. -> a+ rev(b)
            now just check, consecutive pair at max can be 1 present. thats it
         */


        //MY
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt((br.readLine()));
        while (t-->0) {
            String[] temp = br.readLine().split(" ");
            int n = Integer.parseInt(temp[0]);
            int m = Integer.parseInt(temp[1]);

            String t1 = br.readLine();
            String t2 = br.readLine();

            int countCons=0;
            for (int i = 1; i < t1.length(); i++) {
                if (t1.charAt(i-1) == t1.charAt(i)) {
                    countCons++;
                }
            }

            if (countCons <= 1) {
                for (int i = 1; i < t2.length(); i++) {
                    if (t2.charAt(i-1) == t2.charAt(i)) {
                        countCons++;
                    }
                }
            }

            if (countCons > 1) {
                System.out.println("NO");
            }
            else {
                if (countCons == 1 && t1.charAt(n - 1) == t2.charAt(m-1)) {
                    System.out.println("NO");
                    continue;
                }
                System.out.println("YES");
            }
        }
    }
}
