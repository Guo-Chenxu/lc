package lc;

/**
 * @program: exercise
 * @description: lc831
 * @author: 郭晨旭
 * @create: 2023-04-01 11:00
 * @version: 1.0
 **/
public class lc831 {
    public String myMaskPII(String s) {
        int idx = s.indexOf('@');
        if (idx == -1) {
            int cnt = 0;
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c >= '0' && c <= '9') {
                    stringBuilder.append(c);
                    ++cnt;
                }
            }
            s = "***-***-" + stringBuilder.substring(cnt - 4);
            switch (cnt) {
                case 11 -> s = "+*-" + s;
                case 12 -> s = "+**-" + s;
                case 13 -> s = "+***-" + s;
                default -> {
                }
            }
        } else {
            s = s.toLowerCase();
            s = s.charAt(0) + "*****" + s.substring(idx - 1);
        }
        return s;
    }

    // 官方
    // 代码简洁但是慢
    String[] country = { "", "+*-", "+**-", "+***-" };

    public String maskPII(String s) {
        int at = s.indexOf("@");
        if (at > 0) {
            s = s.toLowerCase();
            return (s.charAt(0) + "*****" + s.substring(at - 1)).toLowerCase();
        }
        s = s.replaceAll("[^0-9]", "");
        return country[s.length() - 10] + "***-***-" + s.substring(s.length() - 4);
    }
}
