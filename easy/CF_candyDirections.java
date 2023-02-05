package cpOrContests.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF_candyDirections {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-->0) {
            int n = Integer.parseInt(br.readLine());
            String dir = br.readLine();

            int x = 0,  y = 0;
            int i = 0;
            for (i = 0; i < dir.length(); i++) {
                char c = dir.charAt(i);
                if (c == 'R')
                    x +=1 ;

                else if ( c=='L')
                    x -= 1;

                else if (c == 'U')
                    y += 1;

                else
                    y -= 1;

                if (x == 1 && y == 1) {
                    System.out.println("Yes");
                    i = -1;
                    break;
                }
            }
            if (i != -1)
                System.out.println("NO");
        }
    }
}
