package lc;

/**
 * @program: exercise
 * @description: lc1026
 * @author: 郭晨旭
 * @create: 2023-04-18 09:32
 * @version: 1.0
 **/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class lc1026 {
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, root.val, root.val);
    }

    public int dfs(TreeNode cur, int min, int max) {
        if (cur == null) {
            return max - min;
        }
        min = Math.min(cur.val, min);
        max = Math.max(cur.val, max);
        int left = dfs(cur.left, min, max);
        int right = dfs(cur.right, min, max);
        return Math.max(left, right);
    }
}
