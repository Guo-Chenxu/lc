package lq;

import java.util.*;

public class 有奖问答 {
    public static void main(String[] args) {
        A a = new A();
        a.dfs(0, 0);
        System.out.println(a.ans);
    }

}

class A {
    long ans = 0;

    public void dfs(int depth, int cur) {
        if (depth > 30) {
            return;
        }
        if (cur == 100) {
            return;
        }
        if (cur == 70) {
            ans++;
        }
        dfs(depth + 1, cur + 10);
        dfs(depth + 1, 0);
    }
}
