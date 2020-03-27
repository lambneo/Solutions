package leetCodes;

public class Interview10_II {

    public int JumpFloor(int n) {
        if (n <= 2)
            return n;
        int a = 1;
        int b = 2;
        int result = 0;
        for (int i = 2; i < n; i++) {
            result = (a + b) % 1000000007;
            b = a;
            a = result;
        }
        return result;
    }

}
