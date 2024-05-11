package lc;

import java.util.Arrays;

public class lc2383 {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int len = energy.length;
        int ans = 0;
        for (int i = 0; i < len; ++i) {
            if (initialEnergy <= energy[i]) {
                int t = energy[i] - initialEnergy + 1;
                initialEnergy = energy[i] + 1;
                ans += t;
            }
            initialEnergy -= energy[i];
            if (initialExperience <= experience[i]) {
                int t = experience[i] - initialExperience + 1;
                ans += t;
                initialExperience += t;
            }
            initialExperience += experience[i];
        }
        return ans;
    }
}
