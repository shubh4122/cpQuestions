package cp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cf_capsLock {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder(br.readLine());

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(i == 0 && c >=97)
                str.replace(i, i+1,String.valueOf((char)(c-32)));
            else if (i != 0){
                if (c >=65 && c <= 91)
                    str.replace(i, i+1,String.valueOf((char)(c+32)));
            }
        }

        System.out.println(str);
    }
}
