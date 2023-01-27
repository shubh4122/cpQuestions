package cpOrContests.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF_taisiaAndDice {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-->0) {
            String[] temp = br.readLine().split(" ");
            int n = Integer.parseInt(temp[0]);
            int s = Integer.parseInt(temp[1]);
            int r = Integer.parseInt(temp[2]);

            int[] ans = new int[n];

            ans[0] = s - r;

            for (int i = 1; i < n; i++) {
                //filling 6
                if (r >= 6 && ans[0] >= 6){
                    ans[i] = 6;
                    r -= 6;
                }
                //filling 5
                else if (r >= 5 && ans[0] >= 5){
                    ans[i] = 5;
                    r -= 5;
                }
                //filling 4
                else if (r >= 4 && ans[0] >= 4){
                    ans[i] = 4;
                    r -= 4;
                }
                //filling 3
                else if (r >= 3 && ans[0] >= 3){
                    ans[i] = 3;
                    r -= 3;
                }
                //filling 2
                else if (r >= 2 && ans[0] >= 2){
                    ans[i] = 2;
                    r -= 2;
                }
                //filling 1
                else if (r >= 1 && ans[0] >= 1){
                    ans[i] = 1;
                    r -= 1;
                }
            }

            //replacing 0s
            int j = 1;
            for (int i = n-1; i >= 1; i--) {
                if(ans[i] != 0)
                    break;

                if (ans[j] - 1 >= 1)
                    ans[j] -= 1;
                else {
                    j++;
                    ans[j] -= 1;
                }
                ans[i] = 1;
            }

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i]+" ");
            }
            System.out.println();
        }
    }
}
