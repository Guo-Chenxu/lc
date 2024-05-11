package lc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class lc199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        if (root == null) {
            return list;
        }
        q.offer(root);
        while (!q.isEmpty()) {
            int cnt = q.size(), temp = 0;
            for (int i = 0; i < cnt && !q.isEmpty(); i++) {
                TreeNode cur = q.poll();
                temp = cur.val;
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            list.add(temp);
        }
        return list;
    }
}
