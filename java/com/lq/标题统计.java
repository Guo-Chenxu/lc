package lq;

import java.util.Scanner;

public class 标题统计 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int cnt = 0;
        for (Character c : s.toCharArray()) {
            if (c != ' ' && c != '\t' && c != '\n') {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
