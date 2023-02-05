package cpOrContests.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF_prependAndAppend {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            StringBuilder s = new StringBuilder(str);
            int i = 0;
//            int l = s.length();
            while(s.length() > 0) {
                int l = s.length();
                if ((s.charAt(0) == '0' && s.charAt(l - 1) == '1') ||
                        (s.charAt(0) == '1' && s.charAt(l - 1) == '0')) {
                    s.deleteCharAt(0);
                    s.deleteCharAt(l - 2);
                }
                else break;
            }

            System.out.println(s.length());
//            for (i = 0; i < l/2; i++) {
//                if ((s.charAt(i) == 0 && s.charAt(l - i - 1) == 1) ||
//                        (s.charAt(i) == 1 && s.charAt(l - i - 1) == 0)) {
//                    continue;
//                }
//                else {
////                    System.out.println(i);
//                    break;
//                }
//            }
////            System.out.println(i);
//            System.out.println(l - 2*(i+1));
        }
    }
}
