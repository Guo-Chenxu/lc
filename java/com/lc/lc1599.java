package lc;

import java.util.HashMap;
import java.util.Map;

public class lc1599 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        if ((boardingCost << 2) < runningCost) {
            return -1;
        }
        int money = 0, res = 0, cycle = 1, people = 0, on = 0;
        for (int customer : customers) {
            people += customer;
            if (people > 0 && people <= 4) {
                on += people;
                people = 0;
            } else if (people > 4) {
                on += 4;
                people -= 4;
            }
            int temp = on * boardingCost - cycle * runningCost;
            if (temp > money) {
                money = temp;
                res = cycle;
            }
            ++cycle;
        }
        while (people > 0) {
            if (people > 0 && people <= 4) {
                on += people;
                people = 0;
            } else if (people > 4) {
                on += 4;
                people -= 4;
            }
            int temp = on * boardingCost - cycle * runningCost;
            if (temp > money) {
                money = temp;
                res = cycle;
            }
            ++cycle;
        }
        return res;
    }
}
