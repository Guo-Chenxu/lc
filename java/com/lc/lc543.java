package lc;

import java.util.*;

public class lc543 {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        longest(root);
        return res;
    }

    public int longest(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = longest(root.left);
        int r = longest(root.right);
        res = Math.max(l + r, res);
        return Math.max(l, r) + 1;
    }
}
