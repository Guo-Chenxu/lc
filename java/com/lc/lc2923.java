package lc;

public class lc2923 {
    public int findChampion(int[][] grid) {
        boolean flag = true;
        for (int i = 0; i < grid[0].length; i++) {
            flag = true;
            for (int j = 0; j < grid.length && flag; j++) {
                if (i != j && grid[j][i] == 1) {
                    flag = false;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    // public int findChampion(int[][] grid) {
    // for (int i = 0; i < grid.length; i++) {
    // int cnt = 0;
    // for (int j = 0; j < grid[0].length; j++) {
    // cnt += i != j ? grid[i][j] : 0;
    // }
    // if (cnt == grid.length - 1){
    // return i;
    // }
    // }
    // return -1;
    // }
}
