package lq;

import java.util.*;

public class 奖学金 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer[]> scores = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tot = 0;
            String[] split = scanner.nextLine().split(" ");
            Integer[] temp = new Integer[5];
            temp[0] = i + 1;
            for (int j = 0; j < 3; j++) {
                temp[j + 1] = Integer.parseInt(split[j]);
                tot += Integer.parseInt(split[j]);
            }
            temp[4] = tot;
            scores.add(temp);
        }

        scores.sort((o1, o2) -> {
            if (!o1[4].equals(o2[4])) {
                return o2[4] - o1[4];
            }
            if (!o1[1].equals(o2[1])) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        for (int i = 0; i < Math.min(5, scores.size()); i++) {
            System.out.println(scores.get(i)[0] + " " + scores.get(i)[4]);
        }
    }
}
