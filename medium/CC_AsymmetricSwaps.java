package cpOrContests.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//Ques link - https://www.codechef.com/JAN231D/problems/ARRSWAP?tab=statement
public class CC_AsymmetricSwaps {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-->0) {
            int n = Integer.parseInt(br.readLine());
            String[] temp = br.readLine().split(" ");
            int[] ab = new int[2*n];
            for (int i = 0; i < n; i++) {
                ab[i] = Integer.parseInt(temp[i]);
            }

            String[] temp1 = br.readLine().split(" ");
            for (int i = n; i < 2*n; i++) {
                ab[i] = Integer.parseInt(temp1[i-n]);
            }

            Arrays.sort(ab);
            int diff = Integer.MAX_VALUE;
            for (int i = 0; i <= n; i++) {
                int diff1 = ab[i + n - 1] - ab[i];
                if (diff > diff1)
                    diff = diff1;
            }
            System.out.println(diff);
        }
    }
}
