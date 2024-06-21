package lc;

import java.util.*;

public class lcp61 {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int res = 0, tmp = 0;
        for (int i = 1; i < temperatureA.length; i++) {
            if (cmp(temperatureA[i - 1], temperatureA[i]) - cmp(temperatureB[i - 1], temperatureB[i]) == 0) {
                tmp++;
            } else {
                res = Math.max(tmp, res);
                tmp = 0;
            }
        }
        return Math.max(tmp, res);
    }

    private int cmp(int a, int b) {
        if (a == b) {
            return 0;
        } else if (a < b) {
            return 1;
        } else {
            return -1;
        }
    }
}
