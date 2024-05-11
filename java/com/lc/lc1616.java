package lc;

/**
 * @program: exercise
 * @description: lc1616
 * @author: 郭晨旭
 * @create: 2023-03-18 11:18
 * @version: 1.0
 **/
public class lc1616 {
    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    public boolean check(String pre, String su) {
        int lenPre = pre.length(), lenSu = su.length();
        int p = 0, q = lenSu - 1;
        while (p < q && pre.charAt(p) == su.charAt(q)) {
            ++p;
            --q;
        }

        return p >= q || checkSelf(pre, p, q) || checkSelf(su, p, q);
    }

    public boolean checkSelf(String s, int p, int q) {
        while (p < q && s.charAt(p) == s.charAt(q)) {
            ++p;
            --q;
        }
        return p >= q;
    }
}
