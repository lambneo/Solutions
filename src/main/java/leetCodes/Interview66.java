package leetCodes;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的
 * 元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 * 缕清先后逻辑
 */
public class Interview66 {
    public int[] constructArr(int arr[]){
        int left = 1, right = 1, n = arr.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = left;
            left *= arr[i];
        }

        for (int i = n - 1; i >=0; i--){
            ans[i] *= right;
            right *= arr[i];
        }

        return ans;

    }

    public static void main(String[] args) {
        Interview66 test = new Interview66();
        int[] ans = test.constructArr(new int[]{1,2,3,4,5});
        for (int i : ans)
            System.out.print(i + " ");
    }
}
