package lc;

import java.util.*;

public class lc102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        while (!q.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int cnt = q.size();
            for (int i = 0; i < cnt; i++){
                TreeNode node = q.poll();
                if (node.left != null){
                    q.addLast(node.left);
                }
                if (node.right != null){
                    q.addLast(node.right);
                }
                tmp.add(node.val);
            }
            res.add(tmp);
        }

        return res;
    }
}
