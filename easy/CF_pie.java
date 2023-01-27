package cpOrContests.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF_pie {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        String pie = "31415926535897932384626433832795028841971"; //some 40 digits
        while (t-->0) {
            String num = br.readLine();

            int count = 0;
            for (int i = 0; i < num.length(); i++) {
                if (num.charAt(i) == pie.charAt(i))
                    count++;
                else
                    break;
            }
            System.out.println(count);
        }
    }
}
