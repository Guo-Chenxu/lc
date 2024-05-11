package lc;

/**
 * @program: exercise
 * @description: lc2423
 * @author: 郭晨旭
 * @create: 2023-04-29 08:47
 * @version: 1.0
 **/
public class lc2423 {
    public boolean equalFrequency(String word) {
        int[] fre = new int[26];
        for (char c : word.toCharArray()) {
            ++fre[c - 'a'];
        }
        for (int i = 0; i < 26; ++i) {
            --fre[i];
            if (fre[i] != -1 && check(fre)) {
                return true;
            }
            ++fre[i];
        }
        return false;
    }

    public boolean check(int[] fre) {
        int f = -1;
        for (int i = 0; i < 26; ++i) {
            if (f == -1 && fre[i] != 0) {
                f = fre[i];
            }
            if (fre[i] != 0 && fre[i] != f) {
                return false;
            }
        }
        return true;
    }
}
