package lc;

class lc05_02 {
    public String printBin(double num) {
        StringBuilder ans = new StringBuilder("0.");
        for (int i = 0; i < 30 && num != 0; ++i) {
            num += num;
            if (num >= 1) {
                num -= 1;
                ans.append("1");
            } else {
                ans.append("0");
            }
        }
        if (num == 0) {
            return ans.toString();
        } else {
            return "ERROR";
        }
    }
}