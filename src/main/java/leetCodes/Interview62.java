package leetCodes;



public class Interview62 {
    public int lastRemaining(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++)
            ans = (ans + m) % i;
        return ans;
    }


    public static void main(String[] args) {
        Interview62 test = new Interview62();
        System.out.print(test.lastRemaining(5, 3));
    }
}
