package cpOrContests.DailyLC_GFG_GoodQUES;

public class LC_BulbSwitcher {

    /*
        HOW did i figure out?
        Just dry runned the concept for n = 8, 1, 3, 4, and figured out
        the ON bulbs had pattern. They repeat after every (i+2) gap.
        OR 1 occurs after every x+3(x = 0, x+=2).
        and observing more closely, it was actually all square numbers.
        
        Pattern:
        Bulbs which will be ON:
        1, 4, 9, 16, 25......
        i.e. all the perfect squares
        So, any number between 16(included) to 25(excluded) will have, 4 bulbs
        ON.

        IN SHORT:
        Ans will be, Integer part of Square Root of n.
     */
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
