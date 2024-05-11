package lc;

/**
 * @program: exercise
 * @description: lc6378
 * @author: 郭晨旭
 * @create: 2023-04-23 10:30
 * @version: 1.0
 **/
public class lc6378 {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}
