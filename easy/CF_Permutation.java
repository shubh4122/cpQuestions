package cpOrContests.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CF_Permutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr= new int[n][n-1];

            for (int i = 0; i < n; i++) {
                String[] temp = br.readLine().split(" ");
                for (int j = 0; j < temp.length; j++) {
                    arr[i][j] = Integer.parseInt(temp[j]);
                }
            }


            //WORKING
            int ans[] = new int[n];
            int k = 0;
            int memory = -1;
            HashMap<Integer, Integer> hm = new HashMap<>();
            for (int j = 0; j < n - 1; j++) {
                if (j == n - 2) {
                    for(Map.Entry<Integer, Integer> entry: hm.entrySet()) {
                            memory = entry.getKey();
                            break;
                    }
                }
                for (int i = 0; i < n; i++) {
                    hm.put(arr[i][j], hm.getOrDefault(arr[i][j], 0)+1);
                }

                for(Map.Entry<Integer, Integer> entry: hm.entrySet()) {
                    if(entry.getValue() == n - 1) {
                        if (j == n-2) {
                            ans[k] = memory;

                            hm.remove(ans[k]);
                            k++;
                            break;
                        }
                        ans[k] = entry.getKey();
                        hm.remove(ans[k]);
                        k++;
                        break;
                    }
                }
            }

            for(Map.Entry<Integer, Integer> entry: hm.entrySet()) {
                if(entry.getValue() == n - 1) {
                    ans[k] = entry.getKey();
                    hm.remove(ans[k]);
                    break;
                }
            }
            //print

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i]+" ");
            }
            System.out.println();

        }

    }

}