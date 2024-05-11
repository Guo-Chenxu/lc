package lq;

import java.util.*;

public class 分数线划定 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int n = Integer.parseInt(split[0]), m = Integer.parseInt(split[1]);
        List<Integer[]> scores = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            split = scanner.nextLine().split(" ");
            int a = Integer.parseInt(split[0]), b = Integer.parseInt(split[1]);
            scores.add(new Integer[] { a, b });
        }
        scores.sort((o1, o2) -> {
            if (!o1[1].equals(o2[1])) {
                return o2[1] - o1[1];
            }
            return o1[0].compareTo(o2[0]);
        });

        m = m + (m >> 1);
        int score = scores.get(m - 1)[1];
        List<Integer[]> ans = new ArrayList<>();
        for (int i = 0; i < scores.size() && scores.get(i)[1] >= score; i++) {
            ans.add(scores.get(i));
        }
        System.out.println(score + " " + ans.size());
        ans.forEach((e) -> System.out.println(e[0] + " " + e[1]));
    }
}
