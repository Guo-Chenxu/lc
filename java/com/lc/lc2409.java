package lc;

/**
 * @program: exercise
 * @description: lc2409
 * @author: 郭晨旭
 * @create: 2023-04-17 19:46
 * @version: 1.0
 **/
public class lc2409 {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] month = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int[] date = new int[13];
        for (int i = 1; i <= 12; ++i) {
            date[i] = date[i - 1] + month[i - 1];
        }
        int ans = Math.min(calculate(leaveAlice, date), calculate(leaveBob, date))
                - Math.max(calculate(arriveAlice, date), calculate(arriveBob, date)) + 1;
        return Math.max(ans, 0);
    }

    public int calculate(String s, int[] date) {
        int month = Integer.parseInt(s.substring(0, 2));
        int day = Integer.parseInt(s.substring(3));
        return date[month - 1] + day;
    }
}
