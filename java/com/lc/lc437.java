package lc;

import java.util.*;

public class lc437 {
    Map<Long, Long> map = new HashMap<>();
    int ans = 0;

    public int pathSum(TreeNode root, int targetSum) {
        map.put(0L, 1L);
        dfs(root, 0L, targetSum);
        return ans;
    }

    public void dfs(TreeNode node, long cur, int targetSum) {
        if (node == null) {
            return;
        }
        cur += node.val;
        ans += map.getOrDefault(cur - targetSum, 0L);
        map.put(cur, map.getOrDefault(cur, 0L) + 1L);
        dfs(node.left, cur, targetSum);
        dfs(node.right, cur, targetSum);
        map.put(cur, map.get(cur) - 1);
    }
}
