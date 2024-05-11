package lc;

import java.util.*;

public class lc108 {

    public static void main(String[] args) {
        new lc108().sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 });
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length);
    }

    public TreeNode dfs(int[] nums, int l, int r) {
        int m = (l + r) >> 1;
        if (l >= r || m < 0 || m >= nums.length) {
            return null;
        }
        TreeNode cur = new TreeNode(nums[m]);
        cur.left = dfs(nums, l, m);
        cur.right = dfs(nums, m + 1, r);
        return cur;
    }
}
