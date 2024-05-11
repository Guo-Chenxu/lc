package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 郭晨旭
 * @create: 2023-11-05 14:28
 * @version: 1.0
 */
public class lc68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        List<String> temp = new ArrayList<>();

        for (int i = 0; i < n;) {
            temp.clear();
            temp.add(words[i]);
            int cur = words[i++].length();
            while (i < n && cur + 1 + words[i].length() <= maxWidth) {
                temp.add(words[i]);
                cur += 1 + words[i++].length();
            }

            if (i == n) {
                StringBuilder sb = new StringBuilder();
                sb.append(temp.get(0));
                for (int j = 1; j < temp.size(); j++) {
                    sb.append(" ").append(temp.get(j));
                }
                sb.append(" ".repeat(maxWidth - sb.length()));
                ans.add(sb.toString());
                break;
            }

            int cnt = temp.size();
            if (cnt == 1) {
                StringBuilder sb = new StringBuilder(temp.get(0));
                sb.append(" ".repeat(maxWidth - sb.length()));
                ans.add(sb.toString());
                continue;
            }

            int spaceWidth = maxWidth - (cur - (cnt - 1));
            int spaceCnt = spaceWidth / (cnt - 1);
            int remainCnt = spaceWidth % (cnt - 1);
            StringBuilder space = new StringBuilder();
            space.append(" ".repeat(Math.max(0, spaceCnt)));
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cnt; j++) {
                String word = temp.get(j);
                sb.append(word);
                if (j == cnt - 1) {
                    break;
                }
                sb.append(space);
                if (remainCnt > 0) {
                    sb.append(" ");
                    remainCnt--;
                }
            }
            ans.add(sb.toString());
        }

        return ans;
    }

}
