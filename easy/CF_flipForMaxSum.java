package cpOrContests.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF_flipForMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] temp = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(temp[i]);
            }

            for (int i = 0; i < n - 1; i++) {
                if (a[i] < 0 && a[i+1] < 0) {
                    a[i] = -a[i];
                    a[i+1] = -a[i+1];
                }
            }
        }
    }
}
