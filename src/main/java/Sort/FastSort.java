package Sort;


public class FastSort {
    public int[] fastSort(int[] arr){
        if (arr.length == 0) return new int[0];
        int l = 0, h = arr.length - 1;
        sort(arr, l, h);
        return arr;
    }

    /**
     * 快速选择
     * @param arr 输入数组
     * @param k 即第k大的数
     * @return
     */
    public int[] fastSelect(int[] arr, int k){
        if (arr.length == 0) return new int[0];
        int l = 0, h = arr.length - 1;
        while (h > l) {
            int j = partition(arr, l, h);
            if (j == k)
                break;
            if (j > k)
                h = j - 1;
            else
                l = j + 1;
        }
        return arr;
    }

    /**
     * 快排
     * @param arr
     * @param l
     * @param h
     */
    private void sort(int[] arr, int l, int h){
        if (h <= l) return;
        int j = partition(arr, l , h);
        sort(arr, l , j - 1);
        sort(arr, j + 1, h);
    }

    private void ThreewayQuicksort(int[] nums, int l, int h){
        if (h <= l) {
            return;
        }
        int lt = l, i = l + 1, gt = h;
        while (i <= gt) {
            if (nums[i] < nums[l]) {
                swap(nums, lt++, i++);
            } else if (nums[i] > nums[l]) {
                swap(nums, i, gt--);
            } else {
                i++;
            }
        }
        sort(nums, l, lt - 1);
        sort(nums, gt + 1, h);
    }


    private int partition(int[] arr, int l, int h){
        int q = arr[l];
        int i = l, j = h + 1;
        while (true){
            while (i != h && arr[++i] < q);
            while (j != l && arr[--j] > q);
            if(i >= j) break;
            swap(arr, i , j);
        }
        swap(arr, l , j);
        return j;
    }

    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        FastSort solo = new FastSort();
        int[] arr = {3,1,5,6,7,3,2};
//        int[] res = solo.fastSelect(arr, 5);
//        for(int i : res)
//            System.out.print(i + " ");
    }


}

