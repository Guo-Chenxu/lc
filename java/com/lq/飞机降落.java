package lq;

import java.util.*;

public class 飞机降落 {
    static int[] vis = new int[15];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            int t = scanner.nextInt();
            List<Plane> range = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                Plane p = new Plane();
                p.start = scanner.nextInt();
                p.end = scanner.nextInt();
                p.duration = scanner.nextInt();
                vis[i] = 0;
                range.add(p);
            }

            if (dfs(1, 0, range)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean dfs(int dep, int cur, List<Plane> range) {
        if (dep > range.size()) {
            return true;
        }
        for (int i = 0; i < range.size(); i++) {
            Plane p = range.get(i);
            if (vis[i] == 1 || cur > p.start + p.end) {
                continue;
            }
            vis[i] = 1;
            if (dfs(dep + 1, Math.max(cur, p.start) + p.duration, range)) {
                return true;
            }
            vis[i] = 0;
        }
        return false;
    }
}

class Plane {
    int start;
    int end;
    int duration;

    public Plane() {
    }
}