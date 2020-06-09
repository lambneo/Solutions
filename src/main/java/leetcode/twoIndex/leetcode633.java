package leetcode.twoIndex;

public class leetcode633 {
    public boolean judgeSquareSum(int c) {
        int r = (int) Math.sqrt(c);
        int l = 0;
        while (l <= r){
            if (l*l + r*r == c) return true;
            else if (l*l + r*r < c) l++;
            else r--;
        }
        return false;
    }

    public static void main(String[] args) {
        leetcode633 test = new leetcode633();
        System.out.println(test.judgeSquareSum(2));
    }

}
