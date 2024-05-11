package lc;

class lc2373 {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; ++i) {
            for (int j = 0; j < n - 2; ++j) {
                res[i][j] = maxValue(i + 1, j + 1, grid);
            }
        }
        return res;
    }

    public int maxValue(int x, int y, int[][] grid) {
        int res = grid[x][y];
        res = Math.max(res, grid[x - 1][y]);
        res = Math.max(res, grid[x + 1][y]);
        res = Math.max(res, grid[x - 1][y - 1]);
        res = Math.max(res, grid[x + 1][y + 1]);
        res = Math.max(res, grid[x - 1][y + 1]);
        res = Math.max(res, grid[x + 1][y - 1]);
        res = Math.max(res, grid[x][y - 1]);
        res = Math.max(res, grid[x][y + 1]);
        return res;
    }
}