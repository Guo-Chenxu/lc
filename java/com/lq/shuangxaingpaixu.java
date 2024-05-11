package lq;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class shuangxaingpaixu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int m = Integer.parseInt(s[0]), n = Integer.parseInt(s[1]);
        Integer[] arr = new Integer[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < m; i++) {
            String[] s1 = scanner.nextLine().split(" ");
            int p = Integer.parseInt(s1[0]), q = Integer.parseInt(s1[1]);
            if (p == 0) {
                Arrays.sort(arr, 1, q + 1, (o1, o2) -> o2 - o1);
            } else if (p == 1) {
                Arrays.sort(arr, q, n + 1);
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
