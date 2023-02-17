package cpOrContests.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://youtu.be/S3hv4NkGf6o?t=1090 - explanation
public class CF_IdealPoint_easytoMed {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt((br.readLine()));
        while (t-- > 0) {
            String[] temp = br.readLine().split(" ");
            int n = Integer.parseInt(temp[0]);
            int k = Integer.parseInt(temp[1]);

            //k can occur max num of times only if it lies on END POINT of range.
            //otherwise, all other elem, which will lie in common ranges, will have same number of occurrences
            //also, it can occur maximally only when it lies on both starting and ending of ranges.(same or different ranges)
            boolean K_OnStartBoundary = false, K_OnEndBoundary = false;

            for (int i = 0; i < n; i++) {
                String[] temp2 = br.readLine().split(" ");
                int start = Integer.parseInt(temp2[0]);
                int end = Integer.parseInt(temp2[1]);

                if (start == k) {
                    K_OnStartBoundary = true;
                }
                if (end == k)
                    K_OnEndBoundary = true;
            }
            System.out.println(K_OnStartBoundary && K_OnEndBoundary ? "YES" : "NO");
        }

    }

}
