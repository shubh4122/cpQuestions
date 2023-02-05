package cpOrContests.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;

public class CF_charCheck {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        HashSet<Character> h = new HashSet<>();
        String s = "codeforces";
        for (int i = 0; i < s.length(); i++) {
            h.add(s.charAt(i));
        }
        while (t-->0) {
            String temp = br.readLine();
            char c = temp.charAt(0);
            String ans = h.contains(c) ? "YES" : "NO";
            System.out.println(ans);
        }
    }
}
