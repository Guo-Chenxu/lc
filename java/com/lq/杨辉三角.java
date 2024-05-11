package lq;

import java.util.*;

public class 杨辉三角 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] a = new int[n][n];
        a[0][0] = 1;
        for (int i = 1; i < n; i++) {
            a[i][0] = 1;
            for (int j = 1; j < n - 1; j++) {
                a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
            }
            a[i][n - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}