package lc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class lc994 {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j, 0 });
                } else if (grid[i][j] == 1) {
                    cnt++;
                }
            }
        }

        int res = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1) {
                    grid[x][y] = 2;
                    res = Math.max(res, now[2] + 1);
                    q.offer(new int[] { x, y, now[2] + 1 });
                    cnt--;
                }
            }
        }

        return cnt == 0 ? res : -1;
    }
}
