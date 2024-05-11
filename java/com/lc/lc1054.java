package lc;

/**
 * @program: exercise
 * @description: lc1054
 * @author: 郭晨旭
 * @create: 2023-05-14 13:12
 * @version: 1.0
 **/
public class lc1054 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length, j = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (barcodes[i] != barcodes[i + 1]) {
                continue;
            }
            j = i + 2;
            while (j < n && barcodes[j] == barcodes[i]) {
                ++j;
            }
            if (j == n) {
                break;
            }
            int temp = barcodes[i + 1];
            barcodes[i + 1] = barcodes[j];
            barcodes[j] = temp;
        }
        if (j < n) {
            return barcodes;
        }
        for (int i = n - 1; i > 0; --i) {
            if (barcodes[i] != barcodes[i - 1]) {
                continue;
            }
            j = i - 2;
            while (j > 0 && barcodes[i] == barcodes[j]) {
                --j;
            }
            if (j < 0) {
                break;
            }
            int temp = barcodes[i - 1];
            barcodes[i - 1] = barcodes[j];
            barcodes[j] = temp;
        }
        return barcodes;
    }
}
