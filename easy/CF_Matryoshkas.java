package cpOrContests.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CF_Matryoshkas {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            int n = Integer.parseInt(br.readLine());
            String[] temp = br.readLine().split(" ");

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(temp[i]);
            }

            //WORKING
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }

            //Finding the max count
            int max = Integer.MIN_VALUE;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int currCount = entry.getValue();
                if (max < currCount)
                    max = currCount;
            }

            System.out.println(max);
        }
    }
}
