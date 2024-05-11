package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length - 1, n = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();
        int cnt = (m + 1) * (n + 1);
        int i = 0, j = 0, temp = 0;
        while (cnt > 0) {
            if (cnt == 1 && m == 0 && n == 0) {
                res.add(matrix[i][j]);
                cnt--;
            }
            for (temp = 0; cnt > 0 && temp < n; temp++) {
                res.add(matrix[i][j++]);
                cnt--;
            }
            for (temp = 0; cnt > 0 && temp < m; temp++) {
                res.add(matrix[i++][j]);
                cnt--;
            }
            for (temp = n; cnt > 0 && temp > 0; temp--) {
                res.add(matrix[i][j--]);
                cnt--;
            }
            for (temp = m; cnt > 0 && temp > 0; temp--) {
                res.add(matrix[i--][j]);
                cnt--;
            }
            i++;
            j++;
            m -= 2;
            n -= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] in = { { 1 } };
        System.out.println(new lc54().spiralOrder(in));
    }
}