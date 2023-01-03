package cp.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cf_capsLock {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder(br.readLine());

//        M1: Check invalid first, then change
        boolean isInvalid = true;
        for (int i = 1; i < str.length(); i++) { // i = 1 coz the first letter doesnt matter for invalids
            if (str.charAt(i) >= 97){
                isInvalid = false;
                break;
            }
        }

        if (isInvalid){
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(c >=97)
                    str.replace(i, i+1,String.valueOf((char)(c-32)));
                else{
                    str.replace(i, i+1,String.valueOf((char)(c+32)));
                }
            }
        }
        System.out.println(str);

//        M2: Create a temp str. store changes in it. and keep checking invalids. if never found invalid. dump temp. else print
    }
}
