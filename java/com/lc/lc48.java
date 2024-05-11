package lc;

public class lc48 {
    public void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < (n >> 1); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][m - i - 1];
                matrix[n - j - 1][m - i - 1] = temp;
            }
        }
    }
}
