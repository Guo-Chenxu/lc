package lc;

/**
 * @program: exercise
 * @description: lc2466
 * @author: 郭晨旭
 * @create: 2023-05-17 10:48
 * @version: 1.0
 **/
public class lc2466 {
    public boolean haveConflict(String[] event1, String[] event2) {
        int min11 = Integer.parseInt(event1[0].substring(0, 2)) * 60 + Integer.parseInt(event1[0].substring(3, 5));
        int min12 = Integer.parseInt(event1[1].substring(0, 2)) * 60 + Integer.parseInt(event1[1].substring(3, 5));
        int min21 = Integer.parseInt(event2[0].substring(0, 2)) * 60 + Integer.parseInt(event2[0].substring(3, 5));
        int min22 = Integer.parseInt(event2[1].substring(0, 2)) * 60 + Integer.parseInt(event2[1].substring(3, 5));
        return !(min12 < min21 || min11 > min22);
    }
}
