package cpOrContests.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CC_consecutiveXOR {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-->0) {
            int n = Integer.parseInt(br.readLine());

            String[] temp = br.readLine().split(" ");
            int[] arr = new int[n];
            int xorArr = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(temp[i]);
                xorArr ^= arr[i];
            }

            //https://www.codechef.com/problems/XOR2?tab=hints
            //Watch above hint for more details.
            if (n%2 == 0) {//even
                if (xorArr == 0)
                    System.out.println("Yes");
                else //xorArr not 0, then it is not possible to have all elem same after any num of ops
                    System.out.println("No");
            }
            else // odd, then it is always Yes, and all elem = XorArr
                System.out.println("Yes");

        }
    }
}
