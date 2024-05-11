package lc;

/**
 * @program: exercise
 * @description: lc6375
 * @author: 郭晨旭
 * @create: 2023-04-16 10:46
 * @version: 1.0
 **/
public class lc6375 {
    // 如果前一个字符大于等于后一个字符, 那一定需要一个新的 abc 周期
    public int addMinimum(String word) {
        int t = 1;
        char[] words = word.toCharArray();
        int len = word.length();
        for (int i = 1; i < len; ++i) {
            if (words[i - 1] >= words[i]) {
                ++t;
            }
        }
        return 3 * t - len;
    }
}
