package lc;

/**
 * @program: exercise
 * @description: lc1419
 * @author: 郭晨旭
 * @create: 2023-05-06 09:54
 * @version: 1.0
 **/
public class lc1419 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] cnt = new int[26];
        int res = 0;
        for (char c : croakOfFrogs.toCharArray()) {
            ++cnt[c - 'a'];
            if (cnt['c' - 'a'] >= cnt['r' - 'a']
                    && cnt['r' - 'a'] >= cnt['o' - 'a']
                    && cnt['o' - 'a'] >= cnt['a' - 'a']
                    && cnt['a' - 'a'] >= cnt['k' - 'a']) {
                res = Math.max(res, cnt['c' - 'a'] - cnt['k' - 'a']);
                continue;
            } else {
                return -1;
            }
        }
        if (cnt['c' - 'a'] == cnt['r' - 'a']
                && cnt['r' - 'a'] == cnt['o' - 'a']
                && cnt['o' - 'a'] == cnt['a' - 'a']
                && cnt['a' - 'a'] == cnt['k' - 'a']) {
            return res;
        } else {
            return -1;
        }
    }
}
