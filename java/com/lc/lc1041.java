package lc;

/**
 * @program: exercise
 * @description: lc1041
 * @author: 郭晨旭
 * @create: 2023-04-11 10:57
 * @version: 1.0
 **/
public class lc1041 {
    public boolean isRobotBounded(String instructions) {
        int[][] nex = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int nx = 0, ny = 0, idx = 0;
        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                nx += nex[idx][0];
                ny += nex[idx][1];
            } else if (c == 'R') {
                idx = (idx + 1) % 4;
            } else {
                idx = (idx - 1) % 4;
            }
        }
        return idx != 0 || (nx == 0 && ny == 0);
    }
}
