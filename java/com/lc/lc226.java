package lc;

import java.util.*;

public class lc226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        invert(root);
        return root;
    }

    public void invert(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode l = root.left;
        root.left = root.right;
        root.right = l;
        invert(root.left);
        invert(root.right);
    }
}
