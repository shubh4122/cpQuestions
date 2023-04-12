package cpOrContests.DailyLC_GFG_GoodQUES;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/simplify-path/description/
public class LC_SimplifyPaths {

    public static void main(String[] args) {
        String s = "/a/./b/../../c/";//"/home/..";
        System.out.println(simplifyPath(s));
    }

    /*
        "/home/"
        "/../"
        "/home//foo/"
        "/home/.."
        "/home/user/../.../"
     */
    public static String simplifyPath(String path) {
        //Such question where string needs to be modified, STACK/Similar DS can be used
        //OR can use stack but then while appending, append in reverse fashion.
        Deque<String> st = new LinkedList<>();
        String temp = "";
        path += "/";

        /*
            NOTE: Instead of segregating dir/file names myself by finding
            occurrences of /. use:

            String[] p = path.split("/");

            and then Iterate over p and put elem in stack(deQ)/pop as per requirement;
         */

        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c != '/')
                temp += c;
            else {
                if (temp.equals("..")) {
                    if (!st.isEmpty())
                        st.removeLast();
                }
                else if ((! temp.equals(".")) && (! temp.equals("")))
                    st.addLast(temp);

                temp = "";//reset
            }
        }

        StringBuilder b = new StringBuilder();
        if (st.isEmpty())
            b.append("/");

        while (!st.isEmpty()) {
            b.append("/").append(st.removeFirst());
        }
        return b.toString();
    }
}
