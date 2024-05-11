package lc;

public class lc50 {
    public double myPow(double x, int n) {
        double res = 1.0;
        for (long i = n > 0 ? n : -1L * n; i > 0; i >>= 1) {
            if ((i & 1) != 0) {
                res *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }
}
