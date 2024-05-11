package lq;

import java.util.*;;

public class 进制转换 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String num = scanner.nextLine();
        int m = Integer.parseInt(scanner.nextLine());
        Long temp = Long.parseLong(num, n);
        System.out.println(Long.toString(temp, m).toUpperCase());
    }
}
