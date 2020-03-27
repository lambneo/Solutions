package leetCodes;

/**
 * 最小k数
 * 涉及到基本的排序算法
 */
public class Interview40 {
    public int[] getLeastNumbers(int[] arr, int k) {

        return null;
    }

    private int[] fastSort(int[] arr, int k) {
        int[] ret = new int[k];
        if (k > arr.length || k <= 0)
            return ret;
        findKthSmallest(arr, k - 1);
        /* findKthSmallest 会改变数组，使得前 k 个数都是最小的 k 个数 */
        for (int i = 0; i < k; i++)
            ret[i] = arr[i];
        return ret;

    }

    public void findKthSmallest(int[] arr, int k) {
        int l = 0, h = arr.length - 1;
        while (l < h) {
            int j = partition(arr, l, h);
            if (j == k)
                break;
            if (j > k)
                h = j - 1;
            else
                l = j + 1;
        }
    }

    private int partition(int[] arr, int l, int h) {
        int p = arr[l];     /* 切分元素 */
        int i = l, j = h + 1;
        while (true) {
            while (i != h && arr[++i] < p) ;
            while (j != l && arr[--j] > p) ;
            if (i >= j)
                break;
            swap(arr, i, j);
        }
        swap(arr, l, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Interview40 s = new Interview40();
        int[] res = s.fastSort(new int[]{10, 8, 2, 1, 18, 11}, 6);
        for (int i : res){
            System.out.print(i + " ");
        }
    }
}
