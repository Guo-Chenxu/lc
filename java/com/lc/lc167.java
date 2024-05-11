package lc;

/**
 * @author: 郭晨旭
 * @create: 2023-11-19 17:32
 * @version: 1.0
 */
public class lc167 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0, j = numbers.length - 1; i < j;) {
            while (i < j && numbers[i] + numbers[j] > target) {
                j--;
            }
            if (i < j && numbers[i] + numbers[j] == target) {
                return new int[] { i + 1, j + 1 };
            }
            i++;
        }
        return new int[] {};
    }
}
