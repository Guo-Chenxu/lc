package lc;

import java.util.*;

public class lc98 {

    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean check(TreeNode cur, long min, long max) {
        if (cur == null) {
            return true;
        }
        if (cur.val >= max || cur.val <= min) {
            return false;
        }
        return check(cur.left, min, cur.val)
                && check(cur.right, cur.val, max);
    }

    // List<Integer> tree = new ArrayList<>();

    // public boolean isValidBST(TreeNode root) {
    // inorder(root);
    // for (int i = 1; i < tree.size(); i++) {
    // if (tree.get(i) <= tree.get(i - 1)) {
    // return false;
    // }
    // }
    // return true;
    // }

    // public void inorder(TreeNode root) {
    // if (root == null) {
    // return;
    // }
    // inorder(root.left);
    // tree.add(root.val);
    // inorder(root.right);
    // }
}
