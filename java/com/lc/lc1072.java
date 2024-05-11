package lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: exercise
 * @description: lc1072
 * @author: 郭晨旭
 * @create: 2023-05-15 11:33
 * @version: 1.0
 **/
public class lc1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix[0].length;
        Map<String, Integer> map = new HashMap<>();
        for (int[] m : matrix) {
            int x = m[0];
            int cnt = 1;
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < n; ++i) {
                if (m[i] != x) {
                    sb.append(cnt).append("-");
                    cnt = 1;
                    x = m[i];
                } else {
                    ++cnt;
                }
            }
            sb.append(cnt);
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }
        int res = 1;
        for (int val : map.values()) {
            res = Math.max(res, val);
        }
        return res;
    }

    public int maxEqualRowsAfterFlips01(int[][] matrix) {
        int n = matrix[0].length;
        Node root = new Node();
        int res = 1;
        for (int[] m : matrix) {
            int x = m[0];
            Node now = root;
            for (int i = 1; i < n; ++i) {
                if (m[i] == x) {
                    if (now.left == null) {
                        now.left = new Node();
                    }
                    now = now.left;
                } else {
                    if (now.right == null) {
                        now.right = new Node();
                    }
                    now = now.right;
                }
            }
            now.val++;
            res = Math.max(res, now.val);
        }
        return res;
    }

    class Node {
        Node left, right;
        int val;

        public Node() {
            val = 0;
        }
    }
}
