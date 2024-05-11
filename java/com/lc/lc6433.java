package lc;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: exercise
 * @description: lc6433
 * @author: 郭晨旭
 * @create: 2023-05-14 10:53
 * @version: 1.0
 **/
public class lc6433 {
    public int maxMoves(int[][] grid) {
        int moves = 0;
        int m = grid.length, n = grid[0].length;
        int[][] vis = new int[m][n];
        Deque<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            queue.add(new int[] { i, 0, 0 });
        }
        int[][] step = new int[][] { { 1, 1 }, { 0, 1 }, { -1, 1 } };
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 3; ++i) {
                int nx = now[0] + step[i][0];
                int ny = now[1] + step[i][1];
                if (ok(m, n, nx, ny) && grid[nx][ny] > grid[now[0]][now[1]]) {
                    if (now[2] + 1 > vis[nx][ny]) {
                        queue.offer(new int[] { nx, ny, now[2] + 1 });
                        vis[nx][ny] = now[2] + 1;
                    }
                } else {
                    moves = Math.max(moves, now[2]);
                }
            }
        }
        return moves;
    }

    public boolean ok(int m, int n, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
