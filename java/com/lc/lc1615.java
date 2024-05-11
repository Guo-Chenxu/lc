package lc;

import java.util.ArrayList;
import java.util.List;

public class lc1615 {
    // 贪心
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] map = new int[n + 1][n + 1];
        int[] rs = new int[n + 1];
        for (int[] road : roads) {
            map[road[0]][road[1]] = 1;
            map[road[1]][road[0]] = 1;
            ++rs[road[0]];
            ++rs[road[1]];
        }
        List<Integer> firstArr = new ArrayList<>();
        List<Integer> secondArr = new ArrayList<>();
        int fi = -1, se = -1;
        for (int i = 0; i < n; ++i) {
            if (rs[i] > fi) {
                fi = i;
                secondArr = new ArrayList<>(firstArr);
                firstArr.clear();
                firstArr.add(i);
            } else if (rs[i] == fi) {
                firstArr.add(i);
            } else if (rs[i] > se) {
                se = rs[i];
                secondArr.clear();
                secondArr.add(i);
            } else if (rs[i] == se) {
                secondArr.add(i);
            }
        }
        if (firstArr.size() == 1) {
            int x = firstArr.get(0);
            for (int y : secondArr) {
                if (map[x][y] != 1) {
                    return fi + se;
                }
            }
            return fi + se - 1;
        } else {
            for (int x : firstArr) {
                for (int y : firstArr) {
                    if (map[x][y] != 1) {
                        return fi + fi;
                    }
                }
            }
            return fi + fi - 1;
        }
    }

    // 枚举
    public int myMaximalNetworkRank(int n, int[][] roads) {
        int[][] map = new int[n + 1][n + 1];
        int[] rs = new int[n + 1];
        int len = roads.length;
        for (int[] road : roads) {
            map[road[0]][road[1]] = 1;
            map[road[1]][road[0]] = 1;
            ++rs[road[0]];
            ++rs[road[1]];
        }
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                if (rs[i] + rs[j] > ans) {
                    ans = rs[i] + rs[j];
                    if (map[i][j] == 1) {
                        --ans;
                    }
                }
            }
        }
        return ans;
    }
}
