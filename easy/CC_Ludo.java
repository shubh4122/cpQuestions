package cpOrContests.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CC_Ludo {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-->0) {
            int n = Integer.parseInt(br.readLine());
            if (n == 6)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
