package lc;

/**
 * @program: exercise
 * @description: lc6431
 * @author: 郭晨旭
 * @create: 2023-05-14 10:49
 * @version: 1.0
 **/
public class lc6431 {
    public boolean doesValidArrayExist(int[] derived) {
        int t = 0;
        for (int num : derived) {
            t ^= num;
        }
        return t == 0;
    }
}
