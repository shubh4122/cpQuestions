package cpOrContests.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF_flipFlopSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            String[] temp = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(temp[i]);
            }


            //abs sum
            int absSum = 0;
            for (int i = 0; i < n; i++) {
                absSum += Math.abs(arr[i]);
            }

            int sum = sum(arr);

            if (sum == absSum)
                System.out.println(sum - 4);

            else {
                int flag = -1;
                for (int i = 1; i < n; i++) {
                    if (arr[i-1] == -1 && arr[i] == -1) {
                        System.out.println(sum+4);
                        flag = 0;
                        break;
                    }
                }
                if (flag == -1)
                    System.out.println(sum);
            }
        }
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
