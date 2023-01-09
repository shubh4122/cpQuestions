package cpOrContests.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF_taxi_1100 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] countArr = new int[5];
        int ans = 0;

//      For space separated I/P
        String temp[] = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }

        for (int groupSize : arr) {
            countArr[groupSize]++;
        }

        int pair3and1 = 0, pairof2 = 0, pair2and1 = 0, all1 = 0;
        //3 and 1 pair
        if (countArr[1]!=0 && countArr[3]!=0) {
            pair3and1 = Math.min(countArr[1], countArr[3]);
            countArr[1] -= pair3and1;
            countArr[3] -= pair3and1;
        }
        //2 and 1
        if (countArr[1]!=0 && countArr[2]!=0) {
            pair2and1 = Math.min((countArr[1])/2 + countArr[1]%2, countArr[2]);
            countArr[1] -= pair2and1 * 2 - countArr[1]%2;
            countArr[2] -= pair2and1;
        }
        //2 and 2
        pairof2 = countArr[2] / 2;
        countArr[2] -= pairof2 * 2;

        //1 and 1
        all1 = countArr[1] / 4 + (countArr[1] % 4 == 0 ? 0:1);
//        countArr[1] = (countArr[1] % 4);

        // seeee for leftover 1 and 2 only, what to do!!!


//        System.out.println(countArr[4]);
//        System.out.println(pairof2);
//        System.out.println(pair2and1);
//        System.out.println(pair3and1);
//        System.out.println(all1);
        ans = countArr[4] + countArr[3] + countArr[2] + pair3and1 + pairof2 + pair2and1 + all1;

        System.out.println(ans);
    }
}
