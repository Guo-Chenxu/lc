package lc;

/**
 * @program: exercise
 * @description: lc6439
 * @author: 郭晨旭
 * @create: 2023-05-21 10:54
 * @version: 1.0
 **/
public class lc6439 {
    public int minLength(String s) {
        while (s.contains("AB") || s.contains("CD")) {
            s = s.replace("AB", "");
            s = s.replace("CD", "");
        }
        return s.length();
    }
}
