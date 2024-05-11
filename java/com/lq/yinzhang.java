package lq;

import java.util.Scanner;

public class yinzhang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
        double[][] arr = new double[m + 1][n + 1];

        double p = 1.0 / n;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= i && j <= n; j++) {
                if (j == 1) {
                    arr[i][j] = Math.pow(p, i - 1);
                } else {
                    arr[i][j] = arr[i - 1][j] * (j * 1.0 / n) + arr[i - 1][j - 1] * ((n - j + 1) * 1.0 / n);
                }
            }
        }

        System.out.printf("%.4f", arr[m][n]);
    }
}
