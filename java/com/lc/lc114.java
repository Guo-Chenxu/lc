package lc;

import java.util.ArrayList;
import java.util.List;

public class lc114 {
    // List<Integer> list = new ArrayList<>();

    // public void flatten(TreeNode root) {
    // inorder(root);
    // TreeNode cur = root;
    // for (int i = 0; i < list.size(); i++) {
    // if (i == list.size() - 1) {
    // cur.val = list.get(i);
    // break;
    // }
    // cur.val = list.get(i);
    // cur.left = null;
    // cur.right = new TreeNode();
    // cur = cur.right;
    // }
    // }

    // public void inorder(TreeNode node) {
    // if (node == null) {
    // return;
    // }
    // list.add(node.val);
    // inorder(node.left);
    // inorder(node.right);
    // }

    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
}
