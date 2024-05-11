package lc;

import java.util.*;

public class lc105 {
    int idx = 0;
    Map<Integer, Integer> idxMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            idxMap.put(inorder[i], i);
        }

        return build(preorder, inorder, 0, preorder.length);
    }

    public TreeNode build(int[] preorder, int[] inorder, int l, int r) {
        if (l >= r || idx >= preorder.length
                || idxMap.get(preorder[idx]) < l || idxMap.get(preorder[idx]) >= r) {
            return null;
        }
        TreeNode cur = new TreeNode(preorder[idx++]);
        cur.left = build(preorder, inorder, l, idxMap.get(preorder[idx - 1]));
        cur.right = build(preorder, inorder, idxMap.get(preorder[idx - 1]) + 1, r);
        return cur;
    }

    public static void main(String[] args) {
        new lc105().buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15, 20, 7 });
    }
}
