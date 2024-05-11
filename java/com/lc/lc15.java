package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: 郭晨旭
 * @create: 2023-11-19 17:54
 * @version: 1.0
 */
public class lc15 {
    // todo 不熟练
    // public List<List<Integer>> threeSum(int[] nums) {
    // List<List<Integer>> res = new ArrayList<>();
    //
    // Arrays.sort(nums);
    // if (nums[0] > 0 || nums[nums.length - 1] < 0) {
    // return res;
    // }
    //
    // for (int fi = 0; fi < nums.length; fi++) {
    // if (fi > 0 && nums[fi] == nums[fi - 1]) {
    // continue;
    // }
    // int th = nums.length - 1;
    // for (int se = fi + 1; se < th; se++) {
    // if (se > fi + 1 && nums[se] == nums[se - 1]) {
    // continue;
    // }
    // while (fi < se && se < th && nums[fi] + nums[se] + nums[th] > 0) {
    // th--;
    // }
    // if (fi < se && se < th && nums[fi] + nums[se] + nums[th] == 0) {
    // res.add(Arrays.asList(nums[fi], nums[se], nums[th]));
    // }
    // }
    // }
    // return res;
    // }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);
        for (int fi = 0; fi < nums.length; fi++) {
            if (fi > 0 && nums[fi] == nums[fi - 1]) {
                continue;
            }
            int th = nums.length - 1;
            for (int se = fi + 1; se < th;) {
                while (fi < se && se < th &&
                        ((nums[fi] + nums[se] + nums[th] < 0) || (se > fi + 1 && nums[se] == nums[se - 1]))) {
                    se++;
                }
                while (fi < se && se < th && nums[fi] + nums[se] + nums[th] > 0) {
                    th--;
                }
                if (fi < se && se < th && nums[fi] + nums[se] + nums[th] == 0) {
                    res.add(List.of(nums[fi], nums[se], nums[th]));
                    se++;
                }
            }
        }
        return res;
    }
}
